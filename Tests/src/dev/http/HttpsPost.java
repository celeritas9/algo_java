/**
 * 
 */
package dev.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.protocol.HTTP;

/**
 * @author dshah
 *
 */
public class HttpsPost
{
	private static final String START_FORM_TAG = "<form";
	private static final String END_FORM_TAG = "</form>";
	private static final String START_INPUT = "<input type=";
	private static final String START_INPUT_HIDDEN = START_INPUT+"\"hidden\" ";
	private static final String END_TAG = "/>";
	private static final String END = ">";
    public static void main(String[] args)
    {
		String cuki=new String();
		HttpsURLConnection connection = null;
		URL url = null;
		try
		{
			//System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
			//int addProvider = java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			//String query = "nameentered=" + URLEncoder.encode("devang", "UTF-8");
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String orderId = timeStamp+"0";
			String merchantId = "50418";
			String amount = "20";
			String apiToken = "0Wrg336gJLgDJ1y0";
			String toHash = orderId+"|"+amount+"|"+timeStamp+"|"+apiToken;
			String hash = getHash(toHash).toString();
			String recurringCharge = "false";
			String addToStorage = "false";
			String storageTokenId = "test-token";
			String stringUrl = "https://test.admeris.com/ccgateway/cc/processor.do";
			HashMap<String, String> requestMap = new HashMap<String, String>();
			requestMap.put("merchantId", merchantId);
			requestMap.put("requestCode", "singlePurchase");
			requestMap.put("hash", hash);
			requestMap.put("timeStamp", timeStamp);
			requestMap.put("marketSegmentCode", "I");
			requestMap.put("orderId", orderId);
			requestMap.put("amount", amount);
			requestMap.put("recurringCharge", recurringCharge);
			requestMap.put("storageTokenId", storageTokenId);
			requestMap.put("addToStorage", addToStorage);
			
			//Create request string from requestMap
			StringBuffer requestStringBuffer = createRequestStringFromMap(requestMap);
			//System.setProperty("java.protocol.handler.pkgs", "HTTPClient");
			//StringBuffer requestStringBuffer = createRequestStringBufferXmlFromMap(requestMap, stringUrl);
			System.out.println("Request String: "+requestStringBuffer);
			
			url = new URL(stringUrl);
			//HttpsURLConnection c = (HttpsURLConnection)Connector.open(stringUrl);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod(/*HttpConnectionParams.*/"POST");
			connection.setRequestProperty("Content-length",String.valueOf (requestStringBuffer.length()));
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			connection.setFollowRedirects(true);


			//connection.setRequestProperty("Accept-Language","it"); 
			//connection.setRequestProperty("Accept", "application/cfm, image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, image/png, //*/*"); 
			//connection.setRequestProperty("Accept-Encoding","gzip"); 

			//open up the output stream of the connection 
			DataOutputStream output = new DataOutputStream( connection.getOutputStream() ); 

			//write out the data 
			//int queryLength = query.length(); 
			output.writeBytes( requestStringBuffer.toString() ); 
			//output.close();

			System.out.println("Resp Code:"+connection.getResponseCode()); 
			System.out.println("Resp Message:"+ connection.getResponseMessage()); 

			//get ready to read the response from the cgi script 
			DataInputStream input = new DataInputStream( connection.getInputStream() ); 

			//read in each character until end-of-stream is detected 
			for( int c = input.read(); c != -1; c = input.read() ) 
				System.out.print( (char)c ); 
			input.close(); 
		} 
		catch(Exception e) 
		{ 
			System.out.println( "Something bad just happened." ); 
			System.out.println( e ); 
			e.printStackTrace(); 
		}
		finally
		{
			connection.disconnect();
		}
    }
    
    private static StringBuffer createRequestStringBufferXmlFromMap(HashMap<String, String> requestMap, String url)
    {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(START_FORM_TAG).append(" method=\"post\"").append(" action=\""+url+"\""+END+"\n");
    	for(Object s : requestMap.keySet())
    	{
    		String value = (String)requestMap.get(s);
    		buffer.append(START_INPUT_HIDDEN).append("name=\"").append((String)s).append("\" ").append("value=\"").append(value).append("\"").append(END_TAG).append("\n");
    	}
    	//buffer.append(START_INPUT_HIDDEN).append("name=\"redirectUrl\" ").append("value=\"").append("").append(END_TAG).append("\n");
    	buffer.append(START_INPUT).append("\"submit\" ").append("value=\"").append("Submit Form").append(END_TAG).append("\n");
    	buffer.append(END_FORM_TAG);
		return buffer;
	}

	private static StringBuffer createRequestStringFromMap(HashMap<String, String> requestMap) 
	{
		StringBuffer requestStringBuffer = new StringBuffer();
		Collection keySet = requestMap.keySet();
		for(Object keyObject: keySet)
		{
			String key = "";
			String value = "";
			try
			{
				key = URLEncoder.encode((String)keyObject, HTTP.UTF_8);
				value = URLEncoder.encode(requestMap.get(key), HTTP.UTF_8);
				requestStringBuffer.append(key + "=" + value + "&");
			}
			catch(UnsupportedEncodingException uee)
			{
				System.out.println("key: "+key+" value: "+value+" pair cannot be encoded");
			}
		}
		return requestStringBuffer;
	}
    
    private static StringBuilder getHash(String toHash)
    {
    	//String toHash = "order-123|1000|20100110123000|a3fer6321asdf1HY";
    	StringBuilder hexCode = null;
        try 
        { 
            MessageDigest digest = MessageDigest.getInstance("SHA-1"); 
            digest.update(toHash.toString().getBytes()); 
            byte[] hashCode = digest.digest(); 
            // convert to hex String 
            hexCode = new StringBuilder(); 
            for(int i = 0; i < hashCode.length; i++) 
            { 
                if((hashCode[i]&0x00ff) <= 0x000f)
                { 
                    hexCode.append("0"+Integer.toHexString(0x00ff&hashCode[i])); 
                } 
                else
                { 
                    hexCode.append(Integer.toHexString(0x00ff&hashCode[i])); 
                }
            }
            System.out.println(hexCode.toString());
        }
        catch (Exception e)
        { 
            System.out.println(e);    
        }
        return hexCode;
    }
}
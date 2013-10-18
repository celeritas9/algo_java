package dev.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.SSLSocketFactory;

/**
 * @author dshah
 *
 */
public class CustomHttpsClient
{
    public final static void main(String[] args) throws Exception
    {
    	SimpleLog sl = new SimpleLog(CustomHttpsClient.class.getName());
    	sl.debug("");
    	HttpParams params = new BasicHttpParams();
        params.setParameter(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME, ClientConnectionManagerFactoryImpl.class.getName());
        //HttpConnectionParams.setConnectionTimeout(params, 1);
        //HttpConnectionParams.setSoTimeout(params, 1000);
        DefaultHttpClient httpclient = new DefaultHttpClient(/*new ThreadSafeClientConnManager(),*/ params);
        long startTime = 0;
        
        try
        {
            /*KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream instream = new FileInputStream(new File("C:\\redknee\\my.keystore"));
            try
            {
            	For now using null for the input stream and password
                trustStore.load(null instream, null"nopassword".toCharArray());
            }
            finally 
            {
                try { instream.close(); } catch (Exception ignore) {}
            }*/

            SSLSocketFactory socketFactory = new SSLSocketFactory(/*trustStore*/new TrustSelfSignedStrategy());
            Scheme sch = new Scheme("https", 443, /*socketFactory*/SSLSocketFactory.getSocketFactory());
            httpclient.getConnectionManager().getSchemeRegistry().register(sch);
            //String stringUrl = "https://test.admeris.com/ccgateway/cc/processor.do";
            String stringUrl = "https://loadtest.admeris.com/platform2/gateway/processor.do";
            HttpPost httppost = new HttpPost(stringUrl);
            
            /*PostTask[] postTask = new PostTask[5000];
            for(int i = 0; i < 5000; i++)
            {
            	postTask[i] = new PostTask(httppost, httpclient);
            	System.out.println("Task "+i+" created.");
            }*/

            System.out.println("executing request" + httppost.getRequestLine());
            
            /*Data that needs to be sent to PG*/
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String orderId = timeStamp+"0";
			String amount = "20";
			String apiToken = "0Wrg336gJLgDJ1y0";
			String toHash = orderId+"|"+amount+"|"+timeStamp+"|"+apiToken;
			String hash = getHash(toHash).toString();
			String recurringCharge = "false";
			String addToStorage = "false";
			//String storageTokenId = "f276bc7c-1866-4880-98f9-ef2a954623b3";
			String storageTokenId = "805ea8f8-4df9-4603-9551-89298a0229eb";
			
			/*Create a temporary map and put the values*/
			HashMap<String, String> requestMap = new HashMap<String, String>();
			requestMap.put("merchantId", "50418");
			requestMap.put("requestCode", "singlePurchase");
			//requestMap.put("hash", hash);
			requestMap.put("timeStamp", timeStamp);
			requestMap.put("marketSegmentCode", "I");
			requestMap.put("orderId", orderId);
			requestMap.put("amount", amount);
			requestMap.put("recurringCharge", recurringCharge);
			requestMap.put("storageTokenId", storageTokenId);
			requestMap.put("addToStorage", addToStorage);
			requestMap.put("apiToken", apiToken);
            
            List<BasicNameValuePair> entityList = new ArrayList<BasicNameValuePair>();
            entityList = createEntityListFromRequestMap(entityList, requestMap);
            
            UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(entityList, HTTP.UTF_8);
            httppost.setEntity(requestEntity);
            startTime = System.currentTimeMillis();
            System.out.println("startTime: "+startTime);
            HttpResponse response = httpclient.execute(httppost);
            System.out.println("executeComplete in: "+(System.currentTimeMillis() - startTime) +" millis");
            HttpEntity responseEntity = response.getEntity();
            if(response.getStatusLine().toString().contains("404"))
            {
            	System.out.println("URL not valid.");
            	throw new IllegalArgumentException();
            }

            System.out.println("----------------------------------------");

            BufferedReader reader = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while((readLine = reader.readLine()) != null)
            {
            	System.out.println("readline: "+readLine);
            	sb.append(readLine+"|");
            }
            reader.close();
            System.out.println("----------------------------------------");
            System.out.println("sb: "+sb.toString()+" \nlength: "+sb.toString().split("\\|").length);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            if (responseEntity != null)
            {
                System.out.println("Response content length: " + responseEntity.getContentLength());
                System.out.println("Chunked? " + responseEntity.isChunked());
                System.out.println("Response: " + responseEntity.toString());
            }
        }
        finally 
        {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
            System.out.println("totalTime: "+(System.currentTimeMillis() - startTime));
        }
    }
    
	private static List<BasicNameValuePair> createEntityListFromRequestMap(List<BasicNameValuePair> entityList, HashMap<String, String> requestMap)
    {
    	for(Object key : requestMap.keySet())
    	{
    		entityList.add(new BasicNameValuePair((String)key, requestMap.get(key)));
    	}
		return entityList;
	}

	private static StringBuffer getHash(String toHash)
    {
    	//String toHash = "order-123|1000|20100110123000|a3fer6321asdf1HY";
    	StringBuffer hexCode = null;
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-1"); 
            digest.update(toHash.toString().getBytes()); 
            byte[] hashCode = digest.digest(); 
            // convert to hex String 
            hexCode = new StringBuffer(); 
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
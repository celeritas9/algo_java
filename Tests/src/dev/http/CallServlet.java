/**
 * 
 */
package dev.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


/**
 * @author dshah
 *
 */
public class CallServlet {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		URL url = new URL("http://localhost:8080/mywebapp/MyWebServlet");
		
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		/*When we say URL encoded - the data is expected in input stream*/
		connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		String query = "nameentered=" + URLEncoder.encode("devang", "UTF-8")
					  +"&ageentered=" + URLEncoder.encode("43", "UTF-8");
		DataOutputStream output = new DataOutputStream(connection.getOutputStream());
		output.write(query.toString().getBytes());
		
		System.out.println("Resp Code:"+connection.getResponseCode()); 
		System.out.println("Resp Message:"+ connection.getResponseMessage()); 

		//get ready to read the response from the cgi script 
		DataInputStream input = new DataInputStream( connection.getInputStream() ); 

		//read in each character until end-of-stream is detected 
		for( int c = input.read(); c != -1; c = input.read() ) 
			System.out.print( (char)c ); 
		input.close();
	}

}

/**
 * 
 */
package dev.http;

import java.io.BufferedReader;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;


/**
 * @author dshah
 *
 */
public class PostMethodExample
{
	public static void main(String args[])
	{
	    HttpClient client = new DefaultHttpClient();
	    //client.getParams().setParameter("http.useragent", "Test Client");

	    BufferedReader br = null;
/*
	    HttpPost method = new HttpPost("http://search.yahoo.com/search");
	    method.getParams().setParameter(arg0, arg1);
	    method.
	    HttpEntity entity = new StringEntity();
	    //method.addParameter("p", "\"java2s\"");

	    try{
	      int returnCode = client.executeMethod(method);

	      if(returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
	        System.err.println("The Post method is not implemented by this URI");
	        // still consume the response body
	        method.getResponseBodyAsString();
	      } else {
	        br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
	        String readLine;
	        while(((readLine = br.readLine()) != null)) {
	          System.err.println(readLine);
	      }
	      }
	    } catch (Exception e) {
	      System.err.println(e);
	    } finally {
	      method.releaseConnection();
	      if(br != null) try { br.close(); } catch (Exception fe) {}
	    }
*/
	  }

}

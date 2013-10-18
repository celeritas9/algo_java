package dev.http.task;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

public class PostTask implements Runnable
{
	static int id = 0;
	private HttpPost postMethod;
	private HttpClient client;
	
	public PostTask(HttpPost post, HttpClient client)
	{
		this.postMethod = post;
		this.client = client;
	}
	
	@Override
	public void run() 
	{
		
	}
}

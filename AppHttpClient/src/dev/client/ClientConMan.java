package dev.client;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

public class ClientConMan 
{
	private ClientConMan()
	{
		
	}
	
	public static ClientConnectionManager getInstance()
	{
		if(conman == null)
		{
			Scheme schemeHttps = new Scheme("https", 443, SSLSocketFactory.getSocketFactory());
			Scheme schemeHttp = new Scheme("http", 80, PlainSocketFactory.getSocketFactory());
			SchemeRegistry schemeRegistry = new SchemeRegistry();
			schemeRegistry.register(schemeHttps);
			schemeRegistry.register(schemeHttp);
			conman = new ThreadSafeClientConnManager(schemeRegistry);
		}
		
		return conman;
	}
	
	private static ClientConnectionManager conman;
}

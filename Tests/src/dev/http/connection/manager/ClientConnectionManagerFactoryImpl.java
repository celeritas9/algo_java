package dev.http.connection.manager;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;



public class ClientConnectionManagerFactoryImpl implements ClientConnectionManagerFactory
{

	@Override
	public ClientConnectionManager newInstance(HttpParams params, SchemeRegistry schemeRegistry)
	{
		System.out.println("Returning new ClientConnectionManager");
		return new ThreadSafeClientConnManager(params, schemeRegistry);
	}
	
}

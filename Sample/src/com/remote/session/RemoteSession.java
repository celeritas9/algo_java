/**
 * 
 */
package com.remote.session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * @author dshah
 *
 */
public class RemoteSession
{

	public static void main(String[] args) throws IOException
	{
		String host = "jay";
		String userName = "rkadm";
		String password = "rkadm";
		
		Connection c = new Connection(host);
		Connection c1 = new Connection(host);
		c.connect();
		
		if(!c.authenticateWithPassword(userName, password))
		{
			System.out.println("Could not connect to host " +host+ " with username: " +userName+ " and password " +password);
		}
		
		System.out.println("Conneciton c authentication completion: " +c.isAuthenticationComplete());
		System.out.println("Conneciton c1 authentication completion: " +c1.isAuthenticationComplete());
		
		Session session = c.openSession();
		session.execCommand("cd /opt/redknee/user/dshah && ./testScript 11");
		InputStream stdout = new StreamGobbler(session.getStdout());

		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
		String line = "";
		
		while(true)
		{
		    line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
			
			if(line.trim().contains("exit"))
				break;
		}
		System.out.println(session.getExitStatus());
	}

}

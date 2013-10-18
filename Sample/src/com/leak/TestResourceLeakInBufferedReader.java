/*
 * This code is a protected work and subject to domestic and international
 * copyright law(s).  A complete listing of authors of this work is readily
 * available.  Additionally, source code is, by its very nature, confidential
 * information and inextricably contains trade secrets and other information
 * proprietary, valuable and sensitive to Redknee.  No unauthorized use,
 * disclosure, manipulation or otherwise is permitted, and may only be used
 * in accordance with the terms of the license agreement entered into with
 * Redknee Inc. and/or its subsidiaries.
 *
 * Copyright (c) Redknee Inc. and its subsidiaries. All Rights Reserved.
 */
package com.leak;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

/**
 * @author dshah
 * @since 
 */
public class TestResourceLeakInBufferedReader
{
	private static Map<String, Connection> liveConnections = new HashMap();
	
	public static void main(String[] args) throws Exception
	{
		String command = getCommandToExecute();
		Connection con = getConnection("kay", "rkadm", "rkadm");
		Session session = con.openSession();
		session.execCommand(command);
		
		//String erList = "760,1104,1136,761,773,771";
		String erList = "3070,3099,3080,3081,3074,3099,3099,3099,3099,3099";
		
		Runnable task = new PrerequisiteTask(session, erList);
		Thread pollerThread = new Thread(task);
		pollerThread.start();
		
		synchronized(task)
		{
			System.out.println("Waiting for the prerequisite task to poll all the ers in the list.");
			task.wait();
		}
	}
	
	private static String getCommandToExecute()
	{
		//return "cd /opt/redknee/test/tat/script-diana && ./devTestMiss start 1 \"XYZ\"";
		return "cd /opt/redknee/test/tat/script-e2e && ./tailNgrcLog start 1 \"XYZ\"";
		//return "cd /opt/redknee/test/tat/script-e2e && ./devTestMiss start 1 \"XYZ\"";
	}

	private static Connection getConnection(String hostName, String userName, String password) throws IOException
	{
		Connection con = liveConnections.get(hostName);
		
		if(con != null && con.isAuthenticationComplete())
		{
			return con;
		}
		else
		{
			con = new Connection(hostName);
			con.connect();
			con.authenticateWithPassword(userName, password);
			liveConnections.put(hostName, con);
		}
		
		return con;
	}
}

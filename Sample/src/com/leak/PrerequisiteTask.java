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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * This task is a prerequisite task, used to read the output of the session in background.
 * 
 * @author dshah
 * @since 
 */
public class PrerequisiteTask implements Runnable
{
	/**
	 * The session is used to read the output of a session.
	 */
	Session session;
	String erList;
	
	public PrerequisiteTask(Session session_, String erList_)
	{
		super();
		session = session_;
		erList = erList_;
	}

	public void run()
	{
		InputStream is = new StreamGobbler(session.getStdout());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String ers[] = erList.split(",");
		ArrayList<String> erList = convertToList(ers);
		try
		{
			String line = br.readLine();
			System.out.println("Start: Size of the er list is: " +erList.size());
			while(line != null)
			{
				System.out.println("ER: "+line);
				String[] erElements = line.split(",");
				
				if(erElements.length >= 3)
			    {
					if(erList.contains(erElements[2]))
					{
			    		erList.remove(erElements[2]);
					}
			    }
				//If all the ers are found then stop polling. Else poll until times out.
				if(erList.isEmpty())
					break;
				line = br.readLine();
			}
			br.close();
			System.out.println("End: Size of the er list is: " +erList.size());
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		finally
		{
			synchronized(this)
			{
				System.out.println("Notifying the main thread of completion of the prerequisite task.");
				notify();
			}
		}
	}
	
	/**
	 * @param ers
	 * @return
	 */
	private ArrayList<String> convertToList(String[] ers)
	{
		ArrayList<String> list = new ArrayList();
		
		for(String s : ers)
		{
			list.add(s);
		}
		
		return list;
	}
}

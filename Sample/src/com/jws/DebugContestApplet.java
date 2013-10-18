package com.jws;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import netx.jnlp.JNLPFile;
import netx.jnlp.LaunchException;
import netx.jnlp.Launcher;
import netx.jnlp.ParseException;
import netx.jnlp.runtime.ApplicationInstance;

public class DebugContestApplet
{

	public static void main(String[] args) throws MalformedURLException, LaunchException, 
												IOException, ParseException
	{
		Launcher launcher = new Launcher();
		ApplicationInstance instance = launcher.launch(new JNLPFile
				(new URL("http://www.topcoder.com/contest/arena/ContestAppletProd.jnlp")));
	}
}

package com.hashcode;

import java.text.DateFormat;

/**
 * @author dshah
 * @since 
 */
public class TestObject
{
	public String test = "";
	public StringBuffer strbuff;
	public DateFormat dateFormat;
	
	public TestObject(String str, StringBuffer buff, DateFormat format)
	{
		test = str;
		strbuff = buff;
		dateFormat = format;
	}
}

package com.dateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		System.out.println(format.format("2012/08/27 13:12:19"));
	}

}

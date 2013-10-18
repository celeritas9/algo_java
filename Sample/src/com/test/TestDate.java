package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import sun.util.resources.LocaleNames;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*String dte = "20110106";
		String time = "100000";
		String dte2 = "20110106";
		String time2 = "000000";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd HHmmss");
		Date d = null;
		Date d2 = null;
		try {
			d = sf.parse(dte+" "+time);
			d2 = sf.parse(dte2+" "+time2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d);
		long l = d.getTime();
		System.out.println(d.getTime() - d2.getTime());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		System.out.println(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));*/
		
		long ret_date = 1331856000000l;
		
		System.out.println("Retirement date is: "+new Date(ret_date));
		System.out.println("expiry date is: "+new Date(1331942400000l));
		long date2 = new Date(2012, 3, 16, 10,45,14).getTime();
		long millisInDay = 24*60*60*1000;
		double days = (int)(millisInDay/(date2-ret_date));
		
		System.out.println(days);
	}
}

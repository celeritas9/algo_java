/**
 * 
 */
package com.create.unique.transactionId;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dshah
 * 
 * TODO: 
 * CLR	 1. A concern: Would it impact overall tps of Payment Gateway (PG) communication? No.
 * 
 * A utility class to 
 * 1. createSequentialOrderId 	 		-> This method creates transactionId from the timeStamp and suffix count at that time. 
 * 										   It simply concatenates the two strings.
 * 2. createMapFromResponseStringBldr 	-> Creates map from the pipe separated response containing PG response fields.
 * 
 * Developer's note: Please brief here any utility method you write in future.
 */
public class TaskUtility
{
	/**
	 * @param String timeStamp - format: yyyyMMddHHmmss
	 * @return String orderId
	 * 
	 * Returns unique orderId
	 * OrderId format: timeStamp<format:yyyyMMddHHmmss>suffix<range:0-999999>
	 * Maximum length: 20 chars ("yyyyMMddHHmmss"	= 14 chars
	 * 							  MAX_LONG_SUFFIX -1=  6 chars (max length)
	 * 							  ----------------------------------------
	 * 							  Total:			  20 chars)
	 * e.g. For a particular timestamp: 20120312165659 sample ids are
	 * 		20120312165659000000
	 * 		20120312165659000001
	 * 		...
	 * 		20120312165659999999
	 **/
	public static String createSequentialOrderId(String timeStamp)
	{
		synchronized(suffix)
		{
			/* Assumes max request per second is less than 1000000 (1M).
			 * After every 1M requests, the suffix(starts from 0) will repeat in the orderId, but since 1M is fairly large number, it's barely possible that
			 * the same orderId is repeated twice.
			 * Note: If requests per second is more than 1M than the modulus(right hand side) operand should be more than 1000000(1M). 
			 * */
			if(suffix == MAX_LONG_SUFFIX)
			{
				suffix = 0l;
			}
			return timeStamp+createFixedLengthSuffix(suffix++ % MAX_LONG_SUFFIX).toString();
		}
	}
	
	/**
	 * @param StringBuilder response
	 * @return HashMap
	 * 
	 * This method converts pipe separated StringBuilder to map.
	 * It splits each pipe separated value in StringBuilder with "=" and creates a map with 0th and 1st index in split array and puts it in Map.
	 * e.g. APPROVED=true, then it will store ("APPROVED", true) in the map.
	 */
	public static Map createMapFromResponseStringBldr(String response) 
	{
		Map responseMap = new HashMap();
		String[] responseArray = response.split("\\|");
		for(String s: responseArray)
		{
			String[] sArr = s.split("=");
			responseMap.put(sArr[0], sArr[1]);
		}
		return responseMap;
	}

	/**
	 * @param long number
	 * @return StringBuilder suffix
	 */
	private static StringBuilder createFixedLengthSuffix(long number)
	{
		StringBuilder suffix = new StringBuilder();
		suffix.append(number);
		/*Since we are using modulus operator from where it is called it will have max length as length of MAX_LONG_SUFFIX - 1*/
		int padLength = String.valueOf(MAX_LONG_SUFFIX).length() - 1;
		
		//Pad the number with 0s on left.
		while(padLength > suffix.length())
		{
			suffix.insert(0, "0");
		}
		return suffix;
	}
	
	private static Long suffix = 0l;
	private static long MAX_LONG_SUFFIX = 1000000l;
	private static final String CLASS_NAME = TaskUtility.class.getName();
	
	public static void main(String[] args) throws Exception
	{
		Writer writer = null;
		File f = new File("C:\\redknee\\orderIds2.txt");
		FileWriter fw = new FileWriter(f);
		writer = new BufferedWriter(fw);
		for(long i = 0; i < MAX_LONG_SUFFIX; i++)
		{
			writer.write(createSequentialOrderId(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()))+"\n");
			//writer.write(createFixedLengthSuffix(suffix++ % MAX_LONG_SUFFIX).toString()+"\n");
			//System.out.println(i+":"+createSequentialOrderId(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())));
		}
		writer.close();
		/*System.out.println(createFixedLengthSuffix(0));
		System.out.println(createFixedLengthSuffix(1000));
		System.out.println(createFixedLengthSuffix(999999));*/
		System.out.println("End");
	}
}


/**
 * 
 */
package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dshah
 *
 */
public class PatterMatcher
{
	public static void main(String[] args)
	{
		String ALNUM_REGEX = "^[a-zA-Z0-9]{1,128}$";		/*Alphanumeric field with, 1 <= length <= 128*/
	    String NUMERIC_REGEX = "1[0-2]|[0-9]";					/*Numeric field with length = 4*/
	    String ANY_REGEX = ".+";
	    String ALPHABETS_REGEX = "^[a-zA-Z_]{1,128}$";
	    String MSISDN_REGEX = "[0-9]{1,20}";
	    String lengthRegex = "^[a-z][^7]$";
	    String aOrb = "a|b";
	    String number = "[\\d{1,}\\-\\d{1,}]||[\\d{1,}]";
	    String NUMERIC_REGEX_ONE_PLUS_LENGTH = "[ 0-9]+";
	    
	    Pattern p = Pattern.compile(NUMERIC_REGEX);
	    System.out.println(p.matcher("1").matches());
	    
	    Pattern aOrbPattern = Pattern.compile(aOrb);
	    System.out.println(p.matcher("a").matches());
		/*Pattern alphaNum = Pattern.compile("MSISDN");
		Matcher m = alphaNum.matcher("MSISDN");
		
		boolean isMatched = m.matches();*/
		
		//System.out.println(isMatched);
	}
}

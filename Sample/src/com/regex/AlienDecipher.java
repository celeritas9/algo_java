package com.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienDecipher
{

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		File file = new File("C:\\input\\A-small-practice.in");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		Map dictionary = new HashMap();
		
		String firstLine = null;
		firstLine = reader.readLine();
		
		String[] input = firstLine.split(" ");
		int L = Integer.parseInt(input[0]);
		int D = Integer.parseInt(input[1]);
		int N = Integer.parseInt(input[2]);
		
		//Read next D tokens in dictionary.
		for(int i = 0; i < D; i++)
		{
			dictionary.put(i, reader.readLine());
		}
		
		//Read next N testcases in list.
		List testCases = new ArrayList();
		for(int i = 0; i < N; i++)
		{
			testCases.add(reader.readLine());
		}
		
		for(Object string:testCases)
		{
			long numberOfPossibleCombinations = calculateCombinations((String)string);
			System.out.println("no. " + numberOfPossibleCombinations);
		}
		
		/*Pattern p = Pattern.compile("regex not");
		Matcher m = p.matcher("regex|regex not");
		System.out.println(m.group());*/
	}
	
	private static long calculateCombinations(String input)
	{
		long n = 1;
		/*System.out.println("Input:"+input);*/
		Pattern pattern = Pattern.compile("[\\(\\)]+");
		String[] strings = pattern.split(input);
		
		if(strings.length == 0)
			return n;
		for(int i = 0; i < strings.length; i++)
		{
			/*n = n * (strings[i].length() <= 0 ? 1:strings[i].length());*/
			System.out.println("output:"+strings[i]+":length:"+strings[i].length());
		}
		return n;
	}
}


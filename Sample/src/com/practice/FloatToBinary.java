package com.practice;

public class FloatToBinary
{
	public static void main(String[] args) 
	{
		String real = "8";
		String[] num = real.split("\\.");
		if(num == null || num.length > 2)
		{
			System.out.println("ERROR");
			return;
		}
		String integer = num[0];
		String fraction = num.length == 2 ? num[1] : "0.0";
		String binary = integerToBinary(integer) + "." + fractionToBinary(fraction);
		
		System.out.println("Real[" +real+ "] = Binary[" +binary+"]");
	}

	private static String fractionToBinary(String fractionString)
	{
		if(fractionString.equals("0") || fractionString.equals("0.0") || fractionString.equals(".0"))
			return "0000";
		String[] radix;
		Double fraction = Double.valueOf("." +fractionString) * 2;
		int FRACTION_PRECISION = 4;
		
		StringBuilder fractionStringBuilder = new StringBuilder();
		for(int i = 0; i < FRACTION_PRECISION; i++)
		{
			if(fraction < 1)
			{
				fractionStringBuilder.append("0");
			}
			else
			{
				fractionStringBuilder.append("1");
			}
			radix = fraction.toString().split("\\.");
			fraction = Double.valueOf("0."+radix[1]) * 2;
		}
		return fractionStringBuilder.toString();
	}

	private static String integerToBinary(String integer)
	{
		StringBuilder builder = new StringBuilder();
		int number = Integer.valueOf(integer);
		int remainder = number % 2;
		while(true)
		{
			switch(remainder)
			{
				case 0:
					builder.append("0");
					break;
				case 1:
					builder.append("1");
					break;
			}
			if(number == 0 || number == 1)
				break;
			number = number / 2;
			remainder = number % 2;
		}
		
		return builder.reverse().toString();
	}
}

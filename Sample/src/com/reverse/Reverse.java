package com.reverse;

public class Reverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = new char[10];
		str[1] = 's';
		str[2] = 'h';
		str[3] = 'a';
		str[4] = 'h';
		
		int i = 0; int len = 5;
		while(--len <= 0)
		{
			str[i] ^= str[len];
			str[len] ^= str[i];
			str[i] ^= str[len];
			i++;
		}
		System.out.println(str);
	}

}

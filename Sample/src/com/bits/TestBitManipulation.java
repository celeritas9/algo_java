package com.bits;

public class TestBitManipulation
{
	public static void main(String[] args)
	{
		System.out.println("-max = "+Integer.MIN_VALUE+ " = " + Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println("+max = "+Integer.MAX_VALUE+ " = " + Integer.toBinaryString(Integer.MAX_VALUE));
		
		int i = -8;
		int j = 0xfffffff8;
		
		boolean isEq = i == j;
		System.out.println(isEq);
		
		System.out.println("i = "+i+ " = " + Integer.toBinaryString(i));
		System.out.println("i << 3 = " + (i << 3) + " = " + Integer.toBinaryString(i << 3));
		System.out.println("i >> 3 : " + (i >> 3) + " = " + Integer.toBinaryString(i >> 3));
		System.out.println("i >>> 3: " + (i >>> 3) + " = " + Integer.toBinaryString(i >>> 3));
		
		System.out.println(Integer.toBinaryString(i & 0x0f));
		System.out.println(Integer.toBinaryString(j & 0x0f));
		
		int k = -1;
		byte b = -1;
		System.out.println("k = " + k +" = "+ Integer.toBinaryString(k));
		System.out.println("b = " + b +" = "+ Integer.toBinaryString(b));
		
		for(int l = 0; l < 32; l++)
		{
			k = k >>> 1;
			//b = (byte)(b >>> 1);
			System.out.println("k = " + k +" = "+ Integer.toBinaryString(k));
			//System.out.println("b = " + b +" = "+ Integer.toBinaryString(b));
		}
	}
}
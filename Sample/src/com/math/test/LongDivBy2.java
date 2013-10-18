package com.math.test;

public class LongDivBy2
{

	public static void main(String[] args)
	{
		int A[] = new int[]{5, 7, 4};
		int a = 0;
		//System.out.println(10^0);
		for(int i = 0; i < A.length; i++)
		{
			a = A[i] * (int) Math.pow(10, i) + a;
		}
		System.out.println(a);
		a = a / 2;
		int B[] = new int[String.valueOf(a).length()];
		for(int i = String.valueOf(a).length() - 1; i >= 0; i--)
		{
			B[i] = a / (int) Math.pow(10, i);
			a = a % (int) Math.pow(10, i);
		}
		for(int i = B.length - 1; i >= 0; i--)
		{
			System.out.print(B[i]);
		}
	}

}

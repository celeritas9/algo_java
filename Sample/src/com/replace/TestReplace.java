package com.replace;

public class TestReplace 
{
	public static void main(String[] args)
	{
		String source = "APPROVED=true\nTRANSACTION_ID=65515\nORDER_ID=201204090939128\nPROCESSED_DATE=120409";
		System.out.println("Before replacement:"+source);
		source = source.replace("\t", "|");
		System.out.println("After replacement:"+source);
	}
}

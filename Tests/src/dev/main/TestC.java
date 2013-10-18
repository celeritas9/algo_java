package dev.main;

import java.util.HashMap;
import java.util.Map;

public class TestC
{
	private static Map map = new HashMap();

	public Map getMap() {
		return map;
	}
	
	public void setMap(Map m) {
		map = m;
	}
	
	public static void main(String[] args)
	{
		int a = 5;
		long b = a;
		System.out.println(b);
	}
}

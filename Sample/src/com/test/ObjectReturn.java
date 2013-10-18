package com.test;

import java.util.HashMap;
import java.util.Map;

public class ObjectReturn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map myMap = null;
		System.out.println(myMap);
		ObjectReturn or = new ObjectReturn();
		myMap = or.getNewMap();
		System.out.println(myMap);
	}
	
	public Map getNewMap()
	{
		Map myMap = new HashMap();
		myMap.put("key1", "value1");
		return myMap;
	}
}

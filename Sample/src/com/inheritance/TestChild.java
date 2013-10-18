package com.inheritance;



/**
 * @author dshah
 *
 */
public class TestChild 
{
	public static void main(String[] args) 
	{
		Child c1 = new Child();
		c1.setClassName("Child1");
		c1.printClassName();
		
		Child c2 = new Child();
		/*This is possible as base and this class are in the same package, if they would have been not in the
		 *same class this would not have been possible.*/
		c2.setClassName("Child2");
		c2.printClassName();
	}
}

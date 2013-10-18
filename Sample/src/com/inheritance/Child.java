/**
 * 
 */
package com.inheritance;

/**
 * @author dshah
 *
 */
public class Child extends Base 
{
	public Child() 
	{
		super();
	}

	public void printClassName()
	{
		System.out.println("ClassName: "+getClassName());
	}
}

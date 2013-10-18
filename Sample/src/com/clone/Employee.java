/**
 * 
 */
package com.clone;

import java.io.OutputStream;

/**
 * @author dshah
 *
 */
public class Employee implements Cloneable
{
	public String name;
	public int id;
	public OutputStream out;
	
	public Employee(String name_, int id_, OutputStream os)
	{
		name = name_;
		id = id_;
		out = os;
	}
	
	@Override
	public Employee clone()
	{
		try
		{
			super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}

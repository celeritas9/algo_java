/**
 * 
 */
package com.inheritance;

/**
 * @author dshah
 *
 */
public abstract class Base 
{
	protected void setClassName(String name)
	{
		this.className = name;
	}
	protected String getClassName()
	{
		return this.className;
	}
	
	private String className;
}

/**
 * 
 */
package com.jaxb;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author dshah
 *
 */
public class NameValue
{
	@XmlElement
	public String name = "";
	
	@XmlElement
	public String value = "";
	
	//Default empty constructor is used by the JAXB annotator.
	public NameValue(){}
	
	public NameValue(String _name, String _value)
	{
		name = _name;
		value = _value;
	}
	
/*	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}*/
}

/**
 * 
 */
package com.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


/**
 * @author dshah
 *
 */
public class Result
{
	public String name = "";
	
	@XmlElement(name = "part")
	public List<NameValue> part;
	
	public Result() {}
	
	public Result(String _name, List<NameValue> _part)
	{
		name = _name;
		part = _part;
	}

	/*public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<NameValue> getPart()
	{
		return part;
	}

	public void setPart(List<NameValue> part)
	{
		this.part = part;
	}*/
}

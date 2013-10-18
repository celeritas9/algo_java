/**
 * 
 */
package com.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author dshah
 * 
 */
public class Status
{
	public String state = "";
	
	@XmlElement
	public String[] message = new String[]{};
	
	//Default empty constructor is used by the JAXB annotator.
	public Status(){}
	
	public Status(String _state, String[] _message)
	{
		state = _state;
		message = _message;
	}
	
	/*public String getState()
	{
		return state;
	}
	
	@XmlAttribute
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String[] getMessage()
	{
		return message;
	}

	public void setMessage(String[] message)
	{
		this.message = message;
	}*/
}

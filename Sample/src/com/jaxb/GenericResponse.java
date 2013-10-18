package com.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dshah
 * Directly resembles the ICD data structure of the Response.
 * A simple POJO.
 */
@XmlRootElement (name = "tns:response")
public class GenericResponse
{
	@XmlAttribute(name = "xmlns:tns")
	private String namespace = "http://com.redknee.esb/schema/GenericRequestResponse";
	
	@XmlAttribute
	private String version = "1.0";
	
	@XmlElement(name = "requestId")
	private String requestId = "";
	
	@XmlElement(name = "responseId")
	private String responseId = "";
	
	@XmlElement(name = "status")
	private Status status;
	
	@XmlElement(name = "header")
	public List<NameValue> headerList;
	
	@XmlElement(name = "result")
	private List<NameValue> genericResultList;
	
	@XmlElement(name = "result")
	private List<Result> customResultList;
	
	public GenericResponse() {}

	public GenericResponse(String _requestId, String _responseId, Status _status, List<NameValue> _headerList, List<NameValue> _genericResultList,
			List<Result> _customResultList)
	{
		requestId = _requestId;
		responseId = _responseId;
		status = _status;
		headerList = _headerList;
		genericResultList = _genericResultList;
		customResultList = _customResultList;
	}

	/*public String getRequestId()
	{
		return requestId;
	}

	public void setRequestId(String requestId)
	{
		this.requestId = requestId;
	}

	public String getResponseId()
	{
		return responseId;
	}

	public void setResponseId(String responseId)
	{
		this.responseId = responseId;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	public List<NameValue> getHeaderList()
	{
		return headerList;
	}

	public void setHeaderList(List<NameValue> headerList)
	{
		this.headerList = headerList;
	}

	public List<NameValue> getGenericResultList()
	{
		return genericResultList;
	}

	public void setGenericResultList(List<NameValue> genericResultList)
	{
		this.genericResultList = genericResultList;
	}

	public List<Result> getCustomResultList()
	{
		return customResultList;
	}

	public void setCustomResultList(List<Result> customResultList)
	{
		this.customResultList = customResultList;
	}*/
}

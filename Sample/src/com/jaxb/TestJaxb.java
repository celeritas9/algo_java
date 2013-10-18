/**
 * 
 */
package com.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * @author dshah
 *
 */
public class TestJaxb
{
	public static void main(String[] args)
	{
		GenericResponse response = new GenericResponse();
		List<NameValue> headerList = new ArrayList<NameValue>();
		
		File f = new File("C:\\redknee\\response.xml");
		
		NameValue sourceHeader = new NameValue("source", "urcs");
		NameValue targetHeader = new NameValue("target", "cps");
		headerList.add(sourceHeader);
		headerList.add(targetHeader);
		response.headerList = headerList;
		
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(GenericResponse.class);
/*			Marshaller marshaller = jaxbContext.createMarshaller();
			
			StringWriter stringWriter = new StringWriter();
			String s = new String();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(response, stringWriter);
			System.out.println(stringWriter.toString());*/
			
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Object o = unmarshaller.unmarshal(new File("C:\\redknee\\request.xml"));
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
	}

}

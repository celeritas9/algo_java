/**
 * 
 */
package com.xml.poller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;




/**
 * @author dshah
 *
 */
public class XmlExtractor 
{
	public static void main(String[] args) throws Exception
	{
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = null;
		
		try
		{
			//document = builder.parse(new File("C:\\redknee\\cdr.xml"));
			document = builder.parse("<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd>"+
        "<wsse:UsernameToken><wsse:Username>username</wsse:Username><wsse:Password>password</wsse:Password></wsse:UsernameToken></wsse:Security>");
		}
		catch(Exception se)
		{
			se.printStackTrace();
		}
		//document.normalize();
		//NodeList listOfNodes = document.getElementsByTagName("CDR");
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression xpression = xpath.compile("//wsse:Security/@wsse:Username");
		String s = xpression.evaluate(document);
		System.out.println(s);
	}
}

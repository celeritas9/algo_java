package com.xpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author dshah
 *
 */
public class TestXpath
{

	public static void main(String[] args) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, XPathExpressionException
	{
		/*XPathFunction fun = new XPathFunction()
		{
			public final QName NULLFUN = new QName("http://null.com/null", "null");
			
			@Override
			public Object evaluate(List args) throws XPathFunctionException
			{
				if(args != null)
				{
					for(Object o : args)
					{
						System.out.println(o);
					}
				}
				
				return null;
			}
		};*/
		
		File f = new File("C:\\Users\\dshah\\Documents\\temp\\xmlToXpath.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document d = factory.newDocumentBuilder().parse(new FileInputStream(f));
		XPath xpath = XPathFactory.newInstance().newXPath();
		
		XPathExpression expression = xpath.compile("//Envelope/Body/createAccountResponse/return/spid");
		System.out.println(expression.evaluate(d));
	}
}

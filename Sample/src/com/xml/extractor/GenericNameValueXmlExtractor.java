/**
 * 
 */
package com.xml.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author dshah
 *
 */
public class GenericNameValueXmlExtractor
{
	
	public static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	public static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	public static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException
	{
		File f = new File("C:\\Users\\dshah\\Documents\\Promotion Interface\\request.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		/*factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
		factory.setAttribute(JAXP_SCHEMA_SOURCE, new File("C:\\Users\\dshah\\Documents\\Promotion Interface\\GenericRequestResponse.xsd"));
		factory.setValidating(true);*/
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setErrorHandler(new ValidationErrorHelper());
		
		Document d = builder.parse(new FileInputStream(f));
		
		NodeList nlist = d.getElementsByTagName("tns:header");
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expression = xpath.compile("//header[name='UserId']/value/text()");
		XPathExpression requestId = xpath.compile("//requestId/text()");
		XPathExpression addressingInfoType = xpath.compile("//parameter[name='AddressingInformation']/part[name='Type']/value/text()");
		XPathExpression addresingInfoID = xpath.compile("//parameter[name='AddressingInformation']/part[name='Type']/value/text()");
		XPathExpression grantDateXPath = xpath.compile("//parameter[name='RequestedTransaction']/part[name='GrantDate']/value/text()");
		XPathExpression requestTransaction = xpath.compile("//parameter[name='RequestedTransaction']/name/text()");
		XPathExpression transId = xpath.compile("//parameter[name='RequestedTransaction']/part[name='TransactionId']/value/text()");
		XPathExpression transactionName = xpath.compile("//parameter[name='RequestedTransaction']/part[name='TransactionName']/value/text()");
		XPathExpression transType = xpath.compile("//parameter[name='RequestedTransaction']/part[name='TransactionType']/value/text()");
		
		System.out.println("AddressionInformation_Type:"+addressingInfoType.evaluate(d));
/*		for(int i = 0; i < nlist.getLength(); i++)
		{
			Node n = nlist.item(i);
			System.out.println("nodeName:"+n.getNodeName());
			System.out.println("nodeTextContent:"+n.getTextContent());
			System.out.println("----------------------------");
		}*/
		System.out.println("RequestId: "+requestId.evaluate(d));
		System.out.println(grantDateXPath.evaluate(d));
		System.out.println("RquestedTransaction: "+requestTransaction.evaluate(d));
		System.out.println("TransactionId: "+transId.evaluate(d));
		System.out.println("TransactionName: "+transactionName.evaluate(d));
		System.out.println("TransactionType: "+transType.evaluate(d));
		nlist = (NodeList)expression.evaluate(d, XPathConstants.NODESET);
		for(int i = 0; i < nlist.getLength(); i++)
		{
			Node n = nlist.item(i);
			System.out.println("nodeValue:"+n.getNodeValue());
			System.out.println("----------------------------");
		}
		
		System.out.println(nlist.getLength());
	}
}

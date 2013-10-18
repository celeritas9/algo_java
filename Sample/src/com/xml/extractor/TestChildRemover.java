/*
 * This code is a protected work and subject to domestic and international
 * copyright law(s).  A complete listing of authors of this work is readily
 * available.  Additionally, source code is, by its very nature, confidential
 * information and inextricably contains trade secrets and other information
 * proprietary, valuable and sensitive to Redknee.  No unauthorized use,
 * disclosure, manipulation or otherwise is permitted, and may only be used
 * in accordance with the terms of the license agreement entered into with
 * Redknee Inc. and/or its subsidiaries.
 *
 * Copyright (c) Redknee Inc. and its subsidiaries. All Rights Reserved.
 */
package com.xml.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 *
 * @author dshah
 * @since 
 */
public class TestChildRemover
{

	public static void main(String[] args) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, XPathExpressionException, TransformerException
	{
		File f = new File("C:\\Users\\dshah\\Documents\\Promotion Interface\\request.xml");
		File crmFile = new File("C:\\Users\\dshah\\Documents\\temp\\test.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document d = factory.newDocumentBuilder().parse(new FileInputStream(crmFile));
		NodeList nlist = d.getElementsByTagName("sub:parameters");
		
		for(int i = 0; i < nlist.getLength(); i++)
		{
			Node n = nlist.item(i);
			//System.out.println(n.getTextContent());
			if(n.getTextContent().trim().equals(""))
			{
				Node parent = n.getParentNode();
				parent.removeChild(n);
			}
		}
		
		d.normalize();
		printDocument(d, System.out);
	}
	
	public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException
	{
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer = tf.newTransformer();
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	    transformer.transform(new DOMSource(doc), 
	         new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	}
}

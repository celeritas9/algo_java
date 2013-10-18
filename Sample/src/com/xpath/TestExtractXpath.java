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
package com.xpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestExtractXpath
{

	public static void main(String[] args) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException
	{
		File f = new File("C:\\Users\\dshah\\Documents\\temp\\xmlToXpath.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document d = factory.newDocumentBuilder().parse(new FileInputStream(f));
		System.out.println(createXPath(d));
	}
	
	public static String createXPath(Object o)
	{
		NodeList nodeList = null;
		Node node = (Node)o;
		String nodeName = "";
		
		if(node.hasChildNodes())
		{
			nodeList = node.getChildNodes();
			for(int i = 0; i < nodeList.getLength(); i++)
			{
				nodeName = nodeName + createXPath(nodeList.item(i));
				System.out.println(nodeName);
			}
		}
		else
		{
			return node.getNodeName()+"|";
		}
		
		return node.getNodeName()+"|";
	}
}

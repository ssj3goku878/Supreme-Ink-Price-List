package supremeinkpricecalc;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import jdk.internal.org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//search for specific ID that has been entered by the user
//have option that displays entire inventory
//speical option: if getElementsByTagName is TransWhite then price will be set to $6.33
//get eElement.getAttribute than use formula to find the price
/**
 *
 * @author Archa
 */
public class SearchXML {

    public static void main(String args[]) throws Exception {
        
        		try {
			Document doc = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder()
					.parse(SearchXML.class.getResourceAsStream("data.xml"));
			XPath xpath = XPathFactory.newInstance().newXPath();
			// 1
			System.out.println(((Node) xpath.evaluate(
					"/inventory/Product[@pantone='100']", doc, XPathConstants.NODE))
					.getAttributes().getNamedItem("pantone"));
			// 2, 3
			NodeList nodes = (NodeList) xpath.evaluate(
					"/inventory/Product/", doc,
					XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++)
				System.out.println(nodes.item(i).getTextContent());
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | DOMException e) {
			System.out.println("Error ocurred while parsing XML.");
		}

    }

}//end class

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
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
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

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

        DocumentBuilderFactory domFactory
                = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("data.xml");
        XPath xpath = XPathFactory.newInstance().newXPath();
        // XPath Query for showing all nodes value
        XPathExpression expr = xpath.compile("/inventory/Product[@pantone='105']");

        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;

        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap a = nodes.item(i).getAttributes();
            Node pantone = nodes.item(i);
            Element pantoneElement = (Element) pantone;
            //System.out.println(a.item(j));
            //System.out.println(a.item(j).getNodeName()); //get only the name of the node
            //System.out.println(a.item(j).getNodeValue()); //get only the value of the node
            System.out.println("Pantone: " + pantoneElement.getAttribute("pantone"));
            System.out.println("Blue: " + pantoneElement.getAttribute("blue"));
            System.out.println("Red: " + pantoneElement.getAttribute("red"));
            System.out.println("Orange: " + pantoneElement.getAttribute("orange"));
            System.out.println("White: " + pantoneElement.getAttribute("white"));
            System.out.println("Purple: " + pantoneElement.getAttribute("purple"));
            System.out.println("Green: " + pantoneElement.getAttribute("green"));
            System.out.println("Black: " + pantoneElement.getAttribute("black"));
            System.out.println("Rubine: " + pantoneElement.getAttribute("rubine"));
           
            //String x = pantoneElement.getAttribute("rubine");
            //System.out.println(x);
            //System.out.println(a.item(j));
            //System.out.println(a.item(i));
            

        }

    }


}//end class

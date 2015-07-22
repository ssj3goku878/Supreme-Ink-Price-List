/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supremeinkpricecalc;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Archa
 */
public class ReadXML {

    public static void main(String args[]) throws Exception {
        DocumentBuilderFactory buildFactory = DocumentBuilderFactory.newInstance();
        try {
        DocumentBuilder dBuilder = buildFactory.newDocumentBuilder();
        Document document = dBuilder.parse(ReadXML.class.getResourceAsStream("data.xml"));
        document.normalize();
        
        //get main node
        NodeList rootNodes = document.getElementsByTagName("inventory");
        Node rootNode = rootNodes.item(0);
        Element rootElement = (Element) rootNode;
        
        //print all with specific tag
        NodeList inventoryList = rootElement.getElementsByTagName("Product");
        for(int i = 0; i < inventoryList.getLength(); i++){
            Node pantone = inventoryList.item(i);
            Element pantoneElement = (Element) pantone;
            
            //if element is blank, do not print
            
            System.out.println("Pantone: " + pantoneElement.getAttribute("pantone")); // print attribute
            System.out.println("Blue: " + pantoneElement.getAttribute("blue"));
            System.out.println("Red: " + pantoneElement.getAttribute("red"));
            System.out.println("Orange: " + pantoneElement.getAttribute("orange"));
            System.out.println("White: " + pantoneElement.getAttribute("white"));
            System.out.println("Purple: " + pantoneElement.getAttribute("purple"));
            System.out.println("Green: " + pantoneElement.getAttribute("green"));
            System.out.println("Black: " + pantoneElement.getAttribute("black"));
            System.out.println("Rubine: " + pantoneElement.getAttribute("rubine"));
        }
        
        } catch (ParserConfigurationException | SAXException | IOException e) {
        }
        
    }
}


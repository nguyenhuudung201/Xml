package com.class2;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try{
            File inputFile = new File("student.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root Name " + doc.getDocumentElement().getNodeName());
            NodeList students = doc.getElementsByTagName("student");
            for (int i = 0; i < students.getLength(); i++) {

                Element student = (Element)students.item(i);
                System.out.println("----Student----");

                String value = student.getAttribute("id").toString();
                System.out.println(value);


                //Get Name
                NodeList firstnameList = student.getElementsByTagName("firstname");
                if(firstnameList != null) {
                    String firstname = firstnameList.item(0).getTextContent();
                    System.out.println("\tfirstname " + firstname );
                }
                NodeList lastnameList = student.getElementsByTagName("lastname");
                if(lastnameList != null) {
                    String lastname = lastnameList.item(0).getTextContent();
                    System.out.println("\tlastname " + lastname);
                }

            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

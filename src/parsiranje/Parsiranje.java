package parsiranje;

import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parsiranje {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ParseException {

        double pr;
        String str;
        int year;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse("xmlfile.xml");
        System.out.println(doc.getDocumentElement().getNodeName().toUpperCase());
        System.out.println("-----------------------------------------");
        NodeList nList = doc.getElementsByTagName("book");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                pr = Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent());
                str = eElement.getElementsByTagName("publish_date").item(0).getTextContent();
                year = Integer.parseInt(str.substring(0, 4));

                if (pr > 10 & year > 2005) {
                    System.out.println("BOOK ID: " + eElement.getAttribute("id"));
                    System.out.println("Author: " + eElement.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Genre: " + eElement.getElementsByTagName("genre").item(0).getTextContent());
                    System.out.println("Price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("Publish Date: " + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
                    System.out.println("Description: " + eElement.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("------------------------------------------------------------------------");
                }
            }

        }
    }

}

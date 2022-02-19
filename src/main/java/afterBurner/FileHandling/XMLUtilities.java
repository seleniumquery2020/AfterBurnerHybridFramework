package afterBurner.FileHandling;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

public class XMLUtilities {

	public static void getXMLData() throws SAXException, IOException, ParserConfigurationException {

		File file = new File(
				"E:\\StarGateTeam\\AfterBurnerHybridFramework\\src\\test\\java\\afterBurner\\TestData\\TestData.xml");
		DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = build.newDocumentBuilder();

		Document doc = db.parse(file);

		doc.getDocumentElement().normalize();

		System.out.println("Root = " + doc.getDocumentElement().getNodeName());
		
		NodeList list = doc.getElementsByTagName("Name");
		NodeList list1 = doc.getElementsByTagName("Brand");
		for (int i = 0; i < list.getLength(); i++) {
			 Element nameElement = (Element)list.item(i);
			 Element brandElement = (Element)list1.item(i);
			System.out.println(nameElement.getTextContent() + " => "+brandElement.getTextContent());
		}
		
		Element tv = (Element) list.item(0);
		System.out.println("Id of Name = "+tv.getAttribute("id"));

	}
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		getXMLData();
	}

}

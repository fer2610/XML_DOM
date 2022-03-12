import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Insurance {
    public static void main(String[] args) throws ParserConfigurationException, SAXException
    {
        try {
            File file = new File("insurance.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("insurance_record");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("first_name").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("last_name").item(0).getTextContent());
                    System.out.println("phone : " + eElement.getElementsByTagName("phone").item(0).getTextContent());
                    System.out.println("car : " + eElement.getElementsByTagName("car").item(0).getTextContent());
                    System.out.println("model : " + eElement.getElementsByTagName("model").item(0).getTextContent());
                    System.out.println("insurance : " + eElement.getElementsByTagName("insurance").item(0).getTextContent());
                    System.out.println("contract_date : " + eElement.getElementsByTagName("contract_date").item(0).getTextContent());
                }

            }
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}

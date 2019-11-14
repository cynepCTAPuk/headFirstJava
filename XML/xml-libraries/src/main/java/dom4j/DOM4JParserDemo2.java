/**
 * https://www.tutorialspoint.com/java_xml/java_dom4j_parser.htm
 */
package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class DOM4JParserDemo2 {

    public static void main(String[] args) throws DocumentException {

        File inputFile = new File("employees.xml");
        readXML(inputFile);
    }

    private static void readXML(File inputFile) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputFile);

        Element classElement = document.getRootElement();
        System.out.println("Root element :" + classElement.getName());

        List<Node> nodes = document.selectNodes("/employees/employee");
//        List<Node> nodes = document.content();
//        nodes.forEach(n -> System.out.println(n.asXML()));
        System.out.println("----------------------------");

        for (Node node : nodes) {
//            System.out.println("Current Element : " + node.asXML());
            System.out.println("\nCurrent Element :" + node.getName());
            System.out.println("Student roll no : " + node.valueOf("@id"));
            System.out.println("First Name : " + node.selectSingleNode("firstName").getText());
            System.out.println("Last Name : " + node.selectSingleNode("lastName").getText());
            System.out.println("Department.id : " + node.selectSingleNode("department/id").getText());
            System.out.println("Department.name : " + node.selectSingleNode("department/name").getText());
        }
    }
}
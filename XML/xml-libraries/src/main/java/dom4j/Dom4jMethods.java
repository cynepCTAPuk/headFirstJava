package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Dom4jMethods {
    public static void main(String[] args) throws DocumentException {
        String fileName = "employees.xml";
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(fileName));
        List<Node> nodes = document.content();
        nodes.forEach(node -> System.out.println(node.asXML()));

        Element classElement = document.getRootElement();
        System.out.println("-".repeat(100));
        System.out.println(classElement.getName());
    }
}

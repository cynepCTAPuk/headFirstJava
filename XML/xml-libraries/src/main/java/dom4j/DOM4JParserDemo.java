/**
 * https://www.tutorialspoint.com/java_xml/java_dom4j_parser.htm
 */
package dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DOM4JParserDemo {
    private File file;

    public DOM4JParserDemo(File file) {
        this.file = file;
    }

    public static void main(String[] args) throws DocumentException, IOException {
        String file = "input.xml";
        DOM4JParserDemo parser = new DOM4JParserDemo(new File(file));
//        String newFile = parser.createNewFile();
//        parser = new DOM4JParserDemo(new File(newFile));
        parser.printXML();
        System.out.println("\n" + "-".repeat(50) + "\n" + parser.getNodeById("493").asXML());
    }

    private void printXML() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);

        Element classElement = document.getRootElement();
        System.out.println("Root element :" + classElement.getName());

        List<Node> nodes = document.selectNodes("/class/student");
//        List<Node> nodes = document.content();
        nodes.forEach(n -> System.out.println(n.asXML()));
//        System.out.println("----------------------------");

        for (Node node : nodes) {
//            System.out.println("Current Element : " + node.asXML());
/*
            System.out.println("\nCurrent Element :" + node.getName());
            System.out.println("Student id : " + node.valueOf("@id"));
            System.out.println("First Name : " + node.selectSingleNode("firstname").getText());
            System.out.println("Last Name : " + node.selectSingleNode("lastname").getText());
            System.out.println("NickName : " + node.selectSingleNode("nickname").getText());
            System.out.println("Marks : " + node.selectSingleNode("marks").getText());
*/
        }
    }

    private Node getNodeById(String id) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        List<Node> elements = document.selectNodes("//*[@id='" + id + "']");
        return elements.get(0);
    }

    private String createNewFile() throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("XMLTutorials");

        Element tutorialElement1 = root.addElement("tutorial").addAttribute("id", "01");
        tutorialElement1.addAttribute("type", "xml");
        tutorialElement1.addElement("title").addText("XML with Dom4J");
        tutorialElement1.addElement("description").addText("XML handling with Dom4J");
        tutorialElement1.addElement("date").addText("14/06/2016");
        tutorialElement1.addElement("author").addText("Dom4J tech writer");

        Element tutorialElement2 = root.addElement("tutorial").addAttribute("id", "02");
        tutorialElement2.addAttribute("type", "xml");
        tutorialElement2.addElement("title").addText("XML with Dom4J");
        tutorialElement2.addElement("description").addText("XML handling with Dom4J");
        tutorialElement2.addElement("date").addText("14/06/2016");
        tutorialElement2.addElement("author").addText("Dom4J tech writer");

        OutputFormat format = OutputFormat.createPrettyPrint();
        String newFile = "src/test/resources/example_dom4j_new.xml";
        XMLWriter writer = new XMLWriter(new FileWriter(new File(newFile)), format);
        writer.write(document);
        writer.close();
        return newFile;
    }
}
package xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DefaultParserTest {
    final String fileName = "src/test/resources/example_default_parser.xml";
    final String fileNameSpace = "src/test/resources/example_default_parser_namespace.xml";
    DefaultParser parser;

    @Test
    public void getFirstLevelNodeListTest() {
        parser = new DefaultParser(new File(fileName));
        NodeList list = parser.getFirstLevelNodeList();

        for (int i = 0; null != list && i < list.getLength(); i++)
            System.out.println(list.item(i).getTextContent());

        assertNotNull(list);
        assertTrue(list.getLength() == 4);
    }

    @Test
    public void getNodeListByTitleTest() {
        parser = new DefaultParser(new File(fileName));
        NodeList list = parser.getNodeListByTitle("XML");
        System.out.println(list.getLength());

        for (int i = 0; null != list && i < list.getLength(); i++) {
            Node node = list.item(i);
            assertEquals("02", node.getAttributes().getNamedItem("tutId").getTextContent());
            assertEquals("java", node.getAttributes().getNamedItem("type").getTextContent());
            assertEquals("XML", node.getFirstChild().getTextContent());
            assertEquals("title", node.getFirstChild().getNodeName());
            assertEquals("description", node.getChildNodes().item(1).getNodeName());
            assertEquals("Introduction to XPath", node.getChildNodes().item(1).getTextContent());
            assertEquals("author", node.getLastChild().getNodeName());
            assertEquals("XMLAuthor", node.getLastChild().getTextContent());
/*
            System.out.println(node.getAttributes().getNamedItem("tutId").getTextContent());
            System.out.println(node.getAttributes().getNamedItem("type").getTextContent());
            System.out.println(node.getFirstChild().getTextContent());
            System.out.println(node.getChildNodes().item(1).getNodeName());
            System.out.println(node.getChildNodes().item(1).getTextContent());
            System.out.println(node.getLastChild().getNodeName());
            System.out.println(node.getLastChild().getTextContent());
*/
        }

        for (int i = 0; null != list && i < list.getLength(); i++)
            System.out.println(list.item(i).getTextContent());
    }

    @Test
    public void getNodeListByDateTest() {
        parser = new DefaultParser(new File(fileName));
        NodeList list = parser.getElementsByDate("04022016");
        System.out.println(list.getLength());
        for (int i = 0; null != list && i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println(node.getTextContent());
            assertEquals("04", node.getAttributes().getNamedItem("tutId").getTextContent());
            assertEquals("java", node.getAttributes().getNamedItem("type").getTextContent());

            assertEquals("title", node.getFirstChild().getNodeName());
            assertEquals("Spring", node.getFirstChild().getTextContent());

            assertEquals("description", node.getChildNodes().item(1).getNodeName());
            assertEquals("Introduction to Spring", node.getChildNodes().item(1).getTextContent());
            assertEquals("date", node.getChildNodes().item(2).getNodeName());
            assertEquals("04/02/2016", node.getChildNodes().item(2).getTextContent());
            assertEquals("author", node.getChildNodes().item(3).getNodeName());
            assertEquals("SpringAuthor", node.getChildNodes().item(3).getTextContent());

            assertEquals("sections", node.getLastChild().getNodeName());
            assertEquals("Spring Core", node.getLastChild().getChildNodes().item(0).getTextContent());
            assertEquals("Spring MVC", node.getLastChild().getChildNodes().item(1).getTextContent());
            assertEquals("Spring Batch", node.getLastChild().getChildNodes().item(2).getTextContent());
        }
    }

    @Test
    public void getNodeByIdTest() {
        parser = new DefaultParser(new File(fileName));
        Node node = parser.getNodeById("03");
        System.out.println(node.getTextContent());

        String type = node.getAttributes().getNamedItem("type").getNodeValue();
        assertEquals("android", type);
    }

    @Test
    public void getNodeListWithNamespaceTest() {
        parser = new DefaultParser(new File(fileNameSpace));
        NodeList list = parser.getAllTutorials();
        for (int i = 0; null != list && i < list.getLength(); i++)
            System.out.println(list.item(i).getTextContent());

        assertNotNull(list);
        assertTrue(list.getLength() == 4);
    }
}

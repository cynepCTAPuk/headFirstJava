package htmlcleaner;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.io.IOException;
import java.net.URL;

public class HTMLcleaner {

    public static void main(String[] args) throws IOException, XPatherException {
        HtmlCleaner cleaner = new HtmlCleaner();
        final String siteUrl = "https://habr.com/ru/top/";
        TagNode node = cleaner.clean(new URL(siteUrl));

        Object[] objects = node.evaluateXPath("//a[@class='post__title_link']");
        for (Object o : objects) {
            System.out.println(((TagNode) o).getText());
        }
    }
}

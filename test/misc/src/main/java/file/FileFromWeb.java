package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileFromWeb {
    public static void main(String[] args) {
        try {
            URL website = new URL("http://htmlbook.ru/html");
            String outputFile = "c:/000/htmlbook_html.html";
            website = new URL("http://htmlbook.ru/css");
            outputFile = "c:/000/htmlbook_css.html";
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(outputFile);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (MalformedURLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

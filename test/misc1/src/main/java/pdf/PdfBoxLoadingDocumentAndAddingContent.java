// https://coderlessons.com/tutorials/java-tekhnologii/vyuchit-pdfbox/pdfbox-kratkoe-rukovodstvo
package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PdfBoxLoadingDocumentAndAddingContent {
    public static void main(String[] args) throws IOException {
        String doc = "C:/000/PdfBox_Examples/my_doc.pdf";
        File file = new File(doc);

        //Loading an existing document
        try (PDDocument document = PDDocument.load(file)) {
            System.out.println("PDF loaded");
            //Retrieving the pages of the document
            PDPage page = document.getPage(0);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                //Begin the Content stream
                contentStream.beginText();
                File arial = new File("C:/WINDOWS/FONTS/arial.ttf");
                PDFont pdFont = PDType0Font.load(document, arial);
                //Setting the font to the Content stream
                contentStream.setFont(pdFont, 12);

                //Setting the leading
                contentStream.setLeading(14.5f);

                //Setting the position for the line
                contentStream.newLineAtOffset(50, 500);

                contentStream.setNonStrokingColor(Color.RED);
                String text = "This is the sample document and we are adding content to it.";
                //Adding text in the form of string
                contentStream.showText(text);
                contentStream.newLine();
                contentStream.showText("Hello World! Здорова Мир!");

                //Ending the content stream
                contentStream.endText();

                System.out.println("Content added");
            }
            //Saving the document
            document.save(doc);
        }
    }
}
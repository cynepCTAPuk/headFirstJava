// https://coderlessons.com/tutorials/java-tekhnologii/vyuchit-pdfbox/pdfbox-kratkoe-rukovodstvo
package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class PdfBoxLoadingDocumentAndDeletePage {
    public static void main(String[] args) throws IOException {
        String doc = "C:/000/PdfBox_Examples/my_doc.pdf";
        File file = new File(doc);

        //Loading an existing document
        try (PDDocument document = PDDocument.load(file)) {
            System.out.println("PDF loaded");

            //Listing the number of existing pages
            int numberOfPages = document.getNumberOfPages();
            System.out.println("Pages: " + numberOfPages);
            //Removing the pages
            document.removePage(1);

            System.out.println("page removed");
            //Saving the document
            document.save(doc);
        }
    }
}
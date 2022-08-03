// https://coderlessons.com/tutorials/java-tekhnologii/vyuchit-pdfbox/pdfbox-kratkoe-rukovodstvo
package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class PdfBoxLoadingDocumentAndAddPage {
    public static void main(String[] args) throws IOException {
        String doc = "C:/000/PdfBox_Examples/my_doc.pdf";
        File file = new File(doc);

        //Loading an existing document
        try (PDDocument document = PDDocument.load(file)) {
            System.out.println("PDF loaded");

            //Adding a blank page to the document
            document.addPage(new PDPage());

            //Saving the document
            document.save(doc);
        }
    }
}
// https://coderlessons.com/tutorials/java-tekhnologii/vyuchit-pdfbox/pdfbox-kratkoe-rukovodstvo
package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.File;
import java.io.IOException;

public class PdfBoxLoadingDocumentAndRetivingDocumentAttributes {
    public static void main(String[] args) throws IOException {
        String doc = "C:/000/PdfBox_Examples/my_doc.pdf";
        File file = new File(doc);

        //Loading an existing document
        try (PDDocument document = PDDocument.load(file)) {
            System.out.println("PDF loaded");

            //Getting the PDDocumentInformation object
            PDDocumentInformation pdd = document.getDocumentInformation();

            //Retrieving the info of a PDF document
            System.out.println("Author of the document is : " + pdd.getAuthor());
            System.out.println("Title of the document is : " + pdd.getTitle());
            System.out.println("Subject of the document is : " + pdd.getSubject());
            System.out.println("Creator of the document is : " + pdd.getCreator());
            System.out.println("Creation date of the document is : " + pdd.getCreationDate());
            System.out.println("Modification date of the document is : " + pdd.getModificationDate());
            System.out.println("Keywords of the document are : " + pdd.getKeywords());
        }
    }
}
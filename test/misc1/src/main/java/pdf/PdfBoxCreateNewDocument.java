// https://coderlessons.com/tutorials/java-tekhnologii/vyuchit-pdfbox/pdfbox-kratkoe-rukovodstvo
package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PdfBoxCreateNewDocument {
    public static void main(String[] args) throws IOException {
        String doc = "C:/000/PdfBox_Examples/my_doc.pdf";
        //Creating PDF document object

        try (PDDocument document = new PDDocument()) {
            System.out.println("PDF created");
            int pages = 1;
            for (int i = 0; i < pages; i++) {
                //Creating a blank page
                PDPage blankPage = new PDPage();
                //Adding the blank page to the document
                document.addPage(blankPage);
            }

            //Creating the PDDocumentInformation object
            PDDocumentInformation pdd = document.getDocumentInformation();
            // Setting the Title
            pdd.setTitle("Title");
            //Setting the Author
            pdd.setAuthor("Author");
            //Setting the Subject
            pdd.setSubject("Subject");
            //Setting keywords for the document
            pdd.setKeywords("sample, first example, my pdf");
            //Setting the created date of the document
            Calendar date = new GregorianCalendar();
            date.set(2015, 11, 5);
            pdd.setCreationDate(date);
            //Setting the modified date of the document
            date.set(2016, 6, 5);
            pdd.setModificationDate(date);
            //Setting the Application
            pdd.setCreator("Java application");

            pdd.setProducer("Producer");
            pdd.setTrapped("Unknown");
            pdd.setCustomMetadataValue("Meta", "Meta");


            System.out.println("Properties added successfully ");

            //Saving the document
            document.save(doc);
            System.out.println("PDF saved");
        }
    }
}
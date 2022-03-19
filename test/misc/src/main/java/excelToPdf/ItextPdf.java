// https://www.examplefiles.net/cs/952509
package excelToPdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class ItextPdf {
    public static void main(String[] args) throws Exception {
//        File arialTtf = new File("C:/WINDOWS/FONTS/arial.ttf");
//        BaseFont arial = BaseFont.createFont(arialTtf.getAbsolutePath(), BaseFont.IDENTITY_H, false);
        String pathToArialTtf = "C:/WINDOWS/FONTS/arial.ttf";
        BaseFont arial = BaseFont.createFont(pathToArialTtf, BaseFont.IDENTITY_H, false);
        Font arialBold = new Font(arial, 12, Font.BOLD, BaseColor.RED);
        Font arialBoldItalic = new Font(arial, 12, Font.BOLDITALIC, BaseColor.BLUE);
        Font arialItalic = new Font(arial, 12, Font.ITALIC, BaseColor.GREEN);

        Document iTextPdf = new Document();
        PdfWriter.getInstance(iTextPdf, new FileOutputStream("C:/000/iText_pdf_output.pdf"));
        iTextPdf.open();

        PdfPTable iTextPdfTable = new PdfPTable(1);
        PdfPCell iTextPdfTableCell;
        Phrase phrase1 = new Phrase("Первая строка\nFirst String", arialBold);
        iTextPdfTableCell = new PdfPCell(phrase1);
        iTextPdfTableCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        iTextPdfTableCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        iTextPdfTable.addCell(iTextPdfTableCell);
        iTextPdf.add(iTextPdfTable);

        iTextPdfTable = new PdfPTable(2);
        Phrase phrase2 = new Phrase("Second String", arialItalic);
        iTextPdfTableCell = new PdfPCell(phrase2);
        iTextPdfTable.addCell(iTextPdfTableCell);
        Phrase phrase3 = new Phrase("Third String", arialBoldItalic);
        iTextPdfTableCell = new PdfPCell(phrase3);
        iTextPdfTable.addCell(iTextPdfTableCell);
        iTextPdf.add(iTextPdfTable);

        iTextPdf.close();
    }
}
// https://www.examplefiles.net/cs/952509
package excelToPdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class PoiAnditextPdf {
    public static void main(String[] args) throws Exception {
        //First we read the Excel file in binary format into FileInputStream
//        FileInputStream excelFile = new FileInputStream(new File("C:/000/excel_to_pdf.xls"));
        FileInputStream excelFile = new FileInputStream(new File("C:/000/excel_to_pdf.xlsx"));
        // Read workbook into HSSFWorkbook
//        HSSFWorkbook excelWorkbook = new HSSFWorkbook(excelFile);
        XSSFWorkbook excelWorkbook = new XSSFWorkbook(excelFile);
        // Read worksheet into HSSFSheet
//        HSSFSheet excelWorksheet = excelWorkbook.getSheetAt(0);
        XSSFSheet excelWorksheet = excelWorkbook.getSheetAt(0);
        // To iterate over the rows
        Iterator<Row> rowIterator = excelWorksheet.iterator();
        //We will create output PDF document objects at this point
        Document iText_pdf = new Document();
        PdfWriter.getInstance(iText_pdf, new FileOutputStream("C:/000/excel2pdf_output.pdf"));
        iText_pdf.open();
        //we have two columns in the Excel sheet, so we create a PDF table with two columns
        //Note: There are ways to make this dynamic in nature, if you want to.
        PdfPTable iText_pdf_table = new PdfPTable(3);
        //We will use the object below to dynamically add new data to the table
        PdfPCell iText_pdf_table_cell;
        //Loop through rows.
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next(); //Fetch CELL
                switch (cell.getCellType()) { //Identify CELL type
                    //you need to add more code here based on your requirement / transformations
                    // case Cell.CELL_TYPE_STRING: // for version POI v3.8
                    case _NONE:
                        iText_pdf_table.addCell("_NONE");
                        break;
                    case BLANK:
                        iText_pdf_table.addCell(" ");
                        break;
                    case BOOLEAN:
                        iText_pdf_table.addCell("BOOLEAN");
                        break;
                    case ERROR:
                        iText_pdf_table.addCell("ERROR");
                        break;
                    case FORMULA:
                        iText_pdf_table_cell = new PdfPCell(new Phrase(cell.getCellFormula()));
                        iText_pdf_table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        iText_pdf_table.addCell(iText_pdf_table_cell);
                        break;
                    case NUMERIC:
                        iText_pdf_table_cell = new PdfPCell(new Phrase(String.valueOf(cell.getNumericCellValue())));
                        iText_pdf_table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        iText_pdf_table.addCell(iText_pdf_table_cell);
                        break;
                    case STRING:
                        //Push the data from Excel to PDF Cell
                        iText_pdf_table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));
                        iText_pdf_table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        iText_pdf_table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        //feel free to move the code below to suit to your needs
                        iText_pdf_table.addCell(iText_pdf_table_cell);
                        break;
                    default:
                        iText_pdf_table.addCell("default");
                }
            }
        }
        //Finally add the table to PDF document
        iText_pdf.add(iText_pdf_table);
        iText_pdf.close();
        //we created our pdf file..
        excelFile.close(); //close xls
    }
}
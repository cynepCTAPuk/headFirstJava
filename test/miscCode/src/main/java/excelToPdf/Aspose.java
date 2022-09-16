package excelToPdf;

import com.aspose.cells.FileFormatType;
import com.aspose.cells.Workbook;

public class Aspose {
    public static void main(String[] args) throws Exception {
        Workbook wbk = new Workbook("C:/000/excel_to_pdf.xls");
        wbk.save("C:/000/excel_output.csv", FileFormatType.CSV);
        wbk.save("C:/000/excel_output.jpeg", FileFormatType.JPG);
        wbk.save("C:/000/excel_output.pdf", FileFormatType.PDF);
    }
}

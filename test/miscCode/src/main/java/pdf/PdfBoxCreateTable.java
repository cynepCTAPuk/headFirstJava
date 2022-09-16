package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PdfBoxCreateTable {
    private static void drawLine(PDPageContentStream contentStream,
                                 float xStart, float yStart, float xEnd, float yEnd) throws IOException {
        contentStream.moveTo(xStart, yStart);
        contentStream.lineTo(xEnd, yEnd);
        contentStream.stroke();
    }

    /**
     * @param page          страница
     * @param contentStream содержание
     * @param content       a 2d array containing the table data
     * @param startX        the padding on left of table
     * @param endX          the padding on right of table
     * @param startY        the y-coordinate of the first row
     * @param xPosition     x-position
     * @param yPosition     y-position
     * @throws IOException на всяк случай
     */
    public static void drawTable(PDPage page, PDPageContentStream contentStream, String[][] content, float startX, float endX, float startY, int xPosition, int yPosition) throws IOException {
        final int rows = content.length;
        final int cols = content[0].length;
        final float rowHeight = 30f; // Высота строки
        final float tableWidth = page.getMediaBox().getWidth() - startX - endX;
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth / cols;
        final float cellMargin = 5f;

        //draw the rows
        float nextY = startY;
        for (int i = 0; i <= rows; i++) {
            drawLine(contentStream, startX, nextY, startX + tableWidth, nextY);
            nextY -= rowHeight;
        }

        //draw the columns
        float nextX = startX;
        for (int i = 0; i <= cols; i++) {
            drawLine(contentStream, nextX, startY, nextX, startY - tableHeight);
            nextX += colWidth;
        }

        //now add the text
        float textX = startX + cellMargin;
        float textY = startY - 15;
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                String text = content[i][j];
                if (text == null) continue;
                contentStream.beginText();
                contentStream.newLineAtOffset(textX, textY);
                contentStream.showText(text);
                contentStream.endText();
                textX += colWidth;
            }
            textY -= rowHeight;
            textX = startX + cellMargin;
        }
    }

    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        File arial = new File("C:/WINDOWS/FONTS/arial.ttf");
        File arialbd = new File("C:/WINDOWS/FONTS/arialbd.ttf");
        File arialbi = new File("C:/WINDOWS/FONTS/arialbi.ttf");
        File ariali = new File("C:/WINDOWS/FONTS/ariali.ttf");
        File cour = new File("C:/WINDOWS/FONTS/cour.ttf");
        final float pageWidth = page.getMediaBox().getWidth();

        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
/*
        String[] letters = alphabet.split("");
        for (int i = 0; i < letters.length; i++) {
            float width = pdFont.getStringWidth(letters[i]) / 1000 * fontSize;
            System.out.println(letters[i] + " " + width);
        }
        System.out.println(alphabet);
*/

        String text = "Hello World! Привет Мир!";
        long startY = 700L;
        long startX = 50L;
        long endX = 50L;
        PDFont pdFont = PDType0Font.load(doc, arialbi);
        long fontSize = 16L;
        float width = pdFont.getStringWidth(text) / 1000 * fontSize;
        contentStream.setFont(pdFont, fontSize);
//        float startText = startX; // left
//        float startText = startX + (pageWidth - startX - endX - width) / 2; // center
        float startText = (pageWidth - endX - width); // right
        contentStream.beginText();
        contentStream.setLeading(14.5f);
        System.out.println(startText + " - " + startY);
        contentStream.newLineAtOffset(startText, startY);
        contentStream.setNonStrokingColor(Color.RED);
        contentStream.showText(text);
        contentStream.endText();

        text = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        startY = 680L;
        pdFont = PDType0Font.load(doc, arialbd);
        fontSize = 14L;
        width = pdFont.getStringWidth(text) / 1000 * fontSize;
        startText = startX + (pageWidth - startX - endX - width) / 2;
        contentStream.setFont(pdFont, fontSize);
        contentStream.beginText();
        contentStream.setLeading(14.5f);
        System.out.println(startText + " - " + startY);
        contentStream.newLineAtOffset(startText, startY);
        contentStream.setNonStrokingColor(Color.BLUE);
        contentStream.showText(text);
        contentStream.endText();

        String[][] content = {
                {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
                {"c", "d", null}
        };
        startY = 660;
        pdFont = PDType0Font.load(doc, ariali);
        fontSize = 12L;
        contentStream.setFont(pdFont, fontSize);
        contentStream.setNonStrokingColor(Color.DARK_GRAY);
        drawTable(page, contentStream, content, startX, endX, startY, 0, 0);
        contentStream.close();
        doc.save("C:/000/PdfBox_Examples/table.pdf");
        doc.close();
    }
}

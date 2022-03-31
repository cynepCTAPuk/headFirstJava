package org.example;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;
import java.io.IOException;

public class PdfBuilder {
    public static void drawTable(PDPage pdPage, PDPageContentStream pdPageContentStream, String[][] content,
                                 float xStart, float xEnd, float yStart, Color gridColor,
                                 PDFont pdFont, float fontSize, Color fontColor, Color bdColor,
                                 int xAlignment, float rowHeight) throws IOException {
        final int rows = content.length;
        final int columns = content[0].length;
        final float tableWidth = pdPage.getMediaBox().getWidth() - xStart - xEnd;
        final float tableHeight = rowHeight * rows;
        final float columnWidth = tableWidth / columns;
        final float cellMargin = 4f;

        pdPageContentStream.setNonStrokingColor(bdColor);
        pdPageContentStream.addRect(xStart, yStart - tableHeight, tableWidth, tableHeight);
        pdPageContentStream.fill();

        // draw the rows
        pdPageContentStream.setNonStrokingColor(gridColor);
        float yStartLine = yStart;
        for (int i = 0; i <= rows; i++) {
            drawLine(pdPageContentStream, xStart, yStartLine, xStart + tableWidth, yStartLine);
            yStartLine -= rowHeight;
        }
        // draw the columns
        float xStartLine = xStart;
        for (int i = 0; i <= columns; i++) {

        }

    }

    public static void drawLine(PDPageContentStream pdPageContentStream, float xStart, float yStart, float xEnd, float yEnd) throws IOException {
        pdPageContentStream.moveTo(xStart, yStart);
        pdPageContentStream.lineTo(xEnd, yEnd);
        pdPageContentStream.stroke();
    }

    public static void drawCircle(PDPageContentStream pdPageContentStream, float cx, float cy, float r, Color colorFilling) throws IOException {
        final float k = 0.552284749831f;
        pdPageContentStream.setNonStrokingColor(colorFilling);
        pdPageContentStream.moveTo(cx - r, cy);
        pdPageContentStream.curveTo(cx - r, cy + k * r, cx - k * r, cy + r, cx, cy + r);
        pdPageContentStream.curveTo(cx + k * r, cy + r, cx + r, cy + k * r, cx + r, cy);
        pdPageContentStream.curveTo(cx + r, cy - k * r, cx + k * r, cy - r, cx, cy - r);
        pdPageContentStream.curveTo(cx - k * r, cy - r, cx - r, cy - k * r, cx - r, cy);
        pdPageContentStream.fill();
    }
}

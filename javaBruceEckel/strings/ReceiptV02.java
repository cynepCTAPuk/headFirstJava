//: strings/Receipt.java
package strings;

import java.util.*;

public class ReceiptV02 {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    int a = 15; // Item width
    int b = 5;  // Qty width
    int c = 10; // Price width
    String title =      "%-" + a + "s %" + b + "s %" + c + "s\n";
    String itemRow =    "%-" + a + "." + a + "s %" + b + "d %" + c + ".2f\n";
    String endRow =     "%-" + a + "s %" + b + "s %" + c + ".2f\n";

    public void printTitle() {
        f.format(title, "Item", "Qty", "Price");
        f.format(title, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format(itemRow, name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format(endRow, "Tax", "", total * 0.06);
        f.format(title, "", "", "-----");
        f.format(endRow, "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        ReceiptV02 receipt = new ReceiptV02();
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
} /* Output:
Item              Qty      Price
----              ---      -----
Jack’s Magic Be     4       4.25
Princess Peas       3       5.10
Three Bears Por     1      14.29
Tax                         1.42
                           -----
Total                      25.06
*///:~
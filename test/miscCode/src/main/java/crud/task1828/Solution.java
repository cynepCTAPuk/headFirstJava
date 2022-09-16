package crud.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            String type = args[0];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();
            bufferedReader = new BufferedReader(new FileReader(fileName));
            if (type.equals("-c")) {
                String productName = args[1];                   // 30 symbols
                double price = Double.parseDouble(args[2]);     // 8
                int quantity = Integer.parseInt(args[3]);       // 4

                int max = Integer.MIN_VALUE;
                while (bufferedReader.ready()) {
                    String row = bufferedReader.readLine();
                    int id = Integer.parseInt(row.substring(0, 8).trim());
                    if (id > max) max = id;
                }

                String id = String.format("%-8d", ++max).substring(0, 8);
                String product = String.format("%-30s", productName).substring(0, 30);
                String priceStr = String.format("%-8.2f", price).substring(0, 8);
                String quantityStr = String.format("%-4d", quantity).substring(0, 4);
                String newRow = "\n" + id + product + priceStr + quantityStr;

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
                bufferedWriter.write(newRow);
                bufferedWriter.close();
            }

            if (type.equals("-d")) {
                List<String> list = new LinkedList<>();
                while (bufferedReader.ready()) list.add(bufferedReader.readLine());

                int id = Integer.parseInt(args[1].trim());
                for (int i = 0; i < list.size(); i++) {
                    int idRow = Integer.parseInt(list.get(i).substring(0, 8).trim());
                    if (idRow == id) list.remove(i);
                }

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
                bufferedWriter.write(String.join("\n", list));
                bufferedWriter.close();
            }

            if (type.equals("-u")) {
                int id = Integer.parseInt(args[1].trim());
                String productName = args[2];                   // 30 symbols
                double price = Double.parseDouble(args[3]);     // 8
                int quantity = Integer.parseInt(args[4]);       // 4

                List<String> list = new LinkedList<>();
                while (bufferedReader.ready()) list.add(bufferedReader.readLine());

                for (int i = 0; i < list.size(); i++) {
                    int idRow = Integer.parseInt(list.get(i).substring(0, 8).trim());
                    if (idRow == id) {
                        String idStr = String.format("%-8d", id).substring(0, 8);
                        String product = String.format("%-30s", productName).substring(0, 30);
                        String priceStr = String.format("%-8.2f", price).substring(0, 8);
                        String quantityStr = String.format("%-4d", quantity).substring(0, 4);
                        String newRow = idStr + product + priceStr + quantityStr;
                        list.set(i, newRow);
                    }
                }

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
                bufferedWriter.write(String.join("\n", list));
                bufferedWriter.close();
            }
            bufferedReader.close();
        }
    }
}

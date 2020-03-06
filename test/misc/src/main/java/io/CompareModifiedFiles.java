/**
 * https://javarush.ru/tasks/com.javarush.task.task19.task1916#discussion
 * Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
 * Нужно создать объединенную версию строк, записать их в список lines.
 * Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
 * В оригинальном и редактируемом файлах пустых строк нет!
 */
package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompareModifiedFiles {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
//        String file1 = "c:/000/1.txt";
//        String file2 = "c:/000/2.txt";
        bufferedReader.close();

        List<String> list1 = new ArrayList<>();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
        while (bufferedReader1.ready()) list1.add(bufferedReader1.readLine());
        bufferedReader1.close();

        List<String> list2 = new ArrayList<>();
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
        while (bufferedReader2.ready()) list2.add(bufferedReader2.readLine());
        bufferedReader2.close();

        int idx1 = 0;
        int idx2 = 0;
        do {
            while (idx1 == list1.size() & idx2 != list2.size()) {
//                System.out.println("---ADDED " + list2.get(idx2 + 1));
                lines.add(new LineItem(Type.ADDED, list2.get(idx2)));
                idx2++;
            }
            while (idx1 != list1.size() & idx2 == list2.size()) {
//                System.out.println("---REMOVED " + list1.get(idx1));
                lines.add(new LineItem(Type.REMOVED, list1.get(idx1)));
                idx1++;
            }
            if (idx1 == list1.size() && idx2 == list2.size()) break;

            if (list1.get(idx1).equals(list2.get(idx2))) {
//                System.out.println("---SAME " + list1.get(idx1));
                lines.add(new LineItem(Type.SAME, list1.get(idx1)));
                idx1++;
                idx2++;
            } else if (list1.get(idx1).equals(list2.get(idx2 + 1))) {
//                System.out.println("---ADDED " + list2.get(idx2));
                lines.add(new LineItem(Type.ADDED, list2.get(idx2)));
                idx2++;
            } else if (list2.get(idx2).equals(list1.get(idx1 + 1))) {
//                System.out.println("---REMOVED " + list1.get(idx1));
                lines.add(new LineItem(Type.REMOVED, list1.get(idx1)));
                idx1++;
            }
        } while (true);
//        lines.forEach(a -> System.out.println(a.type + " " + a.line));
    }


    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

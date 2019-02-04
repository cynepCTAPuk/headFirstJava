package chap18_io;
import java.io.*;
import java.util.*;
public class Exercise2 {
    public static void main(String[] args) {
        String dir = ".";
        File path = new File(dir);
        String[] list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < list.length ; i++) { // Directory
            File file = new File(list[i]);
            if(file.isDirectory()) {
                System.out.printf("[%-22s] ", list[i]);
                if (i % 3 == 2) System.out.println();
            }
        }
        System.out.println();

        for (int i = 0; i < list.length ; i++) { // File
            File file = new File(list[i]);
            if(file.isFile()) {
                System.out.printf("%-20s ", file.getName());
                System.out.printf("%,6d \n", file.length());
            }

        }
    }
}

package chap18_io;
import java.io.*;
public class Exercise2 {
    public static void main(String[] args) {
        String dir = ".";
        File path = new File(dir);
        String[] list = path.list();

        for (int i = 0; i < list.length ; i++) {
            if(new File(list[i]).isDirectory()) {
                System.out.printf("[%-24s] ", list[i]);
                if (i % 3 == 2) System.out.println();
            }
        }
        for (int i = 0; i < list.length ; i++) {
            if(new File(list[i]).isFile()) {
                System.out.printf("%-22s ", list[i]);
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
/*
Test program is not correct
 */
public class DoubleCola {
    public static String WhoIsNext(String[] names, long n) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(names));
        String string = null;
        while (n-- != 0) {
            string = list.remove(0);
            list.add(string);
            list.add(string);
        }
        return string;
    }

    public static void main(String[] args) {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        System.out.println(WhoIsNext(names, 6));
        System.out.printf("%,d",Integer.MAX_VALUE);
        System.out.println();
        System.out.printf("%,d", 7_230_702_951L);


    }
}
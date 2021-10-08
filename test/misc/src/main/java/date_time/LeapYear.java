package date_time;

import java.util.ArrayList;
import java.util.List;

public class LeapYear {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int year = 1500; year < 2030; year++) {
            if ((year & 3) == 0 && ((year % 25) != 0 || (year & 15) == 0)) {
                list.add(year);
            }
        }
        System.out.println(list);
        int year = 2000;
        System.out.println(Integer.toString(year, 2));
        System.out.println(Integer.toString(15, 2));
        System.out.println(((year & 3) == 0) + " " + (year % 25 != 0) + " " + ((year & 15) == 0));
    }
}

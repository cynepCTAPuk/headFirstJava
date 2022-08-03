package integer;

public class LeapYearCount {
    public static void main(String[] args) {
        int year = 2000;
        System.out.println(leapYearCountCycle(year));
        System.out.println(leapYearCount(year));
    }

    public static int leapYearCount(int year) {
        return year / 4 - year / 100 + year / 400;
    }

    public static int leapYearCountCycle(int year) {
        int count = 0;
        for (int i = 1; i <= year; i++) {
            if (i % 400 == 0 || i % 4 == 0 & i % 100 != 0) count++;
        }
        return count;
    }
}

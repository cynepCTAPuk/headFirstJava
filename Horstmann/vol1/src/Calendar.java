import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author Cay Horstmann
 * @version 1.5 2015-05-08
 */
public class Calendar {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        Integer month = date.getMonthValue();
        Integer day = date.getDayOfMonth();

        if (args.length == 3) {
            for (String str : args)
                if (!str.matches("-?\\d+")) // str.matches("-?(0|[1-9]\\d*)");
                    System.exit(0);

            Integer year = Integer.parseInt(args[0]);
            month = Integer.parseInt(args[1]);
            day = Integer.parseInt(args[2]);

            if (month == 0 | day == 0) System.exit(0);

            date = LocalDate.of(year, month, day);
        }

        System.out.print(date + " ");
        System.out.print(date.getMonth() + " ");
        System.out.println(date.getDayOfWeek());

        date = date.minusDays(day - 1); // set to start of month
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, . . . , 7 = Sunday

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) System.out.print("    ");

        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == day) System.out.print("*");
            else System.out.print(" ");

            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }
}

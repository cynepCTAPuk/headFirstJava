package date_time;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws Exception {
        System.out.println("-".repeat(60));

        Date today = new Date();
        System.out.println("Current date: " + today);
        System.out.println("-".repeat(60));

        Date currentTime1 = new Date();           //получаем текущую дату и время
        Thread.sleep(3_000);                      //ждём 3 секунды – 3000 миллисекунд
        Date newTime = new Date();               //получаем новое текущее время
        long msDelay = newTime.getTime() - currentTime1.getTime(); //вычисляем разницу
        System.out.println("Time distance is: " + msDelay + " in ms");
        System.out.println("-".repeat(60));

        Date startTime = new Date();
        long endTime = startTime.getTime() + 5_000;   //    +5 секунд
        Date endDate = new Date(endTime);
        Thread.sleep(3_000);              // ждем 3 секунды
        Date currentTime2 = new Date();
        //проверяем что время currentTime2 после endDate
        if (currentTime2.after(endDate)) System.out.println("End time!");
        System.out.println("-".repeat(60));

        Date currentTime3 = new Date();
        int hours = currentTime3.getHours();
        int mins = currentTime3.getMinutes();
        int secs = currentTime3.getSeconds();
        System.out.println("Time from midnight " + hours + ":" + mins + ":" + secs);
        System.out.println("-".repeat(60));

        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);
        yearStartTime.setDate(1);      // первое число
        yearStartTime.setMonth(0);     // месяц январь, нумерация для месяцев 0-11
        Date currentTime = new Date();
        long msTimeDistance = currentTime.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках
        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней
        System.out.println("Days from start of year: " + dayCount);
        System.out.println("-".repeat(60));
    }
}

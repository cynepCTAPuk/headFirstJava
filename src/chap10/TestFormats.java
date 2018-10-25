package chap10;

import java.util.Date;

public class TestFormats {
    public static void main(String[] args) {
        String s, d;
        Date t = new Date();

        System.out.println(String.format("С Новым %tY годом!\tЖелаем вам %d лет!", t, 100));
        System.out.println(String.format("%tc", t));
        System.out.println(String.format("%tc", new Date()));
        System.out.println(String.format("%tY-%<tB-%<td %<tA %<tr", t));
    }
}

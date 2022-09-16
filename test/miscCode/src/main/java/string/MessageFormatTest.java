package string;

import java.text.MessageFormat;
import java.util.Date;

/**
 * https://javarush.ru/groups/posts/590-klass-messageformat
 */
public class MessageFormatTest {
    public static void main(String[] args) {
        int planet = 7;
        String event = "a disturbance in the Force";

        String s = "At {0, time, short} on {0, date}, there was {1} on planet {2, number, integer}.";
        String result = MessageFormat.format(s, new Date(), event, planet);
        System.out.println(result);

        String m = "At {0, time, medium} on {0, date}, there was {1} on planet {2, number, integer}.";
        result = MessageFormat.format(m, new Date(), event, planet);
        System.out.println(result);

        String l = "At {0, time, long} on {0, date}, there was {1} on planet {2, number, integer}.";
        result = MessageFormat.format(l, new Date(), event, planet);
        System.out.println(result);
    }
}

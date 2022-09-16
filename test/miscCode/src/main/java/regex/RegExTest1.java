package regex;

import nonapi.io.github.classgraph.json.JSONUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest1 {

    public static void main(String[] args) {
        String str = "Я был в Москве в 1977 году, когда мне было 15 лет";
//        String pattern = "([\\D]*)([\\d]*[\\d]*[\\d]*)";
        String pattern = "([\\D]*)([\\d]*)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        while (m.find()) System.out.println(m.group()
//                + " " + m.start() + ":" + m.end()
        );
//        m.find();
//        String sStr = m.group(1);
//        String iStr = m.group(2);
//        System.out.println(sStr);
//        System.out.println(iStr);
    }
}

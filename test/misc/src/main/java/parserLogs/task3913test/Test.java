package parserLogs.task3913test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        String s = "get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"";
        String s = "get ip for user = \"Eduard Petrovich Morozko\"";
        Pattern pattern = Pattern.compile("get (?<tag>\\w+)(\\sfor\\s(?<field>\\w+)\\s=\\s\"(?<value>.{1,40})\")?(\\sand date between\\s\"(?<after>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\"\\sand\\s\"(?<before>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\")?");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group("tag"));
            System.out.println(matcher.group("field"));
            System.out.println(matcher.group("value"));
            System.out.println(matcher.group("after"));
            System.out.println(matcher.group("before"));
        }
    }

    public Set<Object> execute(String query) {
// разбиваем всю строку
        String[] queryElements = query.split(" ");
// если строка как из предыдущего задания...
        if (queryElements.length == 2) {
// ...то вызываем логику которую описали в предыдущем задании
            return getSimpleQuerySet(queryElements[1]);
// если длинее, то...
        } else if (queryElements.length > 2) {
// получаем необходимые данные в ввиде массива строк getFullQueryData и обрабатываем эти данные getFullQuerySet
            return getFullQuerySet(getFullQueryData(query));
        }

        return new HashSet<>();
    }

    private Set<Object> getFullQuerySet(Object fullQueryData) {
        return null;
    }

    private Object getFullQueryData(String query) {
        return null;
    }

    private Set<Object> getSimpleQuerySet(String queryElement) {
        return null;
    }
}

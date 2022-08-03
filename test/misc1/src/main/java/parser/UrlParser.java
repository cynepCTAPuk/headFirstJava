package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UrlParser {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String url = bufferedReader.readLine();
        String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
//        String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        List<Integer> list = new ArrayList<>();
        char[] chars = url.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '?' || ch == '=' || ch == '&')
                list.add(i);
        }
//        System.out.println(list);

        List<String> parameters = new ArrayList<>();
        String objName = null;
        int currIdx = 0;
        int nextIdx = 0;
        for (int i = 0; i < list.size(); i++) {
            currIdx = list.get(i);
            nextIdx = (i + 1 < list.size()) ? list.get(i + 1) : url.length();
            String symbol = url.substring(currIdx, currIdx + 1);
            String param = url.substring(currIdx + 1, nextIdx);
            if (!symbol.equals("=")) {
                parameters.add(param);
                if (param.equals("obj")) {
                    int nextNextIdx = (i + 2 < list.size()) ? list.get(i + 2) : url.length();
                    objName = url.substring(nextIdx + 1, nextNextIdx);
                }
            }
        }
        System.out.println(String.join(" ", parameters));
        if (objName != null) {
            try {
                alert(Double.parseDouble(objName));
            } catch (NumberFormatException e) {
                alert(objName);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

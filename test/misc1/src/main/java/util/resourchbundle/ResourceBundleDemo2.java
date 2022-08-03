package util.resourchbundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo2 {
    public static void main(String[] args) {
        printInfo("ru", "RU");
        printInfo("en", "US");
        printInfo("uk", "UA");
    }

    private static void printInfo(String language, String country) {
        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("text", current);
        for (String key : rb.keySet()) {
            String value = rb.getString(key);
            System.out.println(value);
        }
        System.out.println();
    }
}
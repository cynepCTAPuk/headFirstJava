package util.resourchbundle;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo1 {
    public static void main(String[] args) {
        printInfo("ru", "RU");
        printInfo("en", "US");
        printInfo("uk", "UA");
    }

    private static void printInfo(String language, String country) {
        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle(
                ResourceBundleDemo1.class.getPackage().getName() + ".resources.text", current
//                "text", current
        );

        String s1 = rb.getString("label.button");
        System.out.println(s1);

        String s2 = rb.getString("label.field");
        System.out.println(s2);

        String s3 = rb.getString("message.welcome");
        System.out.println(s3);

        System.out.println();
    }
}
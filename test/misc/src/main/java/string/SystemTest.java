package string;

import java.util.Arrays;

public class SystemTest {
    public static void main(String[] args) {
        for (String key : Arrays.asList(
                "java.version",
                "java.runtime.version",
                "java.specification.version",
                "java.vm.version",
                "java.vm.specification.version")) {
            System.out.println(key + " = " + System.getProperty(key));
        }
        Runtime.Version version = Runtime.version();
        System.out.println("Feature = " + version.feature());
        System.out.println("Interim = " + version.interim());
        System.out.println("Update = " + version.update());
        System.out.println("Patch = " + version.patch());
    }
}

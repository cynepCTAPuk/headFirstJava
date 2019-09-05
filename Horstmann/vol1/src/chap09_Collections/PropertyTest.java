package chap09_Collections;

public class PropertyTest {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperties().toString()
                .replace(", ", ",\n")
                .replace("=", " = ")
//                .replace(";", "\n\t\t")
        );
    }
}

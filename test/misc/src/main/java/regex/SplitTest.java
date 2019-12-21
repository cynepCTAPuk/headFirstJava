package regex;

public class SplitTest {
    public static void main(String[] args) {
        String number = "+38(050)123-45-67";
        System.out.println(String.join("",number.split("[-()]")));
        System.out.println(number.replaceAll("[^0-9]", ""));
        System.out.println(number.replaceAll("\\D", ""));
        System.out.println(number.replaceAll("[^\\d]", ""));
    }
}

package primitive;

public class Test {
    public static void main(String[] args) {
        String text = "0b11111100101";
//        text = "03745";
//        text = "0x7e5";
        int value = text.toLowerCase().startsWith("0b")
                ? Integer.parseInt(text.substring(2), 2)
                : Integer.decode(text);
        System.out.println(text + " = " + value);
    }
}

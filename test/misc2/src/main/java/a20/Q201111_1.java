package aaa;

public class Q201111_1 {
    public static void main(String[] args) {
        try {
            String str = "This is a test string.";
            String[] array = str.split(" ");
            System.out.println(array.length);
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}

package string;

public class StringTest {
    public static void main(String[] args) {
        String string = "ПриветМир";
        System.out.println(string.getBytes().length);
        for (int i = 0; i < string.getBytes().length; i++) {
            System.out.print(string.getBytes()[i]);
        }
        System.out.println();
        System.out.println(string.length());
        String[] bytes = string.split("");
        for (String s : bytes) {
            System.out.format("%6s", s);
        }
        System.out.println();
        System.out.println("\uD83D\uDD0A");
        System.out.println("\u1148\u0097");
    }
}

package tasks;

public class chap4_04 {
    public static void main(String[] args) {
        String in = "в леСу Родилась еЛОчка";
        System.out.println("<" + in + ">");
        StringBuilder sb = new StringBuilder();
        String[] parts = in.split(" ");
        for (String word : parts) {
            sb.append(word.substring(0,1).toUpperCase());
            sb.append(word.substring(1).toLowerCase());
            sb.append(" ");
        }
        String out = sb.substring(0, sb.length() - 1);
        System.out.println("<" + out + ">");
    }
}
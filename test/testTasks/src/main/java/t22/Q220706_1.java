package t22;

public class Q220706_1 {
    public static void main(String[] args) {
        try {
            String value = "29.1";
            System.out.println((Float.valueOf(value) + 1.0) == 30.1);
            System.out.println((Double.valueOf(value) + 1.0) == 30.1);
            System.out.println(Float.valueOf(value) / 0);
            System.out.println(Double.valueOf(value) / 0);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
    }
}
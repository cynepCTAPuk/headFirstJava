package patterns.template_method;

public class TemplateTest {
    public static void main(String[] args) {
        BinaryOperation plus = new Plus(1, 3);
        BinaryOperation minus = new Minus(1, 3);

        System.out.println((int) plus.getResult());
        System.out.println((int) minus.getResult());

        System.out.println((int) new Plus(10, 1).getResult());
        System.out.println((int) new Minus(10, 1).getResult());
    }
}

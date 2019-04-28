/**
 * @author CTAPuk :
 */
public class BeQuadratic_equation {
    public static void main(String args[]) {
        //a*x^4 + bx^2 + c = 0; D = b^2 - 4ac; y = x^2
        int a = 1, b = 2, c = -3;
        double D = b * b - 4 * a * c;
        double y, y1, y2, x1, x2, x3, x4;
        System.out.println("a = " + a + " b = " + b + " c = " + c + " D = " + D);
        y1 = (double) -c / b;

        if (a == 0) {
            System.out.println("a = " + a + " it's not acceptable");
        } else {
            if (D > 0) {
                y1 = (-b + Math.sqrt(D)) / (2 * a);
                y2 = (-b - Math.sqrt(D)) / (2 * a);
                System.out.println("ó1 = " + y1 + "\tó2 = " + y2);
                if (y1 >= 0) {
                    x1 = Math.sqrt(y1);
                    x2 = -Math.sqrt(y1);
                    System.out.println("x1 = " + x1 + "\nx2 = " + x2);
                }
                if (y2 >= 0) {
                    x3 = Math.sqrt(y2);
                    x4 = -Math.sqrt(y2);
                    System.out.println("x3 = " + x3 + "\nx4 = " + x4);
                }
            }
            if (D == 0) {
                y1 = (-b / (2 * a));
                if (y1 >= 0) {
                    x1 = Math.sqrt(y1);
                    x2 = -Math.sqrt(y1);
                    System.out.println("y1 = " + y1);
                    System.out.println("x1 = " + x1 + "\nx2 = " + x2);
                } else System.out.println("NO ROOTS!");
            }
            if (D < 0) System.out.println("NO ROOTS!");
        }
    }
}

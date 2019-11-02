package com.example;

public class Quadratic_equation{
    public static void main(String args[]) {
        //a*x^2 + bx + c = 0; D = b^2 - 4ac
        //if D > 0 => x1 = (-b + sqrt(D))/(2a); x2 = (-b - sqrt(D))/(2a)
        //if D = 0 => x1 = x2 = -b/(2a)
        //if D < 0 => x = not exist
        int a = 1, b = 2, c = -3;
        double D = b * b - 4 * a * c; //Determination
        double sqrt = D / 1.999;    //First Estimation Sqrt
        double R = 1.0E-15;     //Precision
        double x, x1, x2;       //Solutions
        int i = 1;
        System.out.println("Equation\t" + a + "*x^2 + " + b + "*x + " + c + " = 0" + "\nDetermination = " + D);

        if (a == 0) {
            x = -c / b;
            System.out.println("x = " + x);
        } else {
            if (D > 0) {
                //Calculation Square Root of Determination by Newton's method
                //Finding sqrtS is the same as solving the equation  f(x)=x^2-S=0 for a positive x
                // x = x - F(x)/F`(x) = x - (x^2 - S)/(2*x) = 1/2*(x + S/x);
                while ((((sqrt * sqrt) - D) > R) || (D - (sqrt * sqrt)) > R) {
                    sqrt = (sqrt + D / sqrt) / 2;
                    System.out.println(i + "\tsqrt^2 = " + sqrt * sqrt + "\t difference = " + ((sqrt * sqrt) - D));
                    i++;
                }
                x1 = (-b + sqrt) / (2 * a);
                x2 = (-b - sqrt) / (2 * a);
                System.out.println("x1 = " + x1 + "\nx2 = " + x2);
            }

            if (D == 0) {
                x = -b / (2 * a);
                System.out.println("x = " + x);
            }

            if (D < 0) {
                System.out.println("Solutions are not exist");
            }
        }
    }
}

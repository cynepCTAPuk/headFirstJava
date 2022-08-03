package logical;

import static unsort.MyMath.factorial;

public class Oo {
    public static void main(String[] args) {
        int n = 100_000;

//        System.out.println(Math.log(Math.log(n) / Math.log(2)) / Math.log(2));
//        System.out.println(Math.sqrt(Math.log(n) / Math.log(4)));

//        System.out.println(Math.log(n) / Math.log(3));
//        System.out.println(Math.pow(Math.log(n) / Math.log(2), 2));
//        System.out.println(Math.sqrt(n));

        System.out.println();
//        System.out.println(n / (Math.log(n) / Math.log(5)));
//        System.out.println(Math.log(factorial(n)) / Math.log(2));
        System.out.println(Math.pow(3, Math.log(n) / Math.log(2)));
        System.out.println(Math.pow(n, 2));
        System.out.println(Math.pow(7, Math.log(n) / Math.log(2)));

        System.out.println(Math.pow(Math.log(n) / Math.log(2), (Math.log(n) / Math.log(2))));
//        System.out.println(Math.pow(n, Math.log(n) / Math.log(2)));
//        System.out.println(Math.pow(n, (Math.sqrt(n))));
//        System.out.println(Math.pow(2, n));
//        System.out.println(Math.pow(4, n));

//        System.out.println(Math.pow(2, 3 * n));
//        System.out.println(factorial(n));
//        System.out.println(Math.pow(2, Math.pow(2, n)));

    }

}

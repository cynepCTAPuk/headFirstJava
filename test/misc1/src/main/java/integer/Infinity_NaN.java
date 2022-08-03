package integer;

public class Infinity_NaN {
    public static void main(String[] args) {
        double positiveInfinity = Double.POSITIVE_INFINITY;
        System.out.println(positiveInfinity); // Бесконечность
        System.out.println(positiveInfinity + 1); //Бесконечность + 1 ==Бесконечность
        System.out.println(positiveInfinity + 10); //Бесконечность + 10 ==Бесконечность
        System.out.println(positiveInfinity + positiveInfinity); //Бесконечность + 10 ==Бесконечность
        System.out.println(positiveInfinity * -1); //равно «минус бесконечность»
        System.out.println();

        double negativeInfinity = Double.NEGATIVE_INFINITY;
        System.out.println(negativeInfinity); // -Infinity
        System.out.println();

        System.out.println(1 / positiveInfinity); // 0.0
        System.out.println(1 / negativeInfinity); // -0.0
        System.out.println(positiveInfinity * positiveInfinity); // Infinity
        System.out.println(positiveInfinity / 0); // Infinity
        System.out.println(negativeInfinity / 0); // -Infinity
        System.out.println(0 / positiveInfinity); // 0.0
        System.out.println(positiveInfinity + negativeInfinity); // NaN
        System.out.println(positiveInfinity / negativeInfinity); // NaN
        System.out.println(positiveInfinity * 0); // NaN

    }
}

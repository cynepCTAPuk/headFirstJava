package primitive;

public class FloatTest1 {
    public static void main(String[] args) {

        final double threshold = 0.0001;

    //прибавляем к нулю 0.1 одиннадцать раз подряд
        double f1 = .0;
        for (int i = 1; i <= 11; i++) f1 += .1;

    //Умножаем 0.1 на 11
        double f2 = .1 * 11;

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        if (Math.abs(f1 - f2) < threshold)
            System.out.println("f1 и f2 равны");
        else
            System.out.println("f1 и f2 не равны");
    }
}

package vasilievAN;

// Класс со статическим полем и статическим методом:
class MyMath {
    final static double PI = 3.14159265; // Статическая константа:

    // Статический метод для вычисления синуса:
    static double sin(double x, int n) {
        double s = 0, q = x; // Локальные переменные:
// Оператор цикла для вычисления ряда Тейлора для синуса:
        for (int i = 1; i <= n; i++) {
            s = s + q;
            q = q * ((-1) * x * x / (2 * i) / (2 * i + 1));
        }
        return s + q; // Результат:
    }
}

// Класс с главным методом:
class StatMathDemo {
    public static void main(String[] args) {
        int del = 4;
        double angle = MyMath.PI / del;
// Текст для отображения в окне сообщения:
        String text = "Значения ряда Тейлора для синуса: PI/" + del;
// Оператор цикла для вычисления синуса (несколько значений):
        for (int n = 0; n < 15; n++)
            text += "\nСлагаемых " +
                    (n + 1) + ": sin(PI/"+del+") =\t" +
        MyMath.sin(angle, n);
        text += "\n\t\t\t\t\t\t\t" +
                Math.sin(angle);
// Отображение окна сообщения:
        System.out.println(text);
//        JOptionPane.showMessageDialog(null, text);
    }
}
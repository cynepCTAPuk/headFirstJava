import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaylorForExponential {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter exp for е: "); // Вводим число x
            String enter = in.readLine();
            int exp = Integer.parseInt(enter);
            myThread t = new myThread(exp); // Создаем поток
            Thread thread = new Thread(t); // Упакуем его в объект класса Thread
            thread.start(); // Старт!

            while (true) {
                String line = in.readLine();
                if (line.equals("exit")) {
                    thread.interrupt(); // Остановка потока
                    thread.join();
                    return;
                }
                System.out.println("Result: " + t.getResult()); // Иначе - это строка - вывод результата
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class myThread implements Runnable {
    private int exp; // степень при е
    private double result; // текущий результат

    myThread(int exp) {
        this.exp = exp;
        this.result = 0;
    }

    public void run() {
        // начинаем с 0 члена
        try {
            exp(0);
        } catch (InterruptedException e) {
        }
    }

    private void exp(int count) throws InterruptedException {
        result += Math.pow(exp, count) / factorial(count); // Прибавим следующий член ряда
        Thread.sleep(1000); // перерыв - 1 секунда
        exp(++count); // Следующая итерация
    }

    // Вычисление факториала - возможно есть альтернативные java средства?
    private long factorial(int number) {
        if (number == 0) return 1;
        return number * factorial(--number);
/*
        int result = 1;
        for (long i = 1; i <= number; i++) result *= i;
        return result;
*/
    }

    synchronized double getResult() {
        return result;
    }
}
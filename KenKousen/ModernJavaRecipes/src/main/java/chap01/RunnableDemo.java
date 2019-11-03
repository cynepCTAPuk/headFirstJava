package chap01;

public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("внутри Runnable в анонимном внутреннем классе");
            }
        }).start();

        new Thread(()-> System.out.println("внутри конструктора Thread с использованием лямюы")).start();

        Runnable r = () -> System.out.println("лямбда-выражение, реализуещее метод run");
        new Thread(r).start();
    }
}

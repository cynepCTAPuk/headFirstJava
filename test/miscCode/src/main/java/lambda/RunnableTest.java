package lambda;

public class RunnableTest {
    interface A {
        void consume(String arg);
    }

    public static void main(String[] args) {
        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello runnableA!");
            }
        };
        runnableA.run();
        System.out.println("runnableA.class: " + runnableA.getClass());

        Runnable runnableB = () -> System.out.println("Hello runnableB!");
        runnableB.run();
        System.out.println("runnableB.class: " + runnableB.getClass());

        A a = System.out::println;
        a.consume("Hello A");
        System.out.println("a: " + a.getClass());
    }
}

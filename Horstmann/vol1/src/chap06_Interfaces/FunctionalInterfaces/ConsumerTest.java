package chap06_Interfaces.FunctionalInterfaces;

public class ConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        repeat(40, () -> System.out.print("+"));
        repeat(40, () -> System.out.print("-"));

//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);
    }


    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) action.run();
    }
}

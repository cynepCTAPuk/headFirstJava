package web.stepik.web2;

public class RuntimeTest {
    public static void main(String[] args) {
        long free = Runtime.getRuntime().freeMemory();
        long max = Runtime.getRuntime().maxMemory();
        System.out.printf("%,14d%n",free);
        System.out.printf("%,14d",max);
    }
}

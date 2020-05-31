package web.stepik.web2;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread kolya = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("Коле");
                System.out.print(" ");
                System.out.print("15");
                System.out.print(" ");
                System.out.print("лет");
                System.out.println();
            }
        });
        Thread lena = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("Лене");
                System.out.print(" ");
                System.out.print("21");
                System.out.print(" ");
                System.out.print("год");
                System.out.println();
            }
        });
        kolya.start();
        lena.start();
    }
}

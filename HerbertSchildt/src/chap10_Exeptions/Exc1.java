package chap10_Exeptions;

public class Exc1 {
    static void subroutin() {
        int d = 0;
        int a = 42 / d;
    }

    public static void main(String[] args) {
        Exc1.subroutin();
    }
}

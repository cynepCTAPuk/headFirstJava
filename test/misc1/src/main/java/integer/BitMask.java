package integer;

public class BitMask {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = false;
        boolean d = true;
        int result = 0;
        if (a) result += 1; //1 == 20 — нулевой бит
        if (b) result += 2; //2 == 21 — первый бит
        if (c) result += 4; //4 == 22 — второй бит
        if (d) result += 8; //8 == 23 — третий бит
        System.out.println(Integer.toString(result, 2));
    }
}

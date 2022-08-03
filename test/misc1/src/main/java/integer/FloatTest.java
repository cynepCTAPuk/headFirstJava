package integer;

public class FloatTest {
    public static void main(String[] args) {
        float x = 1.0F;
        int numFloats = 0;
        int count = 0;
        while (x <= 2.0) {
            numFloats++;
//            System.out.println(x);
            x = Math.nextUp(x);

        }
        System.out.printf("%,d", numFloats);
    }
}

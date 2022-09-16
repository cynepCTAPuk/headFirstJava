package logical;

public class ConvertDecToBinary {
    private static String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) return binaryRepresentationMethod(b) + result;
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.print(binaryRepresentationMethod(i) + " ");
        }
    }
}

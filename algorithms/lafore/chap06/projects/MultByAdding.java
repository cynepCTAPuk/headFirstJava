package lafore.chap06.projects;

public class MultByAdding {
    static int i = 0;

    public static void main(String[] args) {
        int a = 11;
        int b = 9;
        int c = mult(a, b);
        System.out.println(a + " x " + b + " = " + c);
    }

    public static int mult(int first, int second) {
        int result;
        if (second == 1) {
            System.out.println(++i + " step " + first);
            result = first;
        } else {
            result = first + mult(first, second - 1);
            System.out.println(++i + " step " + result);
        }
        return result;
    }
}

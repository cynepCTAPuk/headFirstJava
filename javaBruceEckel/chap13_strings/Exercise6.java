package chap13_strings;

public class Exercise6 {
    int i;
    long l;
    float f;
    double d;

    public Exercise6(int i, long l, float f, double d) {
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
    }

    @Override
    public String toString() {
//        return "Exercise6{" + "i=" + i + ", l=" + l + ", f=" + f + ", d=" + d + '}';
        return String.format("Exercise6{i=%d, l=%l, f=%f, d=%f}", i, l, f, d);
    }

    public static void main(String[] args) {
        Exercise6 ex = new Exercise6(1, 2l, 3.00f, 4.00);
        System.out.println(ex);
    }
}

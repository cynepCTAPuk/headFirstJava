package date_time;

public class BooleanExpression {
    public static void main(String[] args) {
        System.out.println(booleanExpression(false, false, false, false)); // 0 false
        System.out.println(booleanExpression(false, false, false, true)); // 1 false
        System.out.println(booleanExpression(false, false, true, false)); // 2 false
        System.out.println(booleanExpression(false, false, true, true)); // 3 true
        System.out.println(booleanExpression(false, true, false, false)); // 4 false
        System.out.println(booleanExpression(false, true, false, true)); // 5 true
        System.out.println(booleanExpression(false, true, true, false)); // 6 false
        System.out.println(booleanExpression(false, true, true, true)); // 7 false
        System.out.println(booleanExpression(true, false, false, false)); // 8 false
        System.out.println(booleanExpression(true, false, false, true)); // 9 true
        System.out.println(booleanExpression(true, false, true, false)); // 10 true
        System.out.println(booleanExpression(true, false, true, true)); // 11 false
        System.out.println(booleanExpression(true, true, false, false)); // 12 true
        System.out.println(booleanExpression(true, true, false, true)); // 13 false
        System.out.println(booleanExpression(true, true, true, false)); // 14 false
        System.out.println(booleanExpression(true, true, true, true)); // 15 false


    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        System.out.print(a ? 1 : 0);
        System.out.print(b ? 1 : 0);
        System.out.print(c ? 1 : 0);
        System.out.print(d ? 1 : 0);
        System.out.print(" ");
//        if (a & b & c & d || !a & !b & !c & !d) return false;
//        return (a ^ b) == (c ^ d) == (a ^ c) == (a ^ d) == (b ^ c) == (b ^ d);
        return (a ^ b) & (c ^ d) | (a ^ c) & (b ^ d);
//        return (a ? 1 : 0) + (b ? 1 : 0) + (c ? 1 : 0) + (d ? 1 : 0) == 2;

//        return a ^ b ? c ^ d : a ^ c && b ^ d;
//        return a != b && c != d || a != c && b != d;
//        return a | b | c | d && !(a & b & c & d) && !(a ^ b ^ c ^ d);
    }
}

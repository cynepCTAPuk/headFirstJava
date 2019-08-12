package chap12_Enums_Annotations;

// Demonstrate ordinal(), compareTo() and equals()
public class EnumDemo4 {
    public static void main(String[] args) {
        Apple1 ap1, ap2, ap3;

        // Obtain all ordinal values using ordinal()
        System.out.println("Here are all apple constants and their ordinal values:");
        for (Apple1 a : Apple1.values()) System.out.println(a + " " + a.ordinal());

        ap1 = Apple1.RedDel;
        ap2 = Apple1.GoldenDel;
        ap3 = Apple1.RedDel;
        System.out.println();

        // Demonstrate compareTo() and equals()
        if (ap1.compareTo(ap2) < 0) System.out.println(ap1 + " comes before " + ap2);
        if (ap1.compareTo(ap2) > 0) System.out.println(ap2 + " comes before " + ap1);
        if (ap1.compareTo(ap2) == 0) System.out.println(ap1 + " equals " + ap2);
        System.out.println();

        if (ap1.equals(ap2)) System.out.println("Error!");
        if (ap1.equals(ap3)) System.out.println(ap1 + " equals " + ap3);
        if (ap1 == ap3) System.out.println(ap1 + " == " + ap3);
    }
}

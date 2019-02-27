public class Shifty {
    public static void main(String[] args) {
        int i = 0;
        int count = 0;
        System.out.format("%12s   %5s %2s %1s%n","number","true","count","i");
        while ((-1 << i) != 0) {
            System.out.format("%15d", -1 << i);
            System.out.print(" ");
            System.out.format("%5s", i != 0);
            System.out.print(" ");
            i++;
            count++;
            System.out.format("(%2d -%3d)%n", count, i);
            if (count > 33) break;
//            if (count % 10 == 0) System.out.println();
        }
    }
}

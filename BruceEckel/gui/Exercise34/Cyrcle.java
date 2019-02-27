package gui.Exercise34;

public class Cyrcle {
    public static void main(String[] args) {
        int n = 5;
        double pi = 2*Math.PI;
        for (int i = 0; i < n; i++) {
            double sin = Math.sin(pi * i / n);
            double cos = Math.cos(pi * i / n);
            int sinInt = (int)(sin*10_000);
            int cosInt = (int)(cos*10_000);
            System.out.printf("sin(%3d)= %,6d cos(%3d)= %,6d\n",
                    (360*i/n), sinInt, (360*i/n), cosInt);
        }
    }
}

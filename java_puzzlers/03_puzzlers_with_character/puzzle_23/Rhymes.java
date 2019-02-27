import java.util.*;

public class Rhymes {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        StringBuffer word = null;
        int rand = rnd.nextInt(3);

        switch (rand) {
            case 1:
                word = new StringBuffer('P');
                word.append('P');
                break;
            case 2:
                word = new StringBuffer('G');
                word.append('G');
                break;
            default:
                word = new StringBuffer('M');
                word.append('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println("word = " + word);
        System.out.println("random = " + rand);
        System.out.println("P(1) = " + (int) 'P' + "\nG(2) = " + (int) 'G' + "\nM(0) = " + (int) 'M');
        System.out.println("word.capacity() = " + word.capacity());

        StringBuffer p = new StringBuffer();
        StringBuffer g = new StringBuffer();
        StringBuffer m = new StringBuffer();

        for (int i = 0; i < 200; i++) {
            rand = rnd.nextInt(3);
            switch (rand) {
                case 1:
                    p.append('P');
                    break;
                case 2:
                    g.append("G");
                    break;
                default:
                    m.append("M");
            }
        }
        System.out.println(p);
        System.out.println(g);
        System.out.println(m);
    }
}

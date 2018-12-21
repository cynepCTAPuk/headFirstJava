import java.util.*;

public class Rhymes {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        StringBuffer word = null;
        int rand = rnd.nextInt(2);
        System.out.println(rnd.nextInt(2));

        switch (rand) {
            case 1:
                word = new StringBuffer('P');
            case 2:
                word = new StringBuffer('G');
            default:
                word = new StringBuffer('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
        System.out.println(word.capacity());
    }
}

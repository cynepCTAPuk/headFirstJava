import java.util.Arrays;
public class FruitMachine {
    public static int fruit(final String[][] reels, final int[] spins) {
        int[] data = new int[3];
        for (int i = 0; i < 3; i++) data[i] = Fruits.valueOf(reels[i][spins[i]]).getScore();
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        if (data[1] == data[0]) {
            if (data[2] == data[1]) return data[1] * 10;
            return data[2] == 10 ? data[0] * 2 : data[0];
        }
        if (data[2] == data[1]) return data[1];
        return 0;
    }
    enum Fruits {
        Wild(10), Star(9), Bell(8), Shell(7), Seven(6), Cherry(5), Bar(4), King(3), Queen(2), Jack(1);
        private int score;
        Fruits(int score) {this.score = score;}
        public int getScore() {return score;}
    }
    public static void main(String[] args) {
        System.out.println(fruit(new String[][]{new String[]{"Wild", "Star", "Bell", "Shell", "Seven", "Cherry", "Bar", "King", "Queen", "Jack"}, new String[]{"Wild", "Star", "Bell", "Shell", "Seven", "Cherry", "Bar", "King", "Queen", "Jack"}, new String[]{"Wild", "Star", "Bell", "Shell", "Seven", "Cherry", "Bar", "King", "Queen", "Jack"}}, new int[]{0, 0, 0}));
        System.out.println(fruit(new String[][]{new String[]{"Wild", "Star", "Bell", "Shell", "Seven", "Cherry", "Bar", "King", "Queen", "Jack"}, new String[]{"Bar", "Wild", "Queen", "Bell", "King", "Seven", "Cherry", "Jack", "Star", "Shell"}, new String[]{"Bell", "King", "Wild", "Bar", "Seven", "Jack", "Shell", "Cherry", "Queen", "Star"}}, new int[]{5, 4, 3}));
        System.out.println(fruit(new String[][]{new String[]{"King", "Cherry", "Bar", "Jack", "Seven", "Queen", "Star", "Shell", "Bell", "Wild"}, new String[]{"Bell", "Seven", "Jack", "Queen", "Bar", "Star", "Shell", "Wild", "Cherry", "King"}, new String[]{"Wild", "King", "Queen", "Seven", "Star", "Bar", "Shell", "Cherry", "Jack", "Bell"}}, new int[]{0, 0, 1}));
        System.out.println(fruit(new String[][]{{"Jack", "Seven", "Cherry", "Bar", "Bell", "Queen", "King", "Wild", "Shell", "Star"},{"Wild", "Queen", "Jack", "Shell", "Cherry", "Bar", "Seven", "Star", "Bell", "King"},{"Seven", "Jack", "King", "Bar", "Star", "Wild", "Shell", "Queen", "Cherry", "Bell"}}, new int[]{4,9,9}));
    }
}


package puzzle_36;

public class Indecisive {
    public static void main(String[] args) {
        System.out.println(decision());
    }

    static boolean decision() {
        try {
            System.out.println(true);
//            return true;
        } finally {
            return false;
        }
    } 
}

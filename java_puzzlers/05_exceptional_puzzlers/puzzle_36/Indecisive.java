package puzzle_36;

public class Indecisive {
    public static void main(String[] args) {
        System.out.println(decision());
    }

    static boolean decision() {
        try {
            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            return false;
        }
    }
}

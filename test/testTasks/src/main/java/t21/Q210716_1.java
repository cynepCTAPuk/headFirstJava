package t21;

public class Q210716_1 {
    {
        System.out.println("Block");
    }

    int x = getX();

    static {
        System.out.println("Static block");
    }

    private int getX() {
        System.out.println("X variable");
        return 5;
    }

    static int y = getY();

    private static int getY() {
        System.out.println("Y variable");
        return 6;
    }

    public static void main(String[] args) {
        Q210716_1 test = new Q210716_1();
    }
}


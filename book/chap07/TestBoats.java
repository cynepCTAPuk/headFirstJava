package chap07;

class Rowboat extends Boat {
    public void rowTheBoat() {
        System.out.println("stroke natasha");
    }
}

class Boat {
    private int lenght;

    public void setLength(int len) {
        lenght = len;
    }

    public int getLenght() {
        return lenght;
    }

    public void move() {
        System.out.println("drift");
    }
}

public class TestBoats {
    public static void main(String[] args) {
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        Rowboat b3 = new Rowboat();
        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();
    }
}

class Sailboat extends Boat {
    public void move() {
        System.out.println("hoist sail");
    }
}

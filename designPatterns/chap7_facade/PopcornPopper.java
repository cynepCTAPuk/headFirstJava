package chap7_facade;

public class PopcornPopper {
    String popcornPopper = "off";

    public void on() {
        popcornPopper = "on";
        System.out.println("Popcorn Popper " + popcornPopper);
    }

    public void off() {
        popcornPopper = "off";
        System.out.println("Popcorn Popper " + popcornPopper);
    }

    public void pop() {
        popcornPopper = "popping popcorn!";
        System.out.println("Popcorn Popper " + popcornPopper);
    }

    @Override
    public String toString() {
        return "Popcorn Popper " + popcornPopper;
    }
}

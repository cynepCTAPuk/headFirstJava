package chap07_facade;

public class Projector {
    Amplifier amplifier;

    public void on() {
        System.out.println("Top-O-Line Projector on");
    }

    public void off() {
        System.out.println("Top-O-Line Projector off");
    }

    public void tvMode() {
        System.out.println("Top-O-Line Projector in tv mode");
    }

    public void wideScreenMode() {
        System.out.println("Top-O-Line Projector in widescreen mode(16x9 aspect ratio");
    }
}

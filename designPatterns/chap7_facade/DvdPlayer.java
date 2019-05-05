package chap7_facade;

public class DvdPlayer {
    Amplifier amplifier;
    String movie;

    public void on() {
        System.out.println("Top-O-Line DVD Player on");
    }
    public void off() {
        System.out.println("Top-O-Line DVD Player off");
    }
    public void eject() {        System.out.println("Top-O-Line DVD Player eject");
    }
    public void pause() {
        System.out.println("Top-O-Line DVD Player pause");

    }

    public void play(String movie) {this.movie = movie;
        System.out.println("Top-O-Line DVD Player playing \"" + movie +"\"");
    }
    public void setSurroundAudio() {amplifier.setSurroundSound();}
    public void setTwoChannelAudio() {amplifier.setStereoSound();}
    public void stop() {
        System.out.println("Top-O-Line DVD Player stopped \"" + movie +"\"");

    }
}

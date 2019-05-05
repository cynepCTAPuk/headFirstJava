package chap7_facade;

public class DvdPlayer {
    Amplifier amplifier;
    String movie;

    public void on() {}
    public void off() {}
    public void eject() {}
    public void pause() {}
    public void play(String movie) {this.movie = movie;}
    public void setSurroundAudio() {amplifier.setSurroundSound();}
    public void setTwoChannelAudio() {amplifier.setStereoSound();}
    public void stop() {}
}

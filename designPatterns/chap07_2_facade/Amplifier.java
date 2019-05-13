package chap07_2_facade;

public class Amplifier {
    CdPlayer cdPlayer;
    DvdPlayer dvdPlayer;
    Tuner tuner;
    private int volume;
    private boolean stereoSound;
    private boolean surroundSound;

    public void on() {
        System.out.println("Top-O-Line Amplifier on");
    }

    public void off() {
        System.out.println("Top-O-Line Amplifier off");
    }

    public void setCd(CdPlayer cdPlayerd) {
        this.cdPlayer = cdPlayerd;
    }

    public void setDvd(DvdPlayer dvdPlayervd) {
        this.dvdPlayer = dvdPlayervd;
        System.out.println("Top-O-Line Amplifier setting DVD player to Top-O-Line DVD Player");
    }

    public void setStereoSound() {
        stereoSound = true;
        surroundSound = false;
        System.out.println("Top-O-Line Amplifier stereo sound on (2 speakers, 1 subwoofer)");
    }

    public void setSurroundSound() {
        stereoSound = false;
        surroundSound = true;
        System.out.println("Top-O-Line Amplifier surround sound on (5 speakers, 1 subwoofer)");
    }

    public void setTuner() {

    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Top-O-Line Amplifier setting volume to " + volume);
    }
}

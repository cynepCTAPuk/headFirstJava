package chap7_facade;

public class Amplifier {
    CdPlayer cdPlayer;
    DvdPlayer dvdPlayer;
    Tuner tuner;
    private int volume;
    private boolean stereoSound;
    private boolean surroundSound;

    public void on() {

    }

    public void off() {

    }

    public void setCd(CdPlayer cdPlayerd) {
        this.cdPlayer = cdPlayerd;
    }

    public void setDvd(DvdPlayer dvdPlayervd) {
        this.dvdPlayer = dvdPlayervd;
    }

    public void setStereoSound() {
        stereoSound = true;
        surroundSound = false;
    }

    public void setSurroundSound() {
        stereoSound = false;
        surroundSound = true;
    }

    public void setTuner() {

    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

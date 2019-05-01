package chap06_command;

public class Stereo {
    String room;
    int volume;

    public Stereo(String room) {
        this.room = room;
    }

    void on() {
        System.out.println(room + " stereo is on");
    }

    void off() {
        System.out.println(room + " stereo is off");
    }

    void setCD() {
        System.out.println(room + " stereo is set for CD input");
    }

    void setDvd() {
        System.out.println(room + " stereo is set for Dvd input");
    }

    void setRadio() {
        System.out.println(room + " stereo is set for Radio");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(room + " stereo volume set to 11");
    }
}

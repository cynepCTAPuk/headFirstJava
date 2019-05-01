package chap06_command;

public class Stereo {
    String room;
    int volume;

    public Stereo(String room) {this.room = room;}

    void on() {
        System.out.println("Stereo is in \'" + room + "\' On");
    }

    void off() {
        System.out.println("Stereo is in \'" + room + "\' Off");
    }

    void setCD() {
        System.out.println("Set CD");
    }

    void setDvd() {
        System.out.println("Set Dvd");
    }

    void setRadio() {
        System.out.println("Set Radio");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume is " + volume);
    }
}

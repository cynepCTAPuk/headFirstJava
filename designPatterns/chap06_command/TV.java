package chap06_command;

public class TV {
    private String location;
    private int inputChannel;
    private int volume;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " TV is on");
    }

    public void off() {
        System.out.println(location + " TV is off");
    }

    public int getInputChannel() {
        return inputChannel;
    }

    public void setInputChannel(int inputChannel) {
        this.inputChannel = inputChannel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

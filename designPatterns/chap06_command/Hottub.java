package chap06_command;

public class Hottub {
    int temperature;

    public void on() {
        System.out.println("Hottub is on");
    }

    public void off() {
        System.out.println("Hottub is off");
    }

    public void circulate() {
        System.out.println("Hottup is circulate");
    }

    public void jetsOn() {
        System.out.println("Hottup jets is on");
    }

    public void jetsoff() {
        System.out.println("Hottup jets is off");
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}

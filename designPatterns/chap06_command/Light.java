package chap06_command;

public class Light {
    boolean status;

    public boolean isStatus() {
        return status;
    }

    public void on() {
        status = true;
        System.out.println("Light is On");
    }

    public void Off() {
        status = false;
        System.out.println("Light is Off");
    }
}

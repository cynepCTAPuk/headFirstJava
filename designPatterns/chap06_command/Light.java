package chap06_command;

public class Light {
    String room;

    public Light(String room) {this.room = room;}

    public void on() {
        System.out.println("Light in \'" + room + "\' is On");
    }

    public void off() {
        System.out.println("Light in \'" + room + "\' is Off");
    }
}

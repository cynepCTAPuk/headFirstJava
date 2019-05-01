package chap06_command;

public class CeilingFan {
    String room;

    public CeilingFan(String room) {this.room = room;}

    public void on() {
        System.out.println("Ceiling Fan in \'" + room + "\' is On");
    }

    public void off() {
        System.out.println("Ceiling Fan in \'" + room + "\' is Off");
    }
}

package chap06_command;

public class GarageDoor {
    String room;

    public GarageDoor(String room) {this.room = room;}
    public void up() {System.out.println("Garage Door is Open");}
    public void down() {System.out.println("Garage Door is Close");}
    public void stop() {System.out.println("Garage Door is Stopped");}
    public void lightOn() {System.out.println("Garage Light is On");}
    public void lightOff() {System.out.println("Garage Light is Off");}
}

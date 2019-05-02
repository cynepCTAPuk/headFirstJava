package chap06_command.lambda;


import chap06_command.GarageDoor;
import chap06_command.Light;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        Light light = new Light("Garage");
        GarageDoor garageDoor = new GarageDoor("");

        remote.setCommand(light::on);
        remote.buttonWasPressed();
        remote.setCommand(garageDoor::up);
        remote.buttonWasPressed();
        remote.setCommand(garageDoor::down);
        remote.buttonWasPressed();
        remote.setCommand(light::off);
        remote.buttonWasPressed();
    }
}

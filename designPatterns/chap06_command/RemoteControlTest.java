package chap06_command;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        Light light = new Light("Garage");
        GarageDoor garageDoor = new GarageDoor("");

        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);
        GarageDoorUpCommand garageOpen = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageClose = new GarageDoorDownCommand(garageDoor);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();

        remote.setCommand(garageClose);
        remote.buttonWasPressed();

        remote.setCommand(lightOff);
        remote.buttonWasPressed();
    }
}

package chap06_command;

public class RemoteLoaderLambda {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        Light livingRoomLight = new Light("Living Room");

        remoteControl.setCommand(0,
                new LightOnCommand(livingRoomLight),
                new LightOffCommand(livingRoomLight));

//        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
    }
}

package chap06_command;

public class RemoteLoaderLambdaLight {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        Light livingRoomLight = new Light("Living Room");
        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, lightOn, lightOff);
        remoteControl.setCommand(1,
                new LightOnCommand(livingRoomLight),
                new LightOffCommand(livingRoomLight));
        remoteControl.setCommand(2, () -> livingRoomLight.on(), () -> livingRoomLight.off());
        remoteControl.setCommand(3, livingRoomLight::on, livingRoomLight::off);

//        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }
}

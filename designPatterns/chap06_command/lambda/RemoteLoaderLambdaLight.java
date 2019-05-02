package chap06_command.lambda;

import chap06_command.Light;

public class RemoteLoaderLambdaLight {
    public static void main(String[] args) {
        RemoteControlLambda remoteControl = new RemoteControlLambda();

        Light livingRoomLight = new Light("Living Room");

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

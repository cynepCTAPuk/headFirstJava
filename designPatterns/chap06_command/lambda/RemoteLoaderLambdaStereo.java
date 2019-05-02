package chap06_command.lambda;


import chap06_command.Stereo;

public class RemoteLoaderLambdaStereo {
    public static void main(String[] args) {
        RemoteControlLambda remoteControl = new RemoteControlLambda();

        Stereo stereo = new Stereo("Living Room");

        remoteControl.setCommand(0,
                () -> {
                    stereo.on();
                    stereo.setCD();
                    stereo.setVolume(11);
                },
                stereo::off);

//        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
    }
}

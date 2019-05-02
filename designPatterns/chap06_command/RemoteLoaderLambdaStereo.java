package chap06_command;

public class RemoteLoaderLambdaStereo {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

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

package chap06_command;

public class RemoteLoaderParty {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        Light light = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub();

        LightOnCommand lightOn = new LightOnCommand(light);
        StereoOnCommand stereoOn = new StereoOnCommand(stereo);
        TVonCommand tvOn = new TVonCommand(tv);
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(light);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        TVoffCommand tvOff = new TVoffCommand(tv);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);


        Command[] commandsOn = new Command[]{lightOn,stereoOn,tvOn,hottubOn};
        Command[] commandsOff = new Command[]{lightOff,stereoOff,tvOff,hottubOff};

        MacroCommand macroCommand1 = new MacroCommand(commandsOn);
        MacroCommand macroCommand2 = new MacroCommand(commandsOn);

        remoteControl.setCommand(0, macroCommand1, macroCommand2);

        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);
    }
}

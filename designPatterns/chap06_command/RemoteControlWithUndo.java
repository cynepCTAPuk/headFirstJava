package chap06_command;

public class RemoteControlWithUndo {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
//        System.out.println("------ Slot \'" + slot + "\' button on was pushed");
        onCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
//        System.out.println("------ Slot \'" + slot + "\' button off was pushed");
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
//        System.out.println("------ Button undo was pushed");
//        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append(
                    "" + "[slot " + i + "] "
                            + onCommands[i].getClass().getName() + "   "
                            + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("(undo) \t" + undoCommand.getClass().getName() + "\n");
        return stringBuff.toString();
    }
}

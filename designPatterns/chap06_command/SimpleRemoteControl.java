package chap06_command;

public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonExecute() {
        slot.execute();
    }

    public void buttonUndo() {
        slot.undo();
    }
}

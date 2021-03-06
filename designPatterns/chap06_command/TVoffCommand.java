package chap06_command;

public class TVoffCommand implements Command {
    TV tv;

    public TVoffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    public void undo() {
        tv.on();
    }
}

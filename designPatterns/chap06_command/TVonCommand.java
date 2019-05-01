package chap06_command;

public class TVonCommand implements Command {
    TV tv;

    public TVonCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}

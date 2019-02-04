package chap11_holding;

public class Command {
    String command;
    public Command(String command) { this.command = command; }
    void operation() { System.out.println(command); }
}

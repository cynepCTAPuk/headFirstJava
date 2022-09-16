package cashMachine.task2613.command;

import cashMachine.task2613.CashMachine;
import cashMachine.task2613.ConsoleHelper;
import cashMachine.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res;

    public ExitCommand() {
        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit");
    }

    @Override
    public void execute() throws InterruptOperationException {
//        ConsoleHelper.writeMessage("Завершить работу? y/n");
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String input = ConsoleHelper.readString().toLowerCase();
//        if (input.equals("y")) ConsoleHelper.writeMessage("До свидания!");
        if (input.equals("y")) ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
}

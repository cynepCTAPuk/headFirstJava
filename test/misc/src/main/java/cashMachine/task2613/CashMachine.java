package cashMachine.task2613;

import cashMachine.task2613.command.CommandExecutor;
import cashMachine.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class CashMachine {
    public static final String RESOURCE_PATH =
            CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }
}

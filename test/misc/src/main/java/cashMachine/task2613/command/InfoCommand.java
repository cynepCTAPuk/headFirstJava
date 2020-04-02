package cashMachine.task2613.command;

import cashMachine.task2613.CashMachine;
import cashMachine.task2613.ConsoleHelper;
import cashMachine.task2613.CurrencyManipulator;
import cashMachine.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res;

    public InfoCommand() {
        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info"        );
    }

    @Override
    public void execute() {
        Collection<CurrencyManipulator> manipulators =
                CurrencyManipulatorFactory.getAllCurrencyManipulators();

//        if (manipulators.isEmpty()) ConsoleHelper.writeMessage("No money available.");
        if (manipulators.isEmpty()) ConsoleHelper.writeMessage(res.getString("no.money"));
        else {
            int count = 0;
            ConsoleHelper.writeMessage(res.getString("before"));
            for (CurrencyManipulator c : manipulators) {
                if (c.hasMoney()) {
                    ConsoleHelper.writeMessage(c.getCurrencyCode() + " - " + c.getTotalAmount());
                    count++;
                }
            }
//            if (count == 0) ConsoleHelper.writeMessage("No money available.");
            if (count == 0) ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}

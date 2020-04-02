package cashMachine.task2613.command;

import cashMachine.task2613.CashMachine;
import cashMachine.task2613.ConsoleHelper;
import cashMachine.task2613.CurrencyManipulator;
import cashMachine.task2613.CurrencyManipulatorFactory;
import cashMachine.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res;

    public DepositCommand() {
        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit");
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        String[] input = ConsoleHelper.getValidTwoDigits(code);
        int banknote = Integer.parseInt(input[0]);
        int amount = Integer.parseInt(input[1]);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        manipulator.addAmount(banknote, amount);
        ConsoleHelper.writeMessage(
                String.format(res.getString("success.format"), banknote * amount, code));
    }
}

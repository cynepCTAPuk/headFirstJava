package cashMachine.task2613.command;

import cashMachine.task2613.CashMachine;
import cashMachine.task2613.ConsoleHelper;
import cashMachine.task2613.CurrencyManipulator;
import cashMachine.task2613.CurrencyManipulatorFactory;
import cashMachine.task2613.exception.InterruptOperationException;
import cashMachine.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res;

    public WithdrawCommand() {
        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true) {
            try {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                int amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0) throw new NumberFormatException();
                if (manipulator.isAmountAvailable(amount)) {
                    Map<Integer, Integer> map = manipulator.withdrawAmount(amount);
                    for (Integer b : map.keySet()) ConsoleHelper.writeMessage(b + " - " + map.get(b));
                    ConsoleHelper.writeMessage(
                            String.format(res.getString("success.format"), amount, currencyCode));
                    break;
                } else
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }

    }
}

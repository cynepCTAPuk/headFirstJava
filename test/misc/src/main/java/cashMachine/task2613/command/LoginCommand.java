package cashMachine.task2613.command;

import cashMachine.task2613.CashMachine;
import cashMachine.task2613.ConsoleHelper;
import cashMachine.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {
    private ResourceBundle validCreditCards;
    private ResourceBundle res;
//    private String card = "123456789012";
//    private String pin = "1234";

    public LoginCommand() {
        validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login");
    }

    @Override
    public void execute() throws InterruptOperationException {
        String creditCard;
        String pinCode;
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
//            ConsoleHelper.writeMessage("Введите номер кредитной карты: ");
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            creditCard = ConsoleHelper.readString();
            pinCode = ConsoleHelper.readString();
            if (creditCard.length() == 12 && pinCode.length() == 4) {
                if (validCreditCards.containsKey(creditCard) &&
                        validCreditCards.getString(creditCard).equals(pinCode)) break;
                else {
                    ConsoleHelper.writeMessage(
                            String.format(res.getString("not.verified.format"), creditCard));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
//                if (creditCard.equals(card)) break;
//                } else ConsoleHelper.writeMessage("Данная карта не авторизована! Повторите ввод!");

            } else
//                ConsoleHelper.writeMessage("Номер карты должна содержать 12 цифр. Повторите ввод!");
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
        }

//        ConsoleHelper.writeMessage("Авторизация прошла успешно! Добро пожаловать!");
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCard));

    }
}

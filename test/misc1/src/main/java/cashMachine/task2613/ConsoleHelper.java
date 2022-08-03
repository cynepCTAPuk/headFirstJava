package cashMachine.task2613;

import cashMachine.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String input = null;
        try {
            input = bis.readLine().toLowerCase();
            if (input.equals("exit")) throw new InterruptOperationException();
        } catch (IOException ignored) {
        }
        return input;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String currencyCode = readString();
            if (currencyCode != null && currencyCode.length() == 3)
                return currencyCode.toUpperCase();
            else writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage(String.format(
                    res.getString("choose.denomination.and.count.format"), currencyCode));
            String[] data = readString().split(" ");
            try {
                if (data.length == 2) {
                    int nominal = Integer.parseInt(data[0]);
                    int qty = Integer.parseInt(data[1]);
                    if (nominal > 0 && qty > 0) return data;
                    writeMessage(res.getString("invalid.data"));
                } else writeMessage(res.getString("invalid.data"));
            } catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - " + res.getString("operation.INFO"));
            writeMessage("2 - " + res.getString("operation.DEPOSIT"));
            writeMessage("3 - " + res.getString("operation.WITHDRAW"));
            writeMessage("4 - " + res.getString("operation.EXIT"));
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (IllegalArgumentException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }
}

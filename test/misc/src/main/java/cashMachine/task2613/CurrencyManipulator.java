package cashMachine.task2613;

import cashMachine.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode; // код валюты, например, USD. Состоит из трех символов
    private Map<Integer, Integer> denominations = new TreeMap<>(Comparator.reverseOrder()); // Map<номинал, количество>.

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denomination > 0 && count > 0) denominations.merge(denomination, count, Integer::sum);
    }

    public boolean hasMoney() {
        return getTotalAmount() > 0;
    }

    public int getTotalAmount() {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
            result += entry.getKey() * entry.getValue();
        return result;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder());
        Integer[] nominees = denominations.keySet().toArray(new Integer[0]);
        Integer[] qty = denominations.values().toArray(new Integer[0]);

        int remain = expectedAmount;
        for (int index = 0; index < denominations.size(); index++) {
            if (expectedAmount <= 0) break; // исключительно для целей тестирования
            int quantity = qty[index]; // кол-во банкнот данного номинала
            if (quantity < 1) continue; // если банкнот этого номинала нет, то переходим к новой банкноте
            int banknote = nominees[index]; // номинал банкноты

            int amount = remain / banknote;
            if (amount > quantity) amount = quantity;

            if (amount != 0) {
                remain -= amount * banknote;
                result.put(banknote, amount);
                denominations.put(banknote, denominations.get(banknote) - amount);
            }

            if (remain == 0) break;
        }
        if (remain != 0) {
            result.clear();
            throw new NotEnoughMoneyException();
        }

        return result;
    }
}
package com.example.atmEnum;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Denomination, Integer> dispensers = new HashMap<>();

    public void deposit(int notes, Denomination denomination) {
        int value = dispensers.getOrDefault(denomination, 0) + notes;
        dispensers.put(denomination, value);
        System.out.printf("+Deposit  = %,6d (%,3d * %,5d)\n",
                notes * denomination.getValue(), notes,denomination.getValue());
        System.out.printf("Balance   = %,6d\n", getBalance());
    }

    public int getBalance() {
        int sum = dispensers.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getValue() * entry.getValue())
                .sum();
        return sum;
    }

    public Map<Denomination, Integer> withdraw(final int amount) {
        Map<Denomination, Integer> withdrawal = new HashMap<>();
        int remain = amount;
        for (Denomination denomination : Denomination.values()) {
            int notes = dispensers.get(denomination);
            int notesNeeded = remain / denomination.getValue();
            int notesDispensed = notes > notesNeeded
                    ? notesNeeded
                    : notes;
            withdrawal.put(denomination, notesDispensed);
            remain -= denomination.getValue() * notesDispensed;
        }
        if (remain > 0)
            throw new RuntimeException(
                    String.format("Can not dispense amount %d by dispenser", amount));
        withdrawal.forEach((denomination, notesDispensed) ->
                dispensers.compute(denomination, (key, notes) -> notes - notesDispensed));
        System.out.printf("-Dispense = %,6d\n", amount);
        System.out.printf("Balance   = %,6d\n", getBalance());
        return withdrawal;
    }
}

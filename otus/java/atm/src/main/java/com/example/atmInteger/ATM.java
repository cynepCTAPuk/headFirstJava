package com.example.atmInteger;

import java.util.*;

public class ATM {
    int balance;
    SortedMap<Integer, Integer> dispensers = new TreeMap<>(Collections.reverseOrder());

    public void deposit(int notes, int denomination) {
        int oldValue = dispensers.getOrDefault(denomination, 0);
        dispensers.put(denomination, oldValue + notes);
    }

    public int getBalance() {
        return dispensers.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();
    }

    public Map<Integer, Integer> withdraw(int amount) {
        Map<Integer, Integer> withdrawal = new HashMap<>();
        int remaining = amount;
        for (Integer denomination : dispensers.keySet()) {
            int notesThereIs = dispensers.get(denomination);
            int notesWantToDispense = remaining / denomination;
            int notesToDispense = notesWantToDispense > notesThereIs
                    ? notesThereIs
                    : notesWantToDispense;
            withdrawal.put(denomination, notesToDispense);
            remaining -= denomination * notesToDispense;
        }
        if (remaining > 0) {
            throw new RuntimeException(
                    String.format("Can't dispense %,d with dispensers %s", amount, dispensers));
        }
        withdrawal.forEach((denomination, notesDispensed) ->
                dispensers.compute(denomination, (key, value) -> value - notesDispensed));
        return withdrawal;
    }
}

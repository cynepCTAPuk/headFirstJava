package com.example.atm;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int notes, int denomination) {
        balance += notes * denomination;
    }

    public Map<Denomination, Integer> withdraw(int i) {
        return null;
    }

    public void wihdraw(int sum) {
        balance -= sum;
    }
}

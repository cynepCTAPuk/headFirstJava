package com.example.atmInteger;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/* ATM должен
• принимать банкноты разных номиналов (на каждый номинал должна быть своя ячейка)
• выдавать запрошенную сумму минимальным количеством банкнот или ошибку если сумму нельзя выдать
• выдавать сумму остатка денежных средств
 */
public class ATMtest {
    private ATM atm;

    @Before
    public void setUp() throws Exception {
        atm = new ATM();
    }

    @Test
    public void shouldDepositNotesOfDifferentDenomination() {
        atm.deposit(10, 100);
        atm.deposit(5, 500);
        int balance = atm.getBalance();
        assertEquals(3_500, balance);
    }

    @Test
    public void shouldWithdrawByMinimumOfNotes() {
        atm.deposit(10, 100);
        atm.deposit(10, 500);
        atm.deposit(10, 1_000);
        int balanceBefore = atm.getBalance();
        Map<Integer, Integer> withdrawal = atm.withdraw(700);
        assertEquals(balanceBefore - 700, atm.getBalance());
        assertEquals(2, withdrawal.get(100).intValue());
        assertEquals(1, withdrawal.get(500).intValue());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenAmountCanNotBeWithdraw() {
        atm.deposit(10, 500);
        atm.deposit(2, 200);
        atm.withdraw(800);

    }

    @Test
    public void shouldNotDispenseWhenCantDispense() {
        atm.deposit(10, 500);
        atm.deposit(10, 1_000);
        atm.deposit(10, 5_000);
        assertEquals(65_000, atm.getBalance());
        try {
            atm.withdraw(1_700);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(65_000, atm.getBalance());
    }

    @Test
    public void shouldNotDispenseMoreThanThereIsNotes() {
        atm.deposit(1, 1_000);
        atm.deposit(10, 500);
        int balanceBefore = atm.getBalance();
        Map<Integer, Integer> withdrawal = atm.withdraw(2_500);
        assertEquals(balanceBefore - 2_500, atm.getBalance());
        assertEquals(3,withdrawal.get(500).intValue());
        assertEquals(1,withdrawal.get(1_000).intValue());
    }
}

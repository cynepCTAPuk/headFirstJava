package com.example.atmEnum;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.example.atmEnum.Denomination.*;
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
        atm.deposit(2, ONE_HUNDRED);
        atm.deposit(3, FIVE_HUNDREDS);
        int balance = atm.getBalance();
        assertEquals(1_700, balance);
    }

    @Test
    public void shouldWithdrawByMinimumOfNotes() {
        atm.deposit(10, ONE_HUNDRED);
        atm.deposit(10, FIVE_HUNDREDS);
        atm.deposit(10, ONE_THOUSAND);
        atm.deposit(10, FIVE_THOUSANDS);
        int balanceBefore = atm.getBalance();
        Map<Denomination, Integer> withdrawal = atm.withdraw(1_700);
        assertEquals(1, withdrawal.get(ONE_THOUSAND).intValue());
        assertEquals(1, withdrawal.get(FIVE_HUNDREDS).intValue());
        assertEquals(2, withdrawal.get(ONE_HUNDRED).intValue());
        int balanceAfter = atm.getBalance();
        assertEquals(balanceBefore - 1_700, balanceAfter);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenAmountCanNotBeWithdraw() {
        atm.deposit(10, ONE_THOUSAND);
        atm.withdraw(1_700);
    }

    @Test
    public void shouldNotDispenseWhenCantDispense() {
        atm.deposit(10, ONE_HUNDRED);
        assertEquals(1_000, atm.getBalance());
        try {
        atm.withdraw(1_00);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(1_000, atm.getBalance());
    }
}

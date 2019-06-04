package com.example.atmEnum;

public enum Denomination {
    FIVE_THOUSANDS(5_000),
    ONE_THOUSAND(1_000),
    FIVE_HUNDREDS(500),
    ONE_HUNDRED(100);

    private int denomination;

    Denomination(int denomination) {
        this.denomination = denomination;
    }

    public int getValue() {
        return denomination;
    }
}

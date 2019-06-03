package com.example.atm;

public class OldDenomination {
    public static final int ONE_HUNDRED = 100;
    public static final int FIVE_HUNDREDS = 500;
    public static final int ONE_THOUSAND = 1_000;
    public static final int FIVE_THOUSANDS = 5_000;

    public static OldDenomination[] values() {
        return new OldDenomination[0];
    }

    public int getValue() {
        return 0;
    }

    public int get(OldDenomination denomination) {
        return 0;
    }
}

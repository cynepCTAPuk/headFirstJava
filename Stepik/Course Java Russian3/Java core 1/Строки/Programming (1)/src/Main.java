interface BigNumber extends Comparable {
    BigNumber add(BigNumber bigNumber);

    BigNumber sub(BigNumber bigNumber);
}

class MyBigNumber implements BigNumber {

    private final String number;

    public MyBigNumber(String number) {
        this.number = number;
    }

    @Override
    public BigNumber add(BigNumber bigNumber) {
        // enter your code
        return null;
    }

    @Override
    public BigNumber sub(BigNumber bigNumber) {
        // enter your code
        return null;
    }

    @Override
    public int compareTo(Object o) {
        // enter your code
        return 0;
    }

    @Override
    public String toString() {
        return number;
    }
}
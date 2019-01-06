package chap05;

public class CurrenciesDescription {
    Currencies money;

    public CurrenciesDescription(Currencies money) {
        this.money = money;
    }

    private void describe() {
        switch (money) {
            case EURO:
                System.out.println("Europe");
                break;
            case RUBLE:
                System.out.println("Russia");
                break;
            case DOLLAR:
                System.out.println("USA");
                break;
            default:
        }
    }

    public static void main(String[] args) {
        CurrenciesDescription
                france = new CurrenciesDescription(Currencies.EURO),
                russia = new CurrenciesDescription(Currencies.RUBLE),
                usa = new CurrenciesDescription(Currencies.DOLLAR);
        france.describe();
        russia.describe();
        usa.describe();
    }

}

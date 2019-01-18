package chap05_initialization;

public class CurrenciesTest {
    public static void main(String[] args) {
        for (Currencies c : Currencies.values()) {
            System.out.println(c.ordinal() + " " + c);
        }
    }
}

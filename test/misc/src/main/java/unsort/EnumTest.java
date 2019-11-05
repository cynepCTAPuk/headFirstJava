package unsort;

public class EnumTest {
    enum Country {
        CANADA("CAD") {
            @Override
            String sayHello() {
                return "Hello";
            }},
        POLAND("PLN") {
            @Override
            String sayHello() {
                return "Dzien dobry";
            }},
        GERMANY("EUR") {
            @Override
            String sayHello() {
                return "Hallo";
            }},
        LAOPAPAS {
            @Override
            String sayHello() {
                return "Lapapioooo";
            }},
        ZIMKABU() {
            @Override
            String sayHello() {
                return "Shakalaka";
            }};

        String currency;
        Country() {
        }
        Country(String currency) {
            this.currency = currency;
        }
        boolean hasCurrency() {
            return currency != null;
        }
        abstract String sayHello();
    }

    public static void main(String[] args) {
/*
        System.out.printf("|   %-10s|%8s|  %-12s\n", "Country", "Currency", "Greetings");
        System.out.printf("|---%-10s|%8s|%14s\n", "-".repeat(10), "-".repeat(8), "-".repeat(14));
        for (Country country : Country.values()) {
            if (country.hasCurrency()) {
                System.out.printf("|%2d %-10s:  %-6s:  %-12s\n",
                        country.ordinal() + 1, country, country.currency, country.sayHello());
            } else {
                System.out.printf("|%2d %-10s:  %-6s:  %-12s\n",
                        country.ordinal() + 1, country, "N/D", country.sayHello());
            }
        }
*/
        for (Country country : Country.values()) {
            System.out.println(country.describeConstable());
        }
    }
}

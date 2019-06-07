public class EnumTest {
    enum Country {
        CANADA("CAD") {
            @Override
            String sayHello() {
                return "Hello";
            }
        },
        POLAND("PLN") {
            @Override
            String sayHello() {
                return "Dzien dobry";
            }
        },
        GERMANY("EUR") {
            @Override
            String sayHello() {
                return "Hallo";
            }
        },
        LAOPAPAS {
            @Override
            String sayHello() {
                return "Lapapioooo";
            }
        },
        ZIMKABU() {
            @Override
            String sayHello() {
                return "Shakalaka";
            }
        };

        String currency;

        Country(String currency) {
            this.currency = currency;
        }

        Country() {
        }

        boolean hasCurrency() {
            return currency != null;
        }

        abstract String sayHello();
    }

    public static void main(String[] args) {
        System.out.printf("%-10s|%8s|%8s\n", "Country", "Currency", "Greetings");
        for (Country country : Country.values()) {
            if (country.hasCurrency()) {
                System.out.printf("%-10s:  %-6s:  %-8s\n", country, country.currency, country.sayHello());
            } else {
                System.out.printf("%-10s:  %-6s:  %-8s\n", country, "-", country.sayHello());
            }
        }
    }
}

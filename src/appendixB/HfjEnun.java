package appendixB;

public class HfjEnun {
    enum Names {
        JERRY("lead guitar") {
            public String sings() {
                return "plaintively";
            }
        },
        BOBBY("rhythm guitar") {
            public String sings() {
                return "hoarsely";
            }
        },
        PHIL("bass guitar");

        private String instrument;

        Names(String instrument) {
            this.instrument = instrument;
        }

        public String getInstrument() {
            return this.instrument;
        }

        public String sings() {
            return "occasionally";
        }
    }

    public static void main(String[] args) {
        for (Names n : Names.values()) {
            System.out.print(n);
            System.out.print(",\t instrument: " + n.getInstrument());
            System.out.println(",\t sings: " + n.sings());
        }
        Names n = Names.BOBBY;
        if (n.equals(Names.JERRY)) System.out.println("Джерррри!");
        if (n == Names.BOBBY) System.out.println("Rat Dog");

        Names ifName = Names.PHIL;
        switch (ifName) {
            case JERRY:
                System.out.print("пусть споёт");
            case PHIL:
                System.out.print("углубляйся, ");
            case BOBBY:
                System.out.println("Кессиди");
        }
    }
}


package unsort;

/*
https://javarush.ru//groups//posts//1340-peregruzka-metodov-equals-i-hashcode-v-java
 */
public class EqualsTest {
    private int i;
    private String a;
    private String b;

    public int getI() {
        return i;
    }
    public String getA() {
        return a;
    }
    public String getB() {
        return b;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        EqualsTest test = (EqualsTest) obj;
        return i == test.i
                && (a == test.a || (a != null && a.equals(test.getA())))
                && (b == test.b || (b != null && b.equals(test.getB())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new EqualsTest().hashCode());
    }
}
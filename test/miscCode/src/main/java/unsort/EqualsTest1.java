package unsort;

/*
equals & hashCode was generated by IntelleJ IDEA
 */
public class EqualsTest1 {
    private Integer i;
    private String a;
    private String b;

    public EqualsTest1(Integer i, String a, String b) {
        this.i = i;
        this.a = a;
        this.b = b;
    }

    public Integer getI() {
        return i;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualsTest1 that = (EqualsTest1) o;

        if (i != null ? !i.equals(that.i) : that.i != null) return false;
        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        return b != null ? b.equals(that.b) : that.b == null;
    }

    @Override
    public int hashCode() {
        int result = i != null ? i.hashCode() : 0;
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new EqualsTest1(10, "interfaces", "b").hashCode());
    }
}
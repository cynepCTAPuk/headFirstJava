package y21;

public class Q211006_3 {
    public static void main(String[] args) {
        C c = new C();
        c.setI(4);
        if (c instanceof Cloneable) {
            C c2 = c.clone();
            System.out.println(c.getI() == c2.getI());
        }
    }
}

class C implements Cloneable {
    private int i;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    @Override
    public C clone() {
        try {
            C clone = (C) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
package chap02;

public class SimpleObject {
    boolean aBoolean;
    char aChar;
    byte aByte;
    short aShort;
    int anInt;
    long aLong;
    float aFloat;
    double aDouble;
    SimpleObject simpleObject;

    @Override
    public String toString() {
        return "SimpleObject{" +
                "aBoolean=" + aBoolean +
                ", aChar=" + aChar +
                ", aByte=" + aByte +
                ", aShort=" + aShort +
                ", anInt=" + anInt +
                ", aLong=" + aLong +
                ", aFloat=" + aFloat +
                ", aDouble=" + aDouble +
                ", simpleObject=" + simpleObject +
                '}';
    }

    public static void main(String[] args) {
        SimpleObject simpleObject = new SimpleObject();
        System.out.println(simpleObject);
    }
}

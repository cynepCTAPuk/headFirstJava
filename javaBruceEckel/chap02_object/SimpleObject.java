package chap02_object;

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
                "\naBoolean=" + aBoolean +
                ",\naChar=" + aChar +
                ",\naByte=" + aByte +
                ",\naShort=" + aShort +
                ",\nanInt=" + anInt +
                ",\naLong=" + aLong +
                ",\naFloat=" + aFloat +
                ",\naDouble=" + aDouble +
                ",\nsimpleObject=" + simpleObject +
                '}';
    }

    public static void main(String[] args) {
        SimpleObject simpleObject = new SimpleObject();
        System.out.println(simpleObject);
    }
}

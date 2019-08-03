package chap09_Package_Interface;

public class MyIFimp2 implements MyIF {
    // Only getNumber() defined by MyIF needs to be implementd.
    // getString() can be allowed to default
    @Override
    public int getNumber() {
        return 100;
    }

    @Override
    public String getString() {
        return "This is a different string:";
    }
}

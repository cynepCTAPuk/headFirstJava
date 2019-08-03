package chap09_Package_Interface;

public class MyIFimp implements MyIF {
    // Only getNumber() defined by MyIF needs to be implementd.
    // getString() can be allowed to default
    @Override
    public int getNumber() {
        return 100;
    }
}

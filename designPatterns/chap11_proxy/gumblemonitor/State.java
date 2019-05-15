package chap11_proxy.gumblemonitor;

public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();

    void refill();
}

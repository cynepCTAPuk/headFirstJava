package chap10_state;

public class GumballMachine {
    State soldOutState;
    State soldState;
    State noQuarterState;
    State hasQuarterState;

    State state = soldOutState;
    int count = 0;

}

package chap10_state.ver2;

public class GumballMachine {
    State stateSoldOut;
    State stateSold;
    State stateNoQuarter;
    State stateHasQuarter;

    State state = stateSoldOut;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        stateSoldOut = new SoldOutState(this);
        stateSold = new SoldState(this);
        stateNoQuarter = new NoQuarterState(this);
        stateHasQuarter = new HasQuarterState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) state = stateNoQuarter;
        else state = stateSoldOut;
    }

    void setState(State state) {
        this.state = state;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) count = count - 1;
    }

    public State getStateSoldOut() {
        return stateSoldOut;
    }

    public State getStateSold() {
        return stateSold;
    }

    public State getStateNoQuarter() {
        return stateNoQuarter;
    }

    public State getStateHasQuarter() {
        return stateHasQuarter;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        String st;
        if (state != stateSoldOut) st = "waiting for quarter";
        else st = "sold out";
        return "\nMighty Gumball, Inc.\nJava-enabled Standing Gumball Model #2004\n" +
                "Inventory: " + count + " gumballs\n" +
                "Machine is " + st + "\n";
    }
}
package chap10_state.ver3;

public class GumballMachine {
    State stateSoldOut;
    State stateSold;
    State stateNoQuarter;
    State stateHasQuarter;
    State stateWinner;

    State state = stateSoldOut;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        stateSoldOut = new SoldOutState(this);
        stateSold = new SoldState(this);
        stateNoQuarter = new NoQuarterState(this);
        stateHasQuarter = new HasQuarterState(this);
        stateWinner = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) state = stateNoQuarter;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    public void turnCrank() {state.turnCrank();state.dispense();}

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) count--;
    }
    public void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; it's new count is: " + this.count);
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getState() {return state;}
    public int getCount() {return count;}

    public State getStateSoldOut() {return stateSoldOut;}
    public State getStateSold() {return stateSold;}
    public State getStateNoQuarter() {return stateNoQuarter;}
    public State getStateHasQuarter() {return stateHasQuarter;}
    public State getStateWinner() {return stateWinner;}

    @Override
    public String toString() {
        String end = "";
        if(count!=1) end = "s";
        return "\nMighty Gumball, Inc.\nJava-enabled Standing Gumball Model #2004\n" +
                "Inventory: " + count + " gumball" + end + "\n" +
                "Machine is " + state + "\n";
    }
}
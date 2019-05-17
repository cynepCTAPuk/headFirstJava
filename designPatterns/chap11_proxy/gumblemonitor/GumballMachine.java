package chap11_proxy.gumblemonitor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private State stateSoldOut;
    private State stateSold;
    private State stateNoQuarter;
    private State stateHasQuarter;
    private State stateWinner;

    private State state = stateSoldOut;
    private int count;
    private String location;
    private static final long serialVersionUID = 2L;

    public GumballMachine(String location, int numberGumballs) throws RemoteException {
        stateSoldOut = new SoldOutState(this);
        stateSold = new SoldState(this);
        stateNoQuarter = new NoQuarterState(this);
        stateHasQuarter = new HasQuarterState(this);
        stateWinner = new WinnerState(this);
        count = numberGumballs;
        if (numberGumballs > 0) state = stateNoQuarter;
        this.location = location;
    }

    public void insertQuarter() {state.insertQuarter();}
    public void ejectQuarter() {state.ejectQuarter();}
    public void turnCrank() {state.turnCrank();state.dispense();}

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) count--;
    }
    public void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; it's new count is: " + this.count);
        state.refill();
    }

    public int getCount() {return count;}
    public String getLocation() {return location;}
    public State getState() {return state;}

    public void setState(State state) {this.state = state;}

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
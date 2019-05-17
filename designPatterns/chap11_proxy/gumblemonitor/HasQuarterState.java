package chap11_proxy.gumblemonitor;

import java.util.Random;

public class HasQuarterState implements State {
    private static final long serialVersionUID = 2L;
    transient GumballMachine gumballMachine;

    Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {this.gumballMachine = gumballMachine;}
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }
    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getStateNoQuarter());
    }
    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getStateWinner());
        } else {
            gumballMachine.setState(gumballMachine.getStateSold());
        }
    }
    @Override
    public void dispense() {System.out.println("No gumball dispensed");}
    @Override
    public void refill() {}
    @Override
    public String toString() {return "waiting for turn of crank";}
}

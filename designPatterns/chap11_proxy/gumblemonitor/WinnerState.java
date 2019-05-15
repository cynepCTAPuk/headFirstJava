package chap11_proxy.gumblemonitor;

public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {this.gumballMachine = gumballMachine;}
    @Override
    public void insertQuarter() {System.out.println("winner stub for insertQuarter");}
    @Override
    public void ejectQuarter() {System.out.println("winner stub for ejectQuarter");}
    @Override
    public void turnCrank() {System.out.println("winner stub for turnCrank");}
    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getStateSoldOut());
        } else {
            gumballMachine.releaseBall();
            System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getStateNoQuarter());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getStateSoldOut());
            }
        }
    }
    @Override
    public void refill() {}
    @Override
    public String toString() {
        return "dispensing two gumballs for your quarter, because YOU'RE A WINNER!";
    }
}

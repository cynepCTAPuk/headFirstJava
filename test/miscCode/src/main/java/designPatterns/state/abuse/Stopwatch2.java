package designPatterns.state.abuse;

public class Stopwatch2 {
    private State currentState = new StoppedState(this);

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void click() {
        currentState.click();
    }
}

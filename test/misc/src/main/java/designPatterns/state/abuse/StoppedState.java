package designPatterns.state.abuse;

public class StoppedState implements State {
    private Stopwatch2 stopwatch;

    public StoppedState(Stopwatch2 stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        stopwatch.setCurrentState(new RunningState(stopwatch));
        System.out.println("Running");
    }
}

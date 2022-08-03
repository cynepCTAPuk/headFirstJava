package designPatterns.state.abuse;

public class RunningState implements State {
    private Stopwatch2 stopwatch;

    public RunningState(Stopwatch2 stopwatch) {
        this.stopwatch = stopwatch;
    }

    @Override
    public void click() {
        stopwatch.setCurrentState(new StoppedState(stopwatch));
        System.out.println("Stopped");
    }
}

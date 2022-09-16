package concurrency.javarush.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        State currentState, previousState = null;
        do {
            currentState = thread.getState();
            if (currentState != previousState) {
                System.out.println(currentState);
                previousState = currentState;
            }
        } while (currentState != State.TERMINATED);
    }
}

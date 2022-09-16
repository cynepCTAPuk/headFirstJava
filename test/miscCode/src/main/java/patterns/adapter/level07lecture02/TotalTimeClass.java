package patterns.adapter.level07lecture02;

class TotalTimeClass implements TotalTime {
    private int totalSeconds;

    public TotalTimeClass(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    @Override
    public int getTotalSeconds() {
        return totalSeconds;
    }
}

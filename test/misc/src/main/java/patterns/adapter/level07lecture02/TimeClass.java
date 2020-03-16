package patterns.adapter.level07lecture02;

class TimeClass implements Time {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeClass(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getSeconds() {
        return seconds;
    }
}

package patterns.adapter.level07lecture02;

/**
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture02
 */
class AdapterTime implements TotalTime {
    private Time time;

    public AdapterTime(Time time) {
        this.time = time;
    }

    public int getTotalSeconds() {
        return time.getHours() * 60 * 60 + time.getMinutes() * 60 + time.getSeconds();
    }

    public static void main(String[] args) {
        // программа получает объект, который реализует интерфейс Time
        Time time = new TimeClass(277,46,40);
        TotalTime totalTime = new AdapterTime(time);
        System.out.println(totalTime.getTotalSeconds());
    }
}


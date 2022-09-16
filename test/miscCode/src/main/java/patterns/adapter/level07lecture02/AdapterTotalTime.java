package patterns.adapter.level07lecture02;

/**
 * https://javarush.ru/quests/lectures/questcollections.level07.lecture02
 */
class AdapterTotalTime implements Time {
    private TotalTime totalTime;

    public AdapterTotalTime(TotalTime totalTime) {
        this.totalTime = totalTime;
    }

    public int getSeconds() {
        return totalTime.getTotalSeconds() % 60; //секунды
    }

    public int getMinutes() {
        return (totalTime.getTotalSeconds() / 60) % 60; //минуты
    }

    public int getHours() {
        return totalTime.getTotalSeconds() / (60 * 60); //часы
    }

    public static void main(String[] args) {
        // программа получает объект, который реализует интерфейс TotalTime
        TotalTime totalTime = new TotalTimeClass(1_000_000);
        Time time = new AdapterTotalTime(totalTime);
        System.out.println(time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds());
    }
}


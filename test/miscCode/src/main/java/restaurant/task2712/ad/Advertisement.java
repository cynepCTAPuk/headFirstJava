package restaurant.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;

    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getHits() {
        return hits;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
//        if (!(hits > 0)) throw new UnsupportedOperationException();
        if (!(hits > 0)) throw new NoVideoAvailableException();
        else hits--;
    }

    @Override
    public String toString() {
        return name + " is displayin... " + amountPerOneDisplaying
                + ", " + amountPerOneDisplaying * 1000 / duration;
    }
}

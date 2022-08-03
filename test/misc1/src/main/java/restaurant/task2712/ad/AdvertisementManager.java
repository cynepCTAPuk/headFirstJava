package restaurant.task2712.ad;

import restaurant.task2712.ConsoleHelper;
import restaurant.task2712.statistic.StatisticManager;
import restaurant.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> playList = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
//            if (ad.getAmountPerOneDisplaying() > 0) playList.add(ad);
            if (ad.getHits() > 0) playList.add(ad);
        }

        Set<List<Advertisement>> set = new HashSet<>();
        collect(set, playList); // Collection all of combinations objects of playlist to set

        List<Advertisement> currentList = new ArrayList<>();
        long maxCost = 0;
        int maxDuration = 0;
        int minSize = 0;
        for (List<Advertisement> advertisements : set) {
            long cost = 0;
            int duration = 0;
            int size = advertisements.size();

            for (Advertisement ad : advertisements) duration += ad.getDuration();
            if (duration > timeSeconds) continue;

            for (Advertisement ad : advertisements) cost += ad.getAmountPerOneDisplaying();

            if (cost > maxCost) {
                minSize = advertisements.size();
                maxCost = cost;
                currentList = advertisements;
            }
            if (cost == maxCost)
                if (duration > maxDuration) {
                    minSize = advertisements.size();
                    maxDuration = duration;
                    currentList = advertisements;
                }
            if ((cost == maxCost) && (duration == maxDuration))
                if (size < minSize) {
                    minSize = size;
                    currentList = advertisements;
                }
        }

        if (currentList.size() == 0) throw new NoVideoAvailableException();

        Collections.sort(currentList, (o1, o2) -> {
            int c = (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            if (c == 0) c = (int) (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration()
                    - o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
            return c;
        });
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(
                currentList, maxCost, maxDuration));
        for (Advertisement ad : currentList) {
            ConsoleHelper.writeMessage(ad.getName()
                    + " is displaying... " + ad.getAmountPerOneDisplaying()
                    + ", " + ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration());
            ad.revalidate();
        }
    }

    public static void collect(Set<List<Advertisement>> set, List<Advertisement> list) {
        if (list.size() == 0) return;
        set.add(list);
        for (Advertisement s : list) {
            List<Advertisement> copy = new ArrayList<>(list);
            copy.remove(s);
            collect(set, copy);
        }
    }

    public static void main(String[] args) {
        new AdvertisementManager(15 * 60).processVideos();
    }
}

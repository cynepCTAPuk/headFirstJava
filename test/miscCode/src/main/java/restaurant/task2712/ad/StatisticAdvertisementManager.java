package restaurant.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static final StatisticAdvertisementManager INSTANCE = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return INSTANCE;
    }

    public List<Advertisement> getActiveVideo() {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement ad : storage.list()) if (ad.getHits() > 0) list.add(ad);
        return list;
    }
    public List<Advertisement> getArchivedVideo() {
        List<Advertisement> list = new ArrayList<>();
        for (Advertisement ad : storage.list()) if (ad.getHits() < 1) list.add(ad);
        return list;
    }

}

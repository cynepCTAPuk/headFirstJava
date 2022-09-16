package restaurant.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static final AdvertisementStorage INSTANCE = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video",
                5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video",
                100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video",
                400, 2, 10 * 60)); //10 min
        videos.add(new Advertisement(someContent, "четвертое видео",
                50, 1, 2 * 60)); //1 min
    }

    public static AdvertisementStorage getInstance() {
        return INSTANCE;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public List<Advertisement> list() {
        return videos;
    }
}

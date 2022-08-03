package restaurant.task2712.statistic;

import restaurant.task2712.statistic.event.CookedOrderEventDataRow;
import restaurant.task2712.statistic.event.EventDataRow;
import restaurant.task2712.statistic.event.EventType;
import restaurant.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static final StatisticManager INSTANCE = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
//    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return INSTANCE;
    }

//    public Set<Cook> getCooks() {
//        return cooks;
//    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

//    public void register(Cook cook) {
//        cooks.add(cook);
//    }

    public Map<String, Long> getVideoEvents() {
        Map<String, Long> videos = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        for (EventDataRow event : statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) event;
            String date = simpleDateFormat.format(videoEvent.getDate());
            if (!videos.containsKey(date)) videos.put(date, videoEvent.getAmount());
            else videos.put(date, videos.get(date) + videoEvent.getAmount());
        }
        return videos;
    }

    public Map<String, Map<String, Integer>> getCookEvents() {
        Map<String, Map<String, Integer>> cooks = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        for (EventDataRow event : statisticStorage.getStorage().get(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow orderEvent = (CookedOrderEventDataRow) event;
            String date = simpleDateFormat.format(orderEvent.getDate());

            Map<String, Integer> cooksOfDay = new TreeMap<>();
            String cookName = orderEvent.getCookName();
            int cookingTime = orderEvent.getTime();

            if (!cooks.containsKey(date)) {
                cooksOfDay.put(cookName, cookingTime);
                cooks.put(date, cooksOfDay);
            } else {
                if (cooks.get(date).containsKey(cookName)) {
                    cooks.get(date).put(cookName, cooks.get(date).get(cookName) + cookingTime);
                } else cooks.get(date).put(cookName, cookingTime);
            }
        }
        return cooks;
    }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) storage.put(eventType, new ArrayList<>());
        }

        Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}

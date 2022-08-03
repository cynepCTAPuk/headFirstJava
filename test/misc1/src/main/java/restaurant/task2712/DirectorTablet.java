package restaurant.task2712;

import restaurant.task2712.ad.Advertisement;
import restaurant.task2712.ad.StatisticAdvertisementManager;
import restaurant.task2712.statistic.StatisticManager;

import java.util.List;
import java.util.Map;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("--- printAdvertisementProfit");
        Map<String, Long> videos = StatisticManager.getInstance().getVideoEvents();
        double total = 0.0;
        for (String date : videos.keySet()) {
            double amount = videos.get(date) / 100.0;
            String printAdvertisementProfit = String.format("%s - %,.2f", date, amount);
            ConsoleHelper.writeMessage(printAdvertisementProfit);
            total += amount;
        }
        String printTotal = String.format("%s - %,.2f", "Total", total);
        ConsoleHelper.writeMessage(printTotal);
    }

    public void printCookWorkloading() {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("--- printCookWorkloading");
        Map<String, Map<String, Integer>> cooks = StatisticManager.getInstance().getCookEvents();
        for (String date : cooks.keySet()) {
            ConsoleHelper.writeMessage(date);
            Map<String, Integer> map = cooks.get(date);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String printCookWorkloading = String.format("%s - %d min", entry.getKey(), entry.getValue() / 60);
                ConsoleHelper.writeMessage(printCookWorkloading);
            }
        }
    }

    public void printActiveVideoSet() {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("--- printActiveVideoSet");
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getActiveVideo();
        list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (Advertisement ad : list) ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
    }

    public void printArchivedVideoSet() {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("--- printArchivedVideoSet");
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getArchivedVideo();
        list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        for (Advertisement ad : list) ConsoleHelper.writeMessage(ad.getName());

    }
}

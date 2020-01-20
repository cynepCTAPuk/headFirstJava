package gc;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakReferenceTest1 {
    public static void main(String[] args) {
        //создаем объект для хранения дополнительной информации о пользователе
        WeakHashMap<User, StatisticInfo> userStatistics = new WeakHashMap<User, StatisticInfo>();
        //кладем информацию о пользователе в userStatistics
//        User user = session.getUser();
//        userStatistics.put(user, new StatisticInfo (…));
        //получаем информацию о пользователе из userStatistics
//        User user = session.getUser();
//        StatisticInfo statistics = userStatistics.get(user);
        //удаление любой информации о пользователе из userStatistics
//        User user = session.getUser();
//        userStatistics.remove(user);
    }

    static class User {
    }

    static class StatisticInfo {
    }

}

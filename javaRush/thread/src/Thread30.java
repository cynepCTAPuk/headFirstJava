/*
 https://javarush.ru/groups/posts/2060-threadom-java-ne-isportishjh--chastjh-iii---vzaimodeystvie
 Deadlock https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
 */
public class Thread30 {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        // с большой вероятностью проявится deadlock
        // jps - покажет id запущенной JVM
        // jstack id - покажет проблему в запущенной JVM
        // в данном случае достаточно убрать synchronized из метода bowBack
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}

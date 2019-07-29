import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    T def;
    int size;
    private Object monitor = new Object();

    public MyQueue(T def, int size) {
        this.def = def;
        this.size = size;
    }

    public void add(T e) {
        synchronized (monitor) {
            while (queue.size() >= size) {
                try {
                    monitor.wait();
                } catch (InterruptedException ex) {
                    throw new RuntimeException();
                }
            }
            queue.add(e);
            monitor.notifyAll();
        }
    }

    public T poll() {
        synchronized (monitor) {
            while (queue.size() < 1) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
            T value = queue.poll();
            monitor.notifyAll();
            return value == null ? def : value;
        }
    }
}

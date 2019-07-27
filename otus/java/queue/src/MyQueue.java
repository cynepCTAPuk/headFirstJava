import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    T def;

    public MyQueue(T def) {
        this.def = def;
    }

    public void add(T e) {
        queue.add(e);
    }

    public T poll() {
        T value = queue.poll();
        return value == null ? def : value;
    }
}

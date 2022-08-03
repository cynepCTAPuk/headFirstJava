package web.stepik.web1.observer;

import java.util.LinkedList;
import java.util.List;

public class EventSource {
    private List<EventListener> listeners = new LinkedList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void fireEvent() {
        for (EventListener listener : listeners) {
            listener.handle(new EventObject());
        }
    }
}

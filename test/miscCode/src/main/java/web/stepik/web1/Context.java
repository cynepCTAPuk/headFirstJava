package web.stepik.web1;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<Class<?>, Object> context = new HashMap<>();

    public void add(Class<?> clazz, Object object) {
        if (context.containsKey(clazz)) {
//            ERROR
        }
        context.put(clazz, object);
    }

    public Object get(Class<?> clazz) {
        return context.get(clazz);
    }
}

package com.example.nurse;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Register {
    Map<String, Object> register = new HashMap<String, Object>();

    public Object get(String name) {
        return register.get(name);
    }

    void add(String name, Object something) {
        if (register.containsKey(name)) throw new RuntimeException();
        for (Field field : something.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object injection = this.get(field.getType());
                field.setAccessible(true);
                try {
                    field.set(something, injection);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        register.put(name, something);
    }

    void add(Object something) {
        add(something.getClass().getName(), something);
    }

    public <T> T get(Class<T> type) {
        return (T) get(type.getName());
    }

    void inject() {
    }
}

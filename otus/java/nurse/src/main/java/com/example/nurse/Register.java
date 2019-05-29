package com.example.nurse;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Register {
    private Map<String, Object> register = new HashMap<String, Object>();
    private Map<Field, Object> fieldsToInject = new HashMap<>();

//    public Object get(String name) {
    public Optional<Object> get(String name) {
        Object something = register.get(name);
//        Objects.requireNonNull(something);
//        return something;
        return Optional.ofNullable(something);
    }

    void add(String name, Object something) {
        if (register.containsKey(name)) throw new RuntimeException();
        for (Field field : something.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                fieldsToInject.put(field, something);
            }
        }
        register.put(name, something);
    }

    void add(Object something) {
        add(something.getClass().getName(), something);
    }

    public <T> Optional<T> get(Class<T> type) {
        return (Optional<T>) get(type.getName());
    }

    void inject() {
        for (Field field : fieldsToInject.keySet()) {
            Object something = fieldsToInject.get(field);
            Object injection = this.get(field.getType()).get();
            field.setAccessible(true);
            try {
                field.set(something, injection);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

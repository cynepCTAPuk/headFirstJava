package gc.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V v = cache.get(key);
        if (v == null) {
            Constructor constructor = clazz.getDeclaredConstructor(key.getClass());
            constructor.setAccessible(true);
            cache.put(key, (V) constructor.newInstance(key));
            return cache.get(key);
        }
        return v;
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            K k = (K) getKey.invoke(obj);
            cache.put(k, obj);
            return true;
        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}

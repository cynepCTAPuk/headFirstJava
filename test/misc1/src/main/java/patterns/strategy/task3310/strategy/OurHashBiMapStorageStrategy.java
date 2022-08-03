package patterns.strategy.task3310.strategy;

import java.util.HashMap;

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    HashMap<Long, String> k2v = new HashMap<>();
    HashMap<String, Long> v2k = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
//        for (Long l : k2v.keySet()) if (l.equals(key)) return true;
        return k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
//        for (String s : v2k.keySet()) if (s.equals(value)) return true;
        return v2k.containsKey(value);
    }

    @Override
    public void put(Long key, String value) {
        k2v.put(key, value);
        v2k.put(value, key);
    }

    @Override
    public Long getKey(String value) {
        return v2k.get(value);
    }

    @Override
    public String getValue(Long key) {
        return k2v.get(key);
    }
}

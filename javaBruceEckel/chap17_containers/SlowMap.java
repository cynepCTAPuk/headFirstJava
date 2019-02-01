//: containers/SlowMap.java
// A Map implemented with ArrayLists.
package chap17_containers;
import util.*;
import java.util.*;
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if (keys.contains(key)) { values.set(keys.indexOf(key), value);
        } else { keys.add(key); values.add(value);}
        return oldValue;
    }
    public V get(Object key) { // key is type Object, not K
        if (keys.contains(key)) { return values.get(keys.indexOf(key));}
        return null;
    }
    public void clear() { keys.clear(); values.clear(); }
    public V remove(Object key) {
        if (keys.contains(key)) {
            V oldValue = get(key); int idx = keys.indexOf(key);
            keys.remove(idx); values.remove(idx);
            return oldValue;
        } else { return null;}
    }
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) set.add(new MapEntry<K, V>(ki.next(), vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.get("BENIN"));
        System.out.println(m.entrySet());
        m.remove("ANGOLA");
        System.out.println(m);
    }
} /* Output:
{CAMEROON=Yaounde, CHAD=N’djamena, CONGO=Brazzaville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, CENTRAL AFRICAN REPUBLIC=Bangui, BOTSWANA=Gaberone, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti}
Sofia
[CAMEROON=Yaounde, CHAD=N’djamena, CONGO=Brazzaville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, CENTRAL AFRICAN REPUBLIC=Bangui, BOTSWANA=Gaberone, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti]
*///:~
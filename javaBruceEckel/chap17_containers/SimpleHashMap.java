//: containers/SimpleHashMap.java
// A demonstration hashed Map.
package chap17_containers;
import util.*;

import java.util.*;
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    // Choose a prime number for the hash table size, to achieve a uniform distribution:
    static final int SIZE = 1024 - 3; // 997
    // You can’t have a physical array of generics, but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) buckets[index] = new LinkedList<MapEntry<K,V>>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        int probes = 0;
        while(it.hasNext()) {
            probes++;
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                System.out.print("Key collision!" +
                        " new pair: " + pair + " replaced old pair " + iPair + " ");
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if(probes > 0) System.out.println(
                "probes: " + probes + " pair: " + pair + " index: " + index);
        if(!found) buckets[index].add(pair);
        return oldValue;
    }
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key)) return iPair.getValue();
        return null;
    }
    public void clear() {
        for (List list : buckets) {
            if(list != null) list.clear();
        }
    }

    public V remove(Object key) {

    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket) set.add(mpair);
        }
        return set;
    }
    public static void main(String[] args) {
        SimpleHashMap<String,String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
//        m.put("ANGOLA", "Luand");
//        m.put("ANGOLA", "Luanda");
//        m.put("BENIN", "Porto-Novo");
//        System.out.println(m.get("ERITREA"));
//        System.out.println(m.entrySet());
//        System.out.println(m.buckets[544]);
        m.clear();
        System.out.println(m);

    }
} /* Output:
{CAMEROON=Yaounde, CONGO=Brazzaville, CHAD=N’djamena, COTE D’IVOIR
(IVORY COAST)=Yamoussoukro, CENTRAL AFRICAN REPUBLIC=Bangui,
GUINEA=Conakry, BOTSWANA=Gaberone, BISSAU=Bissau, EGYPT=Cairo,
ANGOLA=Luanda, BURKINA FASO=Ouagadougou, ERITREA=Asmara, THE
GAMBIA=Banjul, KENYA=Nairobi, GABON=Libreville, CAPE VERDE=Praia,
ALGERIA=Algiers, COMOROS=Moroni, EQUATORIAL GUINEA=Malabo, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, GHANA=Accra, DJIBOUTI=Dijibouti, ETHIOPIA=Addis Ababa}
Asmara
[CAMEROON=Yaounde, CONGO=Brazzaville, CHAD=N’djamena, COTE D’IVOIR (IVORY COAST)=Yamoussoukro, CENTRAL AFRICAN REPUBLIC=Bangui, GUINEA=Conakry, BOTSWANA=Gaberone, BISSAU=Bissau, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, ERITREA=Asmara, THE GAMBIA=Banjul, KENYA=Nairobi, GABON=Libreville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, EQUATORIAL GUINEA=Malabo, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, GHANA=Accra, DJIBOUTI=Dijibouti, ETHIOPIA=Addis Ababa]
*///:~
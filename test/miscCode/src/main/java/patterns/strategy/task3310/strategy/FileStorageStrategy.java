package patterns.strategy.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10_000L;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize = DEFAULT_BUCKET_SIZE_LIMIT;

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    int hash(Long k) {
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int) (k ^ (k >>> 7) ^ (k >>> 4));
    }

    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)].getEntry(); e != null; e = e.next)
            if (e.hash == hash && e.key.equals(key)) return e;
        return null;
    }

    void resize(int newCapacity) {
        FileBucket[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == Integer.MAX_VALUE) return;
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
        for (FileBucket fileBucket : oldTable) fileBucket.remove();
    }

    void transfer(FileBucket[] newTable) {
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (FileBucket fileBucket : src)
            for (Entry entry = fileBucket.getEntry(); entry != null; entry = entry.next) {
                int i = indexFor(entry.hash, newCapacity);
            }
    }


    void addEntry(int hash, Long key, String value, int bucketIndex) {
        FileBucket fileBucket = table[bucketIndex];
        Entry next = fileBucket.getEntry();
        Entry entry = new Entry(hash, key, value, next);
        fileBucket.putEntry(entry);
        if (fileBucket.getFileSize() >= bucketSizeLimit) resize(2 * table.length);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        if (table[bucketIndex] == null) table[bucketIndex] = new FileBucket();
        addEntry(hash, key, value, bucketIndex);
        size++;
    }


    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null) return false;
        for (FileBucket fileBucket : table) {
            if (fileBucket == null) continue;
            for (Entry entry = fileBucket.getEntry(); entry != null; entry = entry.next)
                if (entry.value.equals(value)) return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (key == null) return;
        int hash = hash((long) key.hashCode());
        int i = indexFor(hash, table.length);
        if (table[i] == null) table[i] = new FileBucket();

        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fileBucket : table)
            for (Entry entry = fileBucket.getEntry(); entry != null; entry = entry.next)
                if (value.equals(value)) return entry.getKey();
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).getValue();
    }
}

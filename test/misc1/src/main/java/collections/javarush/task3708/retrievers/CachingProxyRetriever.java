package collections.javarush.task3708.retrievers;

import collections.javarush.task3708.cache.LRUCache;
import collections.javarush.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    OriginalRetriever originalRetriever;
    LRUCache lruCache = new LRUCache(10);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        if (lruCache.find(id) != null) {
            return lruCache.find(id);
        } else {
            Object object = originalRetriever.retrieve(id);
            lruCache.set(id, object);
            return object;
        }
    }
}

package lru;

public class LruCacheTest {

    public static void main(String[] args) {
        Cache cache = new LruCache(5);

        cache.put(1);
        cache.put(2);
        cache.put(3);
        cache.put(4);
        cache.put(5);



    }
}

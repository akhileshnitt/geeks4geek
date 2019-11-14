package lru;

import java.util.LinkedList;

public class LruCache<Integer> implements Cache<Integer> {

    private int size ;

    private LinkedList list = null;

    public LruCache(int size) {
        this.size = size;
        list = new LinkedList();
    }

    @Override
    public Integer get() {
        return null;
    }

    @Override
    public void put(Integer integer) {

    }


}

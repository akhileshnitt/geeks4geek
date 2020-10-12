package test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MRUCacheImpl implements MRUCache {

    private static int capacity;

    private Map<Integer,CachedNode> map;

    private Deque<CachedNode> cachedValueList;

    public MRUCacheImpl(int capacity) {
        map= new HashMap<>();
        cachedValueList = new LinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public  void put(int key, int value) {

        synchronized (this) {

            if (map.size() < capacity) {
                if (map.containsKey(key)) {
                    updateCach(key, value);
                } else {
                    insertIntoCache(key, value);
                }
            } else {
                if (!map.containsKey(key)) {
                    CachedNode cahcedNode = cachedValueList.removeLast();
                    map.remove(cahcedNode.getKey());
                    insertIntoCache(key, value);
                } else {
                    updateCach(key, value);
                }

            }
        }
    }

    private void insertIntoCache(int key, int value) {
        CachedNode cahcedNode = new CachedNode(key,value);
        map.put(key, cahcedNode);
        cachedValueList.addLast(cahcedNode);
        capacity++;
    }

    private void updateCach(int key, int value) {
        CachedNode cahcedNode = map.get(key);
        cachedValueList.remove(cahcedNode);
        cahcedNode.setValue(value);
        cachedValueList.addLast(cahcedNode);
    }

    @Override
    public synchronized  int get(int key) {
        synchronized (this) {
            if (map.get(key) == null) {
                updateCach(key, map.get(key).getValue());
                return map.get(key).getKey();
            }
        }
        return  -1;
    }
}

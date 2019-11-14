package lru;

public interface Cache<T> {

     T get();
     void put(T t);
}

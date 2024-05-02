package personalExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCache<K,V> {

    private final Map<K,V> cache;

    public ThreadSafeCache(){
        cache=new ConcurrentHashMap<>();
    }
    public void put(K key, V value){
        cache.put(key,value);
    }
    public V get (K key){
       return cache.get(key);

    }

    public void remove(K key){
        cache.remove(key);
    }


}
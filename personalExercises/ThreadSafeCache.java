//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class ThreadSafeCache<T,V> {
//
//    private final Map<K,v> cache;
//
//    public ThreadSafeCache(){
//        cache=new ConcurrentHashMap<>()
//    }
//    public void put(K key, V value){
//        cache.put(key,value)
//    }
//    public V get (K key){
//        cache.get(key)
//    }
//
//    public void remove(K key){
//        cache.remove(key)
//    }
//
//}
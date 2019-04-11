package practices;
import java.util.Collection;
import java.util.Set;
public interface MyMap<K, V> {
    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(V value);

    void clear();

    V get(K key);

    V put(K key, V value);

    V remove(K key);

    void putAll(MyMap<? extends K, ? extends V> m);

    Set<K> keySet();

    Collection<V> values();

    Set<MyMap.Entry<K, V>> entrySet();
    static class Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        public Entry(){

        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public V setValue(V value){
            this.value = value;
            return value;
        }
        public String toString(){
            return "[ " + key + " => " + value + " ]";
        }
    }
}

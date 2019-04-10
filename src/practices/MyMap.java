package practices;

public interface MyMap<K, V> {
    void clear();
    V get(K key);
    class Entry<K, V>{
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
        public String toString(){
            return "[ " + key + " => " + value + " ]";
        }
    }
}

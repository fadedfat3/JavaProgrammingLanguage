package practices;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    private <T> void print(T t){
        System.out.println(t.toString());
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        print(map);
        assertEquals(0, map.size());
        map.put("123", 1);
        print(map);
        assertEquals(1, map.size());
        map.remove("123");
        print(map);
        assertEquals(0, map.size());
        map.put("my", 2);
        map.put("your", 3);
        map.put("his", 4);
        map.put("her", 5);
        print(map);
        assertEquals(4, map.size());

    }

    @Test
    public void isEmpty() {
        MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
        assertTrue(map.isEmpty());
        print(map);
        map.put(123, 4);
        assertFalse(map.isEmpty());
        print(map);
        map.remove(123);
        assertTrue(map.isEmpty());
        print(map);
    }

    @Test
    public void containsKey() {
    }

    @Test
    public void containsValue() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void get() {
    }

    @Test
    public void put() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void putAll() {
    }

    @Test
    public void keySet() {
    }

    @Test
    public void values() {
    }

    @Test
    public void entrySet() {
    }
}
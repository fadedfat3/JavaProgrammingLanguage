package practices;

import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;

public class Main  {

    public static void main(String[] args) {
	// write your code here


        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("abc", 23);
        map.put("123", 45);
        map.put("test", 56);
        map.put("test12", 67);
        System.out.println(map.entrySet());
    }




}

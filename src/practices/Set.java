package practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Set {
    HashSet<Integer> hashSet1 = new HashSet<>();
    HashSet<Integer> hashSet2 = new HashSet<>();
    HashMap<ArrayList<Integer>,Integer> hashMap= new HashMap<>();
    ArrayList<Integer> arrayList1 = new ArrayList<>();
    ArrayList<Integer> arrayList2 = new ArrayList<>();
    public void run(){
        arrayList1.add(12);
        arrayList2.add(34);
        arrayList1.add(56);
        System.out.println(arrayList1.hashCode());
        System.out.println(arrayList2.hashCode());
        System.out.println(hashSet1.hashCode());
        System.out.println(hashSet2.hashCode());
        hashMap.put(arrayList1, arrayList1.size());
        hashMap.put(arrayList2, arrayList2.size());
        hashMap.put(new ArrayList<Integer>(), 0);
        System.out.println(hashMap.containsKey(arrayList1));
        System.out.println(hashMap.containsKey(arrayList2));
        System.out.println(hashMap.containsKey(new ArrayList<Object>()));
        System.out.println(hashMap.keySet());
        System.out.println(hashMap);
    }
}

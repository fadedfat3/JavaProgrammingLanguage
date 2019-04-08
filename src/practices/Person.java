package practices;

import java.util.ArrayList;

public class Person {
    private ArrayList<String> s = new ArrayList<>();
    public boolean remove(String t){
        return s.remove(t);
    }
    public boolean add(String t){
        return s.add(t);
    }
}

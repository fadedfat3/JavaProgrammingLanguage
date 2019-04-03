package practices;

import java.util.Arrays;

public class Test {
    private int a = 0;
    private String[] str = {"abc", "efg", "bsfe", "vnfjef"};
    public void add(){
        ++a;
    }
    public int get(){
        return a;
    }

    public void sort(){
        Arrays.sort(str);

    }
    public String toString(){
        return Arrays.toString(str);
    }

}

package practices;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Sort {
    public static <E extends Comparable<E>> void insertSort(List<E> list){

        Iterator<E> iterator = list.iterator();
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < i; j++){
                if(list.get(j).compareTo(list.get(i)) > 0){
                    E tmp = list.get(j);


                }
            }
        }
    }

    public static <E> void insertSort(Collection<E> list, Comparator<E> comparator){

    }
}

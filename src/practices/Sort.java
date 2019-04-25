package practices;

import java.util.*;

public class Sort {
    public static <E extends Comparable<E>> void insertSort(List<E> list){

        for(int i = 0; i < list.size(); i++){
            E insertedElement = list.get(i);
            for(int j = 0; j < i; j++){
                E element = list.get(j);
                if(element.compareTo(insertedElement) > 0){
                    while(j < i){
                        list.set(i, list.get(i-1));
                        i--;
                    }
                    list.set(j, insertedElement);
                    break;
                }
            }
        }
    }

    public static <E> void insertSort(List<E> list, Comparator<E> comparator){
        for(int i = 0; i < list.size(); i++){
            E insertElement = list.get(i);
            for(int j = 0 ; j < i; j++){
                E element = list.get(j);
                if(comparator.compare(element, insertElement) > 0){
                    while(j < i){
                        list.set(i, list.get(i-1));
                        i--;
                    }
                    list.set(j, insertElement);
                    break;
                }
            }
        }
    }
    private static <E extends Comparable<E>> void merge(List<E> list, List<E> frontHalf, List<E> backHalf){
        int frontIndex = 0, backIndex = 0, listIndex = 0;
        for(; frontIndex < frontHalf.size() && backIndex < backHalf.size();){
            E frontElement = frontHalf.get(frontIndex);
            E backElement = backHalf.get(backIndex);
            if(frontElement.compareTo(backElement) <= 0){
                list.set(listIndex,frontElement);
                listIndex++;
                frontIndex++;
            }else{
                list.set(listIndex, backElement);
                listIndex++;
                backIndex++;
            }
        }
        while(frontIndex < frontHalf.size()){
            list.set(listIndex, frontHalf.get(frontIndex));
            listIndex++;
            frontIndex++;
        }
        while(backIndex < backHalf.size()){
            list.set(listIndex, backHalf.get(backIndex));
            listIndex++;
            backIndex++;
        }
    }
    public static <E extends Comparable<E>> void mergeSort(List<E> list){
        if(list.size() > 1){
            List<E> frontHalf = new ArrayList<>(list.subList(0, list.size()/2));
            List<E> backHalf = new ArrayList<>(list.subList(list.size()/2, list.size()));

            //list.subList()
            mergeSort(frontHalf);
            mergeSort(backHalf);
            merge(list, frontHalf, backHalf);
        }
    }

    private static <E extends Comparable<E>> int partition(List<E> list, int p, int q){
        E element = list.get(p);
        int k = p;
        for(int i = p+1; i < q; i++){
            if(element.compareTo(list.get(i)) > 0){
                k++;
                E tmp = list.get(i);
                list.set(i, list.get(k));
                list.set(k, tmp);
            }
        }
        list.set(p, list.get(k));
        list.set(k, element);
        return k;
    }
    private static <E extends Comparable<E>> void quickSort(List<E> list, int p, int q){
        if(p < q){
            int k = partition(list, p, q);
            quickSort(list, p, k);
            quickSort(list, k+1, q);
        }
    }
    public static <E extends Comparable<E>> void quickSort(List<E> list){
        quickSort(list, 0, list.size());

    }
    public static <E extends Comparable<E>> void heapSort(List<E> list){
        Heap<E> heap = new Heap<>();
        for(E e:list){
            heap.insert(e);
        }
        int i = 0;
        while(heap.size() > 0){
            list.set(i++, heap.delete());
        }
    }
}

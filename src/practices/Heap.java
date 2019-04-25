package practices;

import java.util.ArrayList;

public class Heap <E extends Comparable<E>>{
    private ArrayList<E> datas;
    private int size;
    private final static int INIT_SIZE = 32;

    public Heap(){
        datas = new ArrayList<>(INIT_SIZE);
        size = 0;
    }
    private int parrent(int index){
        if(index % 2 == 1){
            return index / 2;
        }
        return index / 2 - 1;
    }
    private int leftChild(int index){
        return index * 2 + 1;
    }
    private int rightChild(int index){
        return (index + 1) * 2;
    }
    private void adjust(){
        int lChild = leftChild(0);
        int rChild = rightChild(0);
        E parrent = datas.get(0);
        int indexP = 0;
        while(lChild < size || rChild < size){
            E min = parrent;
            int index = indexP;
            if(lChild < size){
                E leftData  = datas.get(lChild);
                if(leftData.compareTo(parrent) <= 0){
                    min = leftData;
                    index = lChild;
                }
            }
            if(rChild < size){
                E rightData = datas.get(rChild);
                if(rightData.compareTo(min) <= 0){
                    min = rightData;
                    index = rChild;
                }
            }
            if(index == indexP) {
                break;
            }
            datas.set(index, parrent);
            datas.set(indexP, min);
            indexP = index;
            lChild = leftChild(indexP);
            rChild = rightChild(indexP);
        }
    }
    public boolean insert(E e){
        datas.add(e);
        size++;
        int index = size-1;
        int parrentIndex = parrent(index);
        while(parrentIndex >= 0){
            E parrent = datas.get(parrentIndex);
            if(e.compareTo(parrent) < 0){
                datas.set(index, parrent);
                datas.set(parrentIndex, e);
                index = parrentIndex;
                parrentIndex = parrent(parrentIndex);
            }else{
                break;
            }
        }
        return true;
    }
    public E delete(){
        if(size == 0){
            return null;
        }
        E result = datas.get(0);
        datas.set(0,datas.get(size-1));
        size--;
        adjust();
        datas.remove(size);
        return result;
    }
    @Override
    public String toString(){
        return datas.toString();
    }
    public int size(){
        return size;
    }
}

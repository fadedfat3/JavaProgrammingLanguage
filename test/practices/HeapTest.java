package practices;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void insert() {
        Heap<Integer> heap = new Heap<>();
        System.out.println(heap);
        heap.insert(3);
        System.out.println(heap);
        heap.insert(6);
        System.out.println(heap);
        heap.insert(4);
        System.out.println(heap);
        heap.insert(10);
        System.out.println(heap);
        heap.insert(15);
        System.out.println(heap);
        heap.insert(20);
        System.out.println(heap);
        heap.insert(-8);
        System.out.println(heap);
        heap.insert(-30);
        System.out.println(heap);
        heap.insert(13);
        System.out.println(heap);
        heap.insert(1);
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
        System.out.println(heap.delete());
        System.out.println(heap);
    }
}
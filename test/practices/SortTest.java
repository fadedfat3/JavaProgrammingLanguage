package practices;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void insertSort() {
        List<String> list = new ArrayList<>();
        list.add("abg");
        list.add("");
        list.add("tyhetggh");
        list.add("a");
        list.add(" sfe\\fef");
        Sort.insertSort(list);
        List<String> expectedList = new ArrayList<>(list);
        Collections.sort(expectedList);
        assertArrayEquals(expectedList.toArray(), list.toArray());

    }

    @Test
    public void insertSort1() {
        List<String> list = new ArrayList<>();
        list.add("abg");
        list.add("");
        list.add("tyhetggh");
        list.add("a");
        list.add(" sfe\\fef");
        Sort.insertSort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<String> expectedList = new ArrayList<>(list);
        Collections.sort(expectedList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        assertArrayEquals(expectedList.toArray(), list.toArray());

    }

    @Test
    public void mergeSort() {
        List<String> list = new ArrayList<>();
        list.add("abg");
        list.add("");
        list.add("tyhetggh");
        list.add("a");
        list.add(" sfe\\fef");

        List<String> expectedList = new ArrayList<>(list);
        Collections.sort(expectedList);
        Sort.mergeSort(list);
        assertArrayEquals(expectedList.toArray(), list.toArray());

    }

    @Test
    public void quickSort() {
        List<String> list = new ArrayList<>();
        list.add("abg");
        list.add("");
        list.add("tyhetggh");
        list.add("a");
        list.add(" sfe\\fef");

        List<String> expectedList = new ArrayList<>(list);
        Collections.sort(expectedList);
        Sort.quickSort(list);
        assertArrayEquals(expectedList.toArray(), list.toArray());
        System.out.println(expectedList);
        System.out.println(list);
    }

    @Test
    public void heapSort() {
        List<String> list = new ArrayList<>();
        list.add("abg");
        list.add("");
        list.add("tyhetggh");
        list.add("a");
        list.add(" sfe\\fef");
        Sort.heapSort(list);
        List<String> expectedList = new ArrayList<>(list);
        Collections.sort(expectedList);
        assertArrayEquals(expectedList.toArray(), list.toArray());

    }
}
package practices;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void insert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(0);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(4);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(1);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(3);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(9);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(7);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(12);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(20);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(-2);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(-10);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(17);
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());

    }


    @Before
    public void setUp() throws Exception {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(0);
        bst.insert(4);
        bst.insert(1);
        bst.insert(3);
        bst.insert(9);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
        bst.insert(-2);
        bst.insert(-10);
        bst.insert(17);
        bst.insert(25);
        bst.insert(2);
        bst.insert(8);
        bst.insert(5);
        System.out.println(bst);
        bst.delete(0);
        System.out.println(bst);
        System.out.println(bst.previousOrder());
        System.out.println(bst.postOrder());
    }
}
package practices;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void insert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(0);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(4);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(1);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(3);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(9);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(7);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(12);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(20);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(-2);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(-10);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());
        bst.insert(17);
        assertTrue(bst.isBST());
        assertArrayEquals(bst.postOrder().toArray(), bst.postOrderR().toArray());

    }




}
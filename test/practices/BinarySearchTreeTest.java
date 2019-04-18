package practices;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void getDepth() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
    }

    @Test
    public void previousOrder() {
    }

    @Test
    public void inOrder() {
    }

    @Test
    public void postOrder() {
    }

    @Test
    public void insert() {
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
        System.out.println(bst.previousOrder());
        System.out.println(bst.inOrder());
        System.out.println(bst.postOrder());
    }
}
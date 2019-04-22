package practices;

import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {

    @Test
    public void insert() {
        AVLTree<Integer> bst = new AVLTree<>();
        print(bst);
        print(bst.previousOrder());
        assertTrue(bst.isBalanced());
        bst.insert(0);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(4);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(1);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(3);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(9);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(7);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(12);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(20);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(-2);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(-10);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(17);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(25);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(2);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(8);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());
        bst.insert(5);
        assertTrue(bst.isBalanced());
        print(bst);
        print(bst.previousOrder());

        bst.delete(0);
        print(bst);
        print(bst.previousOrder());
        bst.delete(4);
        print(bst);
        print(bst.previousOrder());

        bst.delete(1);
        print(bst);
        print(bst.previousOrder());
    }
    public void print(Object o){
        System.out.println(o);
    }
}
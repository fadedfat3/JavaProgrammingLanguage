package practices;

import java.math.BigInteger;
import java.util.ArrayList;

public class AVLTree<E> extends BinarySearchTree<E>{
    protected static class AVLNode<E> extends BinarySearchTree.Node<E>{
        private int height = 1;
        public AVLNode(){

        }
        public AVLNode(E o){
            super(o);
        }
    }

    public AVLTree(){

    }
    @Override
    protected AVLNode<E> createNewNode(E o){ //override return value is different from base class, why?
        return new AVLNode<E>(o);
    }
    private void updateHeight(AVLNode<E> node){
        if(node.left != null && node.right == null){
            node.height = ((AVLNode<E>)node.left).height + 1;
        }else if(node.right != null && node.left == null){
            node.height = ((AVLNode<E>)node.right).height + 1;
        }else if(node.right != null && node.left != null){
            node.height = Math.max(((AVLNode)node.left).height, ((AVLNode)node.right).height) + 1;
        }else{
            node.height = 1;
        }
    }
    private int balanceFactor(AVLNode<E> node){
        if(node.left == null && node.right != null){
            return ((AVLNode)node.right).height;
        }else if(node.right == null && node.left != null){
            return -((AVLNode)node.left).height;
        }else if(node.left != null && node.right != null){
            return ((AVLNode)node.right).height - ((AVLNode)node.left).height;
        }
        return 0;
    }
    private void balanceLL(Node<E> node, Node<E> parrent){
        Node<E> leftChild = node.left;
        if(parrent == null){
            root = leftChild;
        }else if(parrent.left == node){
            parrent.left = leftChild;
        }else{
            parrent.right = leftChild;
        }
        node.left = leftChild.right;
        leftChild.right = node;
        updateHeight((AVLNode) node);
        updateHeight((AVLNode) leftChild);
    }
    private void balanceLR(Node<E> node, Node<E> parrent){
        Node<E> leftChild = node.left;
        Node<E> leftRightChild = leftChild.right;
        if(parrent == null){
            root = leftRightChild;
        }else if(parrent.left == node){
            parrent.left = leftRightChild;
        }else{
            parrent.right = leftRightChild;
        }
        leftChild.right = leftRightChild.left;
        node.left = leftRightChild.right;
        leftRightChild.left = leftChild;
        leftRightChild.right = node;
        updateHeight((AVLNode)leftChild);
        updateHeight((AVLNode)node);
        updateHeight((AVLNode)leftRightChild);
    }
    private void balanceRR(Node<E> node, Node<E> parrent){
        Node<E> rightChild = node.right;
        if(parrent == null){
            root = rightChild;
        }else if(parrent.left == node){
            parrent.left = rightChild;
        }else{
            parrent.right = rightChild;
        }
        node.right = rightChild.left;
        rightChild.left = node;
        updateHeight((AVLNode) node);
        updateHeight((AVLNode) rightChild);
    }
    private void balanceRL(Node<E> node, Node<E> parrent){
        Node<E> rightChild = node.right;
        Node<E> rightLeftChild = rightChild.left;
        if(parrent == null){
            root = rightLeftChild;
        }else if(parrent.left == node){
            parrent.left = rightLeftChild;
        }else {
            parrent.right = rightLeftChild;
        }
        node.right = rightLeftChild.left;
        rightChild.left = rightLeftChild.right;
        rightLeftChild.left = node;
        rightLeftChild.right = rightChild;
        updateHeight((AVLNode) node);
        updateHeight((AVLNode)rightChild);
        updateHeight((AVLNode)rightLeftChild);
    }
    private void balancePath(ArrayList<Node<E>> paths){
        for(int i = paths.size()-1; i >= 0; i--){
            AVLNode<E> node = (AVLNode<E>) paths.get(i);
            updateHeight(node);
            Node<E> parrent = i == 0 ? null : paths.get(i-1);
            if(balanceFactor(node) == -2){
                if(balanceFactor((AVLNode)node.left) > 0){
                    balanceLR(node, parrent);
                }else{
                    balanceLL(node, parrent);
                }
            }
            if(balanceFactor(node) == 2){
                if(balanceFactor((AVLNode)node.right) < 0){
                    balanceRL(node, parrent);
                }else{
                    balanceRR(node, parrent);
                }
            }
        }
    }
    @Override
    public boolean insert(Object o) {
        if(!super.insert(o)){
            return false;
        }else{
            E data = (E)o;
            ArrayList<Node<E>> paths = path(data);
            balancePath(paths);
        }
        return true;
    }

    @Override
    public boolean delete(Object o) {
        E data = (E)o;
        ArrayList<Node<E>> paths = path(data);
        Node<E> current = root, parrent = null;
        boolean isLeft = true;
        if(!paths.isEmpty()) {
            current = paths.get(paths.size() - 1);
            if (compare(current.left.data, data) == 0) {
                parrent = current;
                isLeft = true;
            } else {
                parrent = current;
                isLeft = false;
            }
        }
        if(!super.delete(o)){
            return false;
        }
        if(parrent == null) {
            current = root;
        }else if(isLeft){
            current = parrent.left;
        }else{
            current = parrent.right;
        }
        if(current != null) {
            paths.add(current);

            current = current.left;
            while (current != null) {
                paths.add(current);
                current = current.right;
            }
        }
        balancePath(paths);
        return true;
    }

    public boolean isBalanced(){
        return isBST() && isBalanced(root);
    }
    public boolean isBalanced(Node<E> node){
        if(node == null){
            return true;
        }
        return Math.abs(balanceFactor((AVLNode) node)) < 2 && isBalanced(node.left) && isBalanced((node.right));
    }
    public int getHeight(AVLNode<E> node){
        return node.height;
    }
}

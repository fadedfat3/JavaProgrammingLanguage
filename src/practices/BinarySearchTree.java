package practices;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<E> implements Tree {

    protected static class Node<E>{
        Node<E> left;
        Node<E> right;
        E data;
        public Node(){

        }
        public Node(E data){
            this(data, null, null);
        }
        public Node(Node<E> other){
            this(other.data, null, null);
        }
        public Node(E data, Node<E> left, Node<E> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    protected Node<E> root;
    private Comparator<E> comparator;
    public BinarySearchTree(){

    }
    public BinarySearchTree(BinarySearchTree<E> tree){
        root = createByRoot(tree.getRoot());
    }
    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }
    private Node<E> createByRoot(Node<E> root){
        if(root == null){
            return null;
        }
        Node<E> bst = new Node<E>(root);

        bst.left = createByRoot(root.left);
        bst.right = createByRoot(root.right);
        return bst;
    }
    protected Node<E> createNewNode(E data){
        return new Node<E>(data);
    }
    protected ArrayList<Node<E>> path(E data){
        ArrayList<Node<E>> paths = new ArrayList<>();
        Node<E> current = root;
        while(current != null){
            if(compare(data, current.data) < 0){
                paths.add(current);
                current = current.left;
            }else if(compare(data, current.data) > 0){
                paths.add(current);
                current = current.right;

            }else{
                break;
            }

        }
        return paths;
    }
    public Node<E> getRoot(){
        return root;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("BST dosen't support removing a node by iterator");
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        List<E> orders = inOrder();
        if(orders != null) {
            return inOrder().toString();
        }else{
            return "null";
        }
    }

    @Override
    public int getDepth() {
        return depth(root);
    }
    private int depth(Node<E> node){
        if(node == null){
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
    protected int compare(E e1, E e2){
        if(comparator != null){
            return comparator.compare(e1, e2);
        }else if( e1 instanceof Comparable && e2 instanceof Comparable){
            return ((Comparable) e1).compareTo(e2);
        }
        throw new RuntimeException(e1 + " or " + e2 + "is not Comparable");
    }
    @Override
    public List<E> previousOrder() {
        if(root == null){
            return null;
        }
        List<E> orders = new ArrayList<>();
        LinkedList<Node<E>> queue = new LinkedList<>();
        queue.addLast(root);
        Node<E> current;
        while(!queue.isEmpty()){
            current = queue.removeFirst();
            orders.add(current.data);
            if(current.left != null){
                queue.addLast(current.left);
            }
            if(current.right != null){
                queue.addLast(current.right);
            }
        }
        return orders;
    }

    @Override
    public List<E> inOrder() {
        if(root  == null){
            return null;
        }
        List<E> orders = new ArrayList<>();
        Stack<Node<E>> stack = new Stack<>();

        Node<E> current = root;
        while( !stack.isEmpty() || current != null){  //栈不为空或者当前节点不为空
            while(current != null){   //节点不为空压栈
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();   //节点为空出栈
            orders.add(current.data);
            current = current.right;  //遍历右子树
        }
        return orders;
    }

    @Override
    public List<E> postOrder() {
        List<E> orders = new ArrayList<>();
        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;
        Node<E> parrent = null;
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
                parrent = stack.peek();
            }
            parrent = stack.peek();
            while(parrent.right == null) {
                orders.add(parrent.data);
                stack.pop();
                if (stack.empty()) {
                    return orders;
                }
                current = parrent;
                parrent = stack.peek();
            }

            while (parrent.right == current) {
                stack.pop();
                orders.add(parrent.data);
                if(stack.empty()){
                    return orders;
                }
                current = parrent;
                parrent = stack.peek();
            }

            current = parrent.right;

        }
        return orders;
    }

    private void postOrder(List<E> list, Node<E> root){
        if(root != null){
            postOrder(list, root.left);
            postOrder(list, root.right);
            list.add(root.data);
        }
    }
    public List<E> postOrderR(){
        List<E> list = new ArrayList<>();
        postOrder(list, root);
        return list;
    }
    @Override
    public boolean insert(Object o) {
        E data = (E)o;
        if(root == null){
            root = createNewNode(data);
        }else{
            Node<E> current = root;
            Node<E> parrent = null;
            while(current != null){
                if(compare(data, current.data) < 0 ){
                    parrent = current;
                    current = current.left;
                }else if(compare(data, current.data) > 0){
                    parrent = current;
                    current = current.right;
                }else{
                    return false;
                }
            }
            Node<E> newNode = createNewNode(data);
            if(compare(data, parrent.data) < 0){
                parrent.left = newNode;
            }else {
                parrent.right = newNode;
            }
        }
        return true;
    }

    @Override
    public Node<E> search(Object o) {
        E data = (E)o;
        Node<E> current = root;
        while(current != null){
            if(compare(data, current.data) < 0){
                current = current.left;
            }else if(compare(data, current.data) > 0){
                current = current.right;
            }else{
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Object o) {
        E data = (E) o;
        Node<E> current = root, parrent = null;
        if (search(o) == null) {
            return false;
        }
        while (current != null) {
            if (compare(data, current.data) > 0) {
                parrent = current;
                current = current.right;
            } else if (compare(data, current.data) < 0) {
                parrent = current;
                current = current.left;
            } else {
                break;
            }
        }

            if (current.left == null) {
                if(parrent == null){ //delete root node
                    root = current.right;
                }else if(parrent.left == current){
                    parrent.left = current.right;
                }else{
                    parrent.right = current.right;
                }
            } else {
                Node<E> rightMost = current.left;
                Node<E> parrentOfRightMost = current;
                while(rightMost.right != null){
                    parrentOfRightMost = rightMost;
                    rightMost = rightMost.right;
                }
                current.data = rightMost.data;   //move rightMost to current
                //remove rightMost, rightMost.right must to be null
                if(parrentOfRightMost.left == rightMost){    //current doesn't have right
                    parrentOfRightMost.left = rightMost.left;
                }else {
                    parrentOfRightMost.right = rightMost.left;
                }
            }
        return true;
    }
    protected boolean isBST(){
        return isBST(root);
    }
    protected boolean isBST(Node<E> node){
        boolean success = true;
        if(node == null){
            return success;
        }
        if(node.left != null && success){
            success = compare(node.left.data, node.data) < 0;
        }
        if(node.right != null && success){
            success = compare(node.right.data , node.data) > 0;
        }
        return success && isBST(node.left) && isBST(node.right);
    }
}

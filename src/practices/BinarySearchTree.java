package practices;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<E> implements Tree {

    protected class Node<E>{
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
    private Node<E> root;
    private Comparator<E> comparator;
    public BinarySearchTree(){
        root = new Node<>();
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
    private Node<E> createNode(E data, Node<E> left, Node<E> right){
        return new Node<E>(data, left, right);
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
        return inOrder().toString();
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
    private int compare(E e1, E e2){
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
        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            while(current.right == null){
                orders.add(current.data);
                stack.pop();
                if(stack.empty()){
                    return orders;
                }
                Node<E> parrent = stack.peek();
                if(parrent.right == null){
                    current = parrent;
                }else {
                    while (parrent.right == current) {

                        stack.pop();
                        orders.add(parrent.data);
                        if(stack.empty()){
                            return orders;
                        }
                        parrent = stack.peek();

                        break;
                    }
                    while (parrent.left == current) {
                        current = parrent.right;
                        break;
                    }
                }
            }
            current = current.right;

        }
        return orders;
    }

    @Override
    public void insert(Object o) {
        E data = (E)o;
        if(root.data == null){
            root = new Node<E>(data);
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
                    throw new RuntimeException("Can not insert same data in BST");
                }
            }
            Node<E> newNode = new Node<E>(data);
            if(compare(data, parrent.data) < 0){
                parrent.left = newNode;
            }else {
                parrent.right = newNode;
            }
        }
    }

    @Override
    public void delete(Object data) {

    }
}

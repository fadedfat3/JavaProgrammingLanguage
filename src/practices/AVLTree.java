package practices;

import java.math.BigInteger;
import java.util.ArrayList;

public class AVLTree<E> extends BinarySearchTree<E>{
    protected static class AVLNode<E> extends BinarySearchTree.Node<E>{
        private int height = 0;
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
    private ArrayList<AVLNode<E>> path(E node){
        ArrayList<AVLNode<E>> paths = new ArrayList<>();
        AVLNode<E> current = (AVLNode)root;
        while(current != null ){
            if(compare(node, current.data) < 0){
                current = (AVLNode) current.left;
                paths.add(current);
            }else if(compare(node, current.data) > 0){
                current = (AVLNode)current.right;
                paths.add(current);
            }else{
                break;
            }
        }
        return paths;
    }
    private void updateHeight(AVLNode<E> node){
        if(node.left != null ){
            node.height = Math.max(((AVLNode<E>)node.left).height, node.height) + 1;
        }
        if(node.right != null){
            node.height = Math.max(((AVLNode<E>)node.right).height, node.height ) + 1;
        }
    }
    @Override
    public boolean insert(Object o) {
        if(!super.insert(o)){
            return false;
        }else{
            E data = (E)o;
            ArrayList<AVLNode<E>> paths = path(data);
            for(int i = paths.size()-1; i >= 0; i--){
                AVLNode<E> node = paths.get(i);

            }
        }

    }

    @Override
    public boolean delete(Object o) {
        super.delete(o);
    }
}

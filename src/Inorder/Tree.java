package Inorder;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Tree<T extends Comparable<T>> implements Iterable{
    private Node<T> root;
    public Tree(){
    }

    public void insert(Node<T> n){
        if(root == null){
            root = n;
        } else{
            root.insert(n);
        }
    };

    @Override
    public String toString(){
        if(root == null){
            return "";
        }
        return root.getAll();
    }


    @Override
    public Iterator<Node<T>> iterator() {
        return new TreeIterator<>(this.root);
    }


    private static class TreeIterator<T extends Comparable<T>> implements Iterator<Node<T>>{
        Iterator<Node> left;
        Iterator<Node> right;
        Node element;
        boolean yieldedOwnValue = false;

        public TreeIterator(Node<T> root){
            element = root;
            if(root != null) {
                left = new TreeIterator<>(root.getLeft());
                right = new TreeIterator<>(root.getRight());
            }
        }

        @Override
        public boolean hasNext() {
            if(element == null){
                return false;
            }
            return left.hasNext() || !yieldedOwnValue || right.hasNext();
        }

        @Override
        public Node<T> next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            if(left.hasNext()){
                return left.next();
            } else if (!yieldedOwnValue) {
                yieldedOwnValue = true;
                return element;
            }else {
                return right.next();
            }
        }
    }
}

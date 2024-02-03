package Preorder;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Tree<T extends Comparable<T>> implements Iterable<Object> {
    private Node<T> root;
    public Tree(){
    }

    public void insert(Preorder.Node<T> n){
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
    public Iterator<Object> iterator() {
        return new TreeIterator(this.root);
    }


    private static class TreeIterator<T extends Comparable<T>> implements Iterator<Node<T>> {
        Iterator<Node<T>> left;
        Iterator<Node<T>> right;
        Node<T> element;
        boolean yieldedOwnValue = false;

        public TreeIterator(Node<T> root){
            element = root;
            if(root != null) {
                left = new TreeIterator(element.getLeft());
                right = new TreeIterator(element.getRight());
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
             if (!yieldedOwnValue) {
                yieldedOwnValue = true;
                return element;
            } else if(left.hasNext()){
                    return left.next();
             }
             else {
                return right.next();
            }
        }
    }
}
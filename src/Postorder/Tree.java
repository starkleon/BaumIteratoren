package Postorder;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Tree<T extends Comparable<T>> implements Iterable<Node<T>>{
    private Node<T> root;

    public Tree(){
    }
    public Tree(Node<T> root){
        this.root = root;
    }

    public void insert(Node<T> node){
        if(root == null){
            root = node;
        }else {
            root.insert(node);
        }
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new TreeIterator<T>(this.root);
    }

    private static class TreeIterator<T extends Comparable<T>> implements Iterator<Node<T>>{
        private final Node<T> element;
        private Iterator<Node<T>> left;
        private Iterator<Node<T>> right;
        private boolean yieldedOwnValue = false;

        public TreeIterator(Node<T> root){
            element = root;
            if(element != null){
                left = new TreeIterator<>(element.getLeft());
                right = new TreeIterator<>(element.getRight());
            }
        }


        @Override
        public boolean hasNext() {
            if(element == null){
                return false;
            }
            return left.hasNext() || right.hasNext() || !yieldedOwnValue;
        }

        @Override
        public Node<T> next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            if(left.hasNext()){
                return left.next();
            } else if (right.hasNext()) {
                return right.next();
            }
            else{
                yieldedOwnValue = true;
                return element;
            }
        }
    }
}

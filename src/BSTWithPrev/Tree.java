package BSTWithPrev;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Tree<T extends Comparable<T>> implements Iterable<T>{

    private Node<T> root;

    private T min;
    private T max;

    public Tree(){
        this.root = null;
    }

    public void insert(T value){
        if(root == null){
            root = new Node<>(value);
            min = max = root.value;
        }
        else{
            if(value.compareTo(min) < 0){
                min = value;
            }
            if(value.compareTo(max) > 0){
                max = value;
            }
            root.insert(new Node<>(value));
        }
    }

    private boolean canContain(T val){
        return (min.compareTo(val) <= 0 && max.compareTo(val) >= 0);
    }

    public boolean contains(T val){
        if(!canContain(val)){
            return false;
        }
        return root.contains(val);
    }





    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(T t : this){
            sb.append(t).append(", ");
        }
        sb.setLength(sb.length()-2);
        return sb.toString();
    }





//-------------------Iterator-----------------------------------------------------
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<>(this);
    }

    private static class TreeIterator<T extends Comparable<T>> implements Iterator<T>{
        Node<T> current;

        private TreeIterator(Tree<T> tree){
            current = tree.root;
            while(current.left != null){
                current = current.left;
            }
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T ret = current.value;

            if(current.right != null){
                current = current.right;
                while(current.left != null){
                    current = current.left;
                }
            }
            else {
                Node<T> wasBefore = null;
                while (current != null && current.right == wasBefore){
                    wasBefore = current;
                    current = current.previous;
                }
            }
            return ret;
        }
    }

    //---------------------Node---------------------------------------------------------
    private static class Node<T extends Comparable<T>>{
        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node<T> previous;


        public Node(T value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.previous = null;
        }

        public void insert(Node<T> node) {
            T otherValue = node.getValue();
            if (value.equals(otherValue)) {
                return;
            }
            if (value.compareTo(otherValue) > 0) {
                if (left == null) {
                    left = node;
                    left.setPrevious(this);
                } else {
                    left.insert(node);
                }
            } else {
                if (right == null) {
                    right = node;
                    right.setPrevious(this);
                } else {
                    right.insert(node);
                }
            }
        }


        private boolean contains(T otherValue){
            if(value.equals(otherValue)){return true;}
            if(value.compareTo(otherValue) > 0){
                return (left != null && left.contains(otherValue));
            }
            else{
                return (right != null && right.contains(otherValue));
            }
        }


        //-------------------getter und setter----------------------
        public T getValue() {
            return value;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}

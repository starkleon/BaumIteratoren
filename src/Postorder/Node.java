package Postorder;

public class Node <T extends Comparable<T>>{
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value){
        this.value = value;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString(){
        return this.value + "";
    }
    public void insert(Node <T> node){
        if(node.value.compareTo(this.value) < 0){
            if(this.left == null){
                left = node;
            }
            else {
                left.insert(node);
            }
        }else {
            if(right == null){
                right = node;
            }
            else{
                right.insert(node);
            }
        }
    }
}

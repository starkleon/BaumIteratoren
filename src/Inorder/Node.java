package Inorder;

public class Node<T extends Comparable<T>>{
    private final T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value){
        this.value = value;
    }

    public void insert(Node<T> n){
        if(n.getValue().compareTo(this.value) < 0){
            if(left == null){
                left = n;
            }
            else {
                left.insert(n);
            }
        }else {
            if(right == null){
                right = n;
            }
            else{
                right.insert(n);
            }
        }
    }

    public String getAll(){
        String ret = "";
        if(left != null){
            ret =  ret +  left.getAll();
        }
        ret = ret + value;
        if(right != null){
            ret =  ret + right.getAll();
        }
        return ret;
    }

    public Node getLeft() {
        return left;
    }

    public T getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }
    @Override
    public String toString(){
        return value + "";
    }
}

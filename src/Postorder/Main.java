package Postorder;
import Postorder.Tree;

public class Main {
    public static void main(String[] args){
        Tree<Integer> t = new Tree<>();
        t.insert(new Node<>(5));
        t.insert(new Node<>(3));
        t.insert(new Node<>(2));
        t.insert(new Node<>(4));
        t.insert(new Node<>(7));
        t.insert(new Node<>(6));
        t.insert(new Node<>(8));


        for(Node<Integer> n : t){
            System.out.println(n);
        }
    }
}

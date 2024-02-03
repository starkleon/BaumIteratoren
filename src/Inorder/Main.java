package Inorder;

import Inorder.Node;
import Inorder.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> t = new Tree();

        t.insert(new Node<>(5));
        t.insert(new Node<>(3));
        t.insert(new Node<>(8));
        t.insert(new Node<>(4));
        t.insert(new Node<>(6));

        for(Object n : t){
            System.out.println(n);
        }
    }
}
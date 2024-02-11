package BSTWithPrev;

import java.util.Random;

public class Main {


    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>();
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            tree.insert(r.nextInt(-50,200));
        }

        System.out.println(tree);
    }
}

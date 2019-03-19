package com.codecool.javabst;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            numbers.add(i * 2 + 5);
        }
        System.out.println(numbers);
        BinarySearchTree myTree = new BinarySearchTree();
        myTree.build(numbers);

        System.out.println("MY TREE: "+myTree.toList());
        System.out.println(myTree.getNode(9));
        // write some test code here
        //System.out.println(myTree.search(7)); // should be true
        //System.out.println(myTree.search(55)); // should be true
        //System.out.println(myTree.search(34535)); // should be false


        System.out.println("done");
    }
}
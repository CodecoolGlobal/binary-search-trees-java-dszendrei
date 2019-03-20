package com.codecool.javabst;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            numbers.add(i * 2 + 5);
        }
        System.out.println(numbers);
        BinarySearchTree myTree = new BinarySearchTree();
        myTree.build(numbers);

        System.out.println("MY TREE: "+myTree.toList());
        System.out.println(myTree.getNode(19));
        System.out.println(myTree.getNode(21));
        System.out.println(myTree.getNode(23));
        System.out.println(myTree.getNode(55));
        System.out.println(myTree.search(7)); // should be true
        System.out.println(myTree.search(55)); // should be true
        System.out.println(myTree.search(34535)); // should be false

        myTree.add(4);
        System.out.println(myTree.search(7)); // should be true
        System.out.println(myTree.search(55)); // should be true
        System.out.println(myTree.search(34535)); // should be false
        System.out.println(myTree.search(4)); // should be true
        myTree.add(4);

        myTree.remove(4);
        System.out.println(myTree.search(7)); // should be true
        System.out.println(myTree.search(55)); // should be true
        System.out.println(myTree.search(34535)); // should be false
        System.out.println(myTree.search(4)); // should be false

        System.out.println("done");
    }
}
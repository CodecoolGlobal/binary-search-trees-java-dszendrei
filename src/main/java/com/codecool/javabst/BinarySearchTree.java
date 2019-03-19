package com.codecool.javabst;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {
    BSTNode rootNode;
    Set<Integer> listOfValues = new HashSet<>();
    BSTNode nodeToGet;
    BSTNode prevNode = null;

    public BinarySearchTree build(List<Integer> elements) {
        // TODO construct a binary search tree here
        elements.sort(Integer::compareTo);
        rootNode = new BSTNode(elements.get(elements.size()/2), null);
        elements.forEach(this::add);
        return null;
    }

    public boolean search(Integer toFind) {
        // TODO return true if the element has been found, false if its not in the tree.
        return containsNodeRecursive(rootNode, toFind);
    }

    public BSTNode getNode(Integer toGet) {
        if (search(toGet)) return nodeToGet;
        return null;
    }


    public void add(Integer toAdd) {
        // TODO adds an element. Throws an error if it exist.
        /*System.out.println("toAdd: "+toAdd);
        BSTNode node = rootNode;
        System.out.println("node before while: "+node);
        System.out.println("is next null "+!(node.getNextNode() == null));
        System.out.println("is prev null "+!(node.getPrevNode() == null));
        while (!(node.getNextNode() == null) && !(node.getPrevNode() == null)) {
            System.out.println(node.getValue());
            System.out.println(1);
            if (node.getPrevNode().getValue().equals(toAdd) || node.getNextNode().getValue().equals(toAdd)) throw new KeyAlreadyExistsException();
            if (toAdd > node.getValue()) node = node.getNextNode();
            else if (toAdd < node.getValue()) node = node.getPrevNode();
        }
        if (toAdd > node.getValue()) node.setNextNode(new BSTNode(toAdd));
        else if (toAdd < node.getValue()) node.setPrevNode(new BSTNode(toAdd));
        System.out.println("node after while: "+node);
        */
        BSTNode node = addRecursive(rootNode, toAdd);
    }

    private BSTNode addRecursive(BSTNode current, int value) {
        if (current == null) {
            BSTNode nodeToAdd = new BSTNode(value, prevNode);
            //checkLayer(nodeToAdd);
            return nodeToAdd;
        }
        prevNode = current;
        if (value < current.value) {
            current.leftNode = addRecursive(current.leftNode, value);
        } else if (value > current.value) {
            current.rightNode = addRecursive(current.rightNode, value);
        } else {
            System.out.println("KEY ALREADY EXISTS");
            return current;
        }
        return current;
    }

    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
    }

    public List<Integer> toList() {
        //Set<Integer> listOfValues = new HashSet<>();
        BSTNode node = addRecursiveToList(rootNode);
        return new ArrayList<>(listOfValues);
    }

    private BSTNode addRecursiveToList(BSTNode current) {
        System.out.println(current.value);
        listOfValues.add(current.value);
        if(current.leftNode != null) {
            if (!listOfValues.contains(current.leftNode.value)) {
                current.leftNode = addRecursiveToList(current.leftNode);
            }
        }
        if(current.rightNode != null) {
            if (!listOfValues.contains(current.rightNode.value)) {
                current.rightNode = addRecursiveToList(current.rightNode);
            }
        } else {
            System.out.println("SUBKEY ALREADY EXISTS");
            return current;
        }

        return current;
    }


    private boolean containsNodeRecursive(BSTNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            nodeToGet = current;
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.leftNode, value)
                : containsNodeRecursive(current.rightNode, value);
    }

    private void checkLayer(BSTNode node) {
        BSTNode parentNode;
        BSTNode grandParentNode;
        if (node.parentNode != null) {
            parentNode = node.parentNode;
            if (parentNode.parentNode != null) {
                grandParentNode = parentNode.parentNode;
                if (parentNode.leftNode == null && grandParentNode.leftNode == null) {
                    node.parentNode =
                    parentNode.parentNode = grandParentNode.parentNode;
                    parentNode.leftNode = grandParentNode;
                    grandParentNode.rightNode = null;
                    grandParentNode.parentNode = parentNode;
                }
            }
        }
    }

}

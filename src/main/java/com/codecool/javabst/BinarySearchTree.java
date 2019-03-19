package com.codecool.javabst;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.*;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {
    private BSTNode rootNode;
    private Set<Integer> listOfValues = new HashSet<>();
    private BSTNode nodeToGet;

    public void build(List<Integer> elements) {
        // TODO construct a binary search tree here
        elements.sort(Integer::compareTo);
        rootNode = new BSTNode(elements.get(elements.size()/2));
        int i = 2;
        Set<Integer> orderedElements = new LinkedHashSet<>();
        Integer actualValue;
        int index;
        do {
            index = elements.size()/(i);
            while (index < elements.size() && index > 0) {
                actualValue = elements.get(index);
                orderedElements.add(actualValue);
                index += elements.size()/(i/2);
            }
            i = i*2;
        } while (index>0);
        orderedElements.addAll(elements);
        System.out.println("OE "+orderedElements);
        orderedElements.forEach(integer -> addRecursive(rootNode, integer));

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
        //if (search(toAdd)) throw new KeyAlreadyExistsException();
        //List<Integer> allNodes = toList();
        //allNodes.add(toAdd);
        //allNodes.sort(Integer::compareTo);
        //rootNode = new BSTNode(allNodes.get(allNodes.size()/2), null);
        toList();
        listOfValues.add(toAdd);
        List<Integer> elements = new ArrayList<>(listOfValues);
        elements.sort(Integer::compareTo);
        build(elements);
    }

    private BSTNode addRecursive(BSTNode current, int value) {
        if (current == null) {
            BSTNode nodeToAdd = new BSTNode(value);
            //checkLayer(nodeToAdd);
            return nodeToAdd;
        }
        BSTNode prevNode = current;
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
        toList();
        listOfValues.remove(toRemove);
        List<Integer> elements = new ArrayList<>(listOfValues);
        elements.sort(Integer::compareTo);
        build(elements);
    }

    public List<Integer> toList() {
        listOfValues = new HashSet<>();
        addRecursiveToList(rootNode);
        return new ArrayList<>(listOfValues);
    }

    private BSTNode addRecursiveToList(BSTNode current) {
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
/*
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
    }*/

}

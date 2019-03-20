package com.codecool.javabst;

import org.junit.Before;
import org.junit.Test;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree binarySearchTree;

    @Before
    public void init() {
        binarySearchTree = new BinarySearchTree();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        binarySearchTree.build(list);
    }

    @Test
    public void build() {
        assertEquals(10, binarySearchTree.toList().size());
    }

    @Test
    public void search() {
        assertTrue(binarySearchTree.search(0));
        assertTrue(binarySearchTree.search(9));
        assertFalse(binarySearchTree.search(-1));
        assertFalse(binarySearchTree.search(10));
    }

    @Test
    public void getNode() {
        System.out.println(binarySearchTree.getNode(3));
        BSTNode testNode = new BSTNode(5);
        testNode.rightNode = new BSTNode(7);
        testNode.leftNode = new BSTNode(2);
        BSTNode testNode2 = new BSTNode(3);
        testNode2.rightNode = new BSTNode(4);
        assertEquals(binarySearchTree.getNode(5), testNode);
        assertEquals(binarySearchTree.getNode(3), testNode2);
    }


    @Test
    public void add() {
        binarySearchTree.add(10);
        assertTrue(binarySearchTree.search(10));
        assertTrue(binarySearchTree.search(9));
        assertFalse(binarySearchTree.search(11));
    }

    @Test(expected = KeyAlreadyExistsException.class)
    public void addAlreadyExistingKey() {
        binarySearchTree.add(0);
    }

    @Test
    public void remove() {
        binarySearchTree.remove(0);
        assertFalse(binarySearchTree.search(0));
        assertTrue(binarySearchTree.search(1));
        binarySearchTree.remove(9);
        assertFalse(binarySearchTree.search(9));
        assertTrue(binarySearchTree.search(8));
    }

    @Test(expected = NoSuchElementException.class)
    public void removeNoExisting() {
        binarySearchTree.remove(10);
    }

    @Test
    public void toList() {
        assertEquals(binarySearchTree.toList().size(), 10);
    }

}
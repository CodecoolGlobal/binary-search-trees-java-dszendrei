package com.codecool.javabst;

public class BSTNode {

    int value;
    BSTNode leftNode;
    BSTNode rightNode;

    BSTNode(int value) {
        this.value = value;
        rightNode = null;
        leftNode = null;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "value=" + value +
                ", leftNodeValue=" + leftNodeValue() +
                ", rightNodeValue=" + rightNodeValue() +
                '}';
    }

    private Integer leftNodeValue(){
        if (leftNode != null) return leftNode.value;
        return null;
    }

    private Integer rightNodeValue(){
        if (rightNode != null) return rightNode.value;
        return null;
    }

}

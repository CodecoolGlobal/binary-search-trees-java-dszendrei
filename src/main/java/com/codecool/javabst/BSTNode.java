package com.codecool.javabst;

public class BSTNode {

    int value;
    BSTNode leftNode;
    BSTNode rightNode;
    BSTNode parentNode;

    BSTNode(int value, BSTNode parentNode) {
        this.value = value;
        rightNode = null;
        leftNode = null;
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "value=" + value +
                ", leftNodeValue=" + leftNodeValue() +
                ", rightNodeValue=" + rightNodeValue() +
                ", parentNodeValue=" + parentNodeValue() +
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

    private Integer parentNodeValue(){
        if (parentNode != null) return parentNode.value;
        return null;
    }
}

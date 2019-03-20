package com.codecool.javabst;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BSTNode node = (BSTNode) o;
        return value == node.value &&
                Objects.equals(leftNodeValue(), node.leftNodeValue()) &&
                Objects.equals(rightNodeValue(), node.rightNodeValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, leftNode, rightNode);
    }
}

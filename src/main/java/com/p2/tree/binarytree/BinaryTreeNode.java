package com.p2.tree.binarytree;

public class BinaryTreeNode {

    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    private int data;

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode withLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode withRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
        return this;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode withData(int data) {
        this.data = data;
        return this;
    }

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public BinaryTreeNode(int data, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public boolean isLeafNode() {
        return (leftChild == null && rightChild == null);
    }

    public boolean isFullNode() {
        return (leftChild != null && rightChild != null);
    }

    @Override
    public String toString() {
        return this.getData() + "-->";
    }
}

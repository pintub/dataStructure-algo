package com.p2.tree.binarytree;

public class BinaryTreeNode<T> {

    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private T data;

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> withLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<T> withRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> withData(T data) {
        this.data = data;
        return this;
    }

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
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

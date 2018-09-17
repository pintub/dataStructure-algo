package com.p2.tree.binarytree;

import java.util.Stack;

public class BinaryTreeOperation {

    private BinaryTreeNode root;

    public void createHardCodedBinaryTree() {

        BinaryTreeNode lvl3Leaf5 = new BinaryTreeNode(5);
        BinaryTreeNode lvl3Leaf11 = new BinaryTreeNode(11);
        BinaryTreeNode lvl3Leaf4 = new BinaryTreeNode(4);

        BinaryTreeNode lvl2Leaf2 = new BinaryTreeNode(2);
        BinaryTreeNode lvl2node6 = new BinaryTreeNode(6, lvl3Leaf5, lvl3Leaf11);
        BinaryTreeNode lvl2node9 = new BinaryTreeNode(9).withLeftChild(lvl3Leaf4);

        BinaryTreeNode lvl1node7 = new BinaryTreeNode(7, lvl2Leaf2, lvl2node6);
        BinaryTreeNode lvl1node5 = new BinaryTreeNode(5).withRightChild(lvl2node9);

        root = new BinaryTreeNode(2).withLeftChild(lvl1node7).withRightChild(lvl1node5);
    }

    private void preOrderTraversalUsingRecursion(BinaryTreeNode currentNode) {
        if (currentNode == null) {
            return;
        } else {
            System.out.print(currentNode);
            preOrderTraversalUsingRecursion(currentNode.getLeftChild());
            preOrderTraversalUsingRecursion(currentNode.getRightChild());
        }
    }

    //Iteration using Stacks
    public void preOrderTraversalUsingIteration() {
        if (root == null) {
            throw new IllegalArgumentException("Binary Tree is Empty");
        }

        Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<BinaryTreeNode>();
        System.out.print(root);
        binaryTreeNodeStack.push(root);

        while (!binaryTreeNodeStack.empty()) {
            if (binaryTreeNodeStack.peek() != null) {//If node is not Null
                BinaryTreeNode top = binaryTreeNodeStack.peek();
                if (top.getLeftChild() != null) {
                    System.out.print(top.getLeftChild());
                }
                binaryTreeNodeStack.push(top.getLeftChild());
            } else {//If Node is Null
                binaryTreeNodeStack.pop();
                if (binaryTreeNodeStack.empty()) {
                    break;
                }
                BinaryTreeNode top = binaryTreeNodeStack.pop();
                if (top.getRightChild() != null) {
                    System.out.print(top.getRightChild());
                }
                binaryTreeNodeStack.push(top.getRightChild());
            }
        }

        System.out.println("\n");
    }


    public void preOrderTraversalUsingRecursion() {
        preOrderTraversalUsingRecursion(root);
        System.out.println("\n");
    }

    public static void main(String[] args) {
        BinaryTreeOperation bto = new BinaryTreeOperation();
        bto.createHardCodedBinaryTree();

        bto.preOrderTraversalUsingRecursion();
        bto.preOrderTraversalUsingIteration();
    }
}

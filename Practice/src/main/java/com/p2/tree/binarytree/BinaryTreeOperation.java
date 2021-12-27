package com.p2.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeOperation {

    private BinaryTreeNode<Integer> root;

    private void preOrderTraversalUsingRecursion(BinaryTreeNode<Integer> currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.print(currentNode);
        preOrderTraversalUsingRecursion(currentNode.getLeftChild());
        preOrderTraversalUsingRecursion(currentNode.getRightChild());
    }

    public void inOrderTraversalUsingRecursion(BinaryTreeNode<Integer> currentNode) {
        if (currentNode == null) {
            return;
        }

        inOrderTraversalUsingRecursion(currentNode.getLeftChild());
        System.out.print(currentNode);
        inOrderTraversalUsingRecursion(currentNode.getRightChild());
    }

    public void inOrderTraversalUsingIteration(BinaryTreeNode<Integer> rootNode) {
        if (rootNode == null) {
            throw new IllegalArgumentException("Binary Tree is Empty");
        }

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.isEmpty()){
            BinaryTreeNode<Integer> currNode = stack.peek();
            while (currNode != null){
                stack.push(currNode.getLeftChild());
                currNode = currNode.getLeftChild();
            }

            stack.pop();//Pop Null
            if(!stack.isEmpty()) {
                BinaryTreeNode<Integer> tmp = stack.pop();
                System.out.print(tmp);
                stack.push(tmp.getRightChild());
            }
        }
    }

    //Iteration using Stacks
    /**
     *Can be solved with stack pop and push right,left child (Like lvl order using Q)
     */
    public void preOrderTraversalUsingIteration() {
        if (root == null) {
            throw new IllegalArgumentException("Binary Tree is Empty");
        }

        BinaryTreeNode<Integer> currNode = null;
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();

        System.out.print(root);
        stack.push(root);

        while(!stack.isEmpty()) {
            currNode = stack.peek();
            while(currNode != null){
                if(currNode.getLeftChild() != null)
                    System.out.print(currNode.getLeftChild());
                stack.push(currNode.getLeftChild());
                currNode=currNode.getLeftChild();
            }
            stack.pop();//Pop null
            if(!stack.isEmpty()) {
                currNode = stack.pop();

                if (currNode.getRightChild() != null)
                    System.out.print(currNode.getRightChild());
                stack.push(currNode.getRightChild());
            }
        }
    }

    public void preOrderTraversalUsingRecursion() {
        preOrderTraversalUsingRecursion(root);
    }

    public static void main(String[] args) {
        BinaryTreeOperation bto = new BinaryTreeOperation();
        bto.createHardCodedBinaryTree();

        //bto.preOrderTraversalUsingRecursion();
        System.out.println("\n");
        //bto.preOrderTraversalUsingIteration();

        //bto.inOrderTraversalUsingRecursion(bto.root);
        System.out.println("\n");
        //bto.inOrderTraversalUsingIteration(bto.root);

        bto.postOrderTraversalUsingRecursion(bto.root);
        System.out.println("\n");
        bto.postOrderTraversalUsingIteration(bto.root);

        //bto.levelOrderUsingQ(bto.root);
    }

    //Using Queue
    private void levelOrderUsingQ(BinaryTreeNode<Integer> root) {
        if(root == null){
            throw new IllegalArgumentException("Tree Empty");
        }

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> tmp = queue.remove();
            System.out.print(tmp);
            if(tmp.getLeftChild() != null)
                queue.add(tmp.getLeftChild());

            if(tmp.getRightChild() != null)
                queue.add(tmp.getRightChild());
        }
    }

    private void postOrderTraversalUsingIteration(BinaryTreeNode<Integer> root) {
        if(root == null){
            throw new IllegalArgumentException("Tree empty");
        }

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode<Integer> recentlyRemoved = null;

        while (!stack.isEmpty()){
            BinaryTreeNode<Integer> currNode = stack.peek();
            if(currNode.isLeafNode()){
                recentlyRemoved = stack.pop();
                System.out.print(recentlyRemoved);
            } else if(recentlyRemoved == currNode.getLeftChild() ||
                    recentlyRemoved == currNode.getRightChild()) {
                recentlyRemoved = stack.pop();
                System.out.print(recentlyRemoved);
            } else {
                if(currNode.getRightChild() != null){
                    stack.push(currNode.getRightChild());
                }
                if(currNode.getLeftChild() != null){
                    stack.push(currNode.getLeftChild());
                }
            }
        }
    }

    private void postOrderTraversalUsingRecursion(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }

        postOrderTraversalUsingRecursion(root.getLeftChild());
        postOrderTraversalUsingRecursion(root.getRightChild());
        System.out.print(root);
    }

    public void createHardCodedBinaryTree() {

        BinaryTreeNode<Integer> lvl3Leaf5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> lvl3Leaf11 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> lvl3Leaf4 = new BinaryTreeNode<>(4);

        BinaryTreeNode<Integer> lvl2Leaf2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> lvl2node6 = new BinaryTreeNode<>(6, lvl3Leaf5, lvl3Leaf11);
        BinaryTreeNode<Integer> lvl2node9 = new BinaryTreeNode<>(9).withLeftChild(lvl3Leaf4);

        BinaryTreeNode<Integer> lvl1node7 = new BinaryTreeNode<>(7, lvl2Leaf2, lvl2node6);
        BinaryTreeNode<Integer> lvl1node5 = new BinaryTreeNode<>(5).withRightChild(lvl2node9);

        root = new BinaryTreeNode<>(2).withLeftChild(lvl1node7).withRightChild(lvl1node5);
    }

}

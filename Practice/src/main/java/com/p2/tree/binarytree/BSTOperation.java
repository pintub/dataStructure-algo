package com.p2.tree.binarytree;

public class BSTOperation {

    private BinaryTreeNode<Integer> root;

    public boolean isBST(BinaryTreeNode<Integer> root){
        return isBST(root, null);
    }

    private boolean isBST(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> prevNodeVisited){
        if(root == null)
            return true;

        boolean leftBool = isBST(root.getLeftChild(), prevNodeVisited);
        if(!leftBool)
            return false;

        if(prevNodeVisited != null && root.getData() < prevNodeVisited.getData())
            return false;
        prevNodeVisited = root;
        return isBST(root.getRightChild(), prevNodeVisited);
    }

    public static void main(String[] args) {
        BSTOperation bo = new BSTOperation();
        bo.createHardCodedBST_Correct();
        //bo.createHardCodedBST_InCorrect();

        BinaryTreeOperation bto = new BinaryTreeOperation();
        bto.inOrderTraversalUsingRecursion(bo.root);

        System.out.println("Is BST:" + bo.isBST(bo.root));
    }


    public void createHardCodedBST_Correct() {
        BinaryTreeNode<Integer> lvl2Leaf1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> lvl2Leaf4 = new BinaryTreeNode<>(4);

        BinaryTreeNode<Integer> lvl1node3 = new BinaryTreeNode<>(3, lvl2Leaf1, lvl2Leaf4);
        BinaryTreeNode<Integer> lvl1node8 = new BinaryTreeNode<>(8);

        root = new BinaryTreeNode<Integer>(6).withLeftChild(lvl1node3).withRightChild(lvl1node8);
    }

    public void createHardCodedBST_InCorrect() {
        BinaryTreeNode<Integer> lvl2Leaf1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> lvl2Leaf2 = new BinaryTreeNode<>(2);

        BinaryTreeNode<Integer> lvl1node2 = new BinaryTreeNode<>(3, lvl2Leaf1, lvl2Leaf2);
        BinaryTreeNode<Integer> lvl1node8 = new BinaryTreeNode<>(8);

        root = new BinaryTreeNode<>(6).withLeftChild(lvl1node2).withRightChild(lvl1node8);
    }
}

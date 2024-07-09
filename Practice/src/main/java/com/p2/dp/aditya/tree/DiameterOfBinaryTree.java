package com.p2.dp.aditya.tree;

import com.p2.tree.binarytree.*;

/**
 * Approach1
 *      piggyback on recursion of height() and diameter is max(1 + leftTreeHeight + rightTreeHeight) of any node (Type 3 recursion)
 * Approach2
 *      Diameter(node) = max(diameterLeftTree, diameterRightTree, 1 + leftTreeHeight + rightTreeHeight) (Type 2 + 3 recursion combination)
 */
public class DiameterOfBinaryTree {

    static class Height{
        int h;
    }

    //Approach 2
    int diameterOfBinaryTreeV2(BinaryTreeNode<Void> root) {
        return diameter(root, new Height());
    }

    private int diameter(BinaryTreeNode<Void> root, Height height) {
        if(root == null) {
            height.h = 0;
            return 0;
        }

        Height leftHeight = new Height();
        Height rightHeight = new Height();
        diameter = Math.max(
                    Math.max(
                        diameter(root.getLeftChild(), leftHeight),
                        diameter(root.getRightChild(), rightHeight)
                    ),
                1 + leftHeight.h + rightHeight.h
        );

        return diameter;
    }

    private int diameter = Integer.MIN_VALUE;

    //Approach 1
    int diameterOfBinaryTree(BinaryTreeNode<Void> root) {
        height(root);

        return diameter;
    }

    private int height(BinaryTreeNode<Void> root) {
        if(root == null) {
            return 0;
        }

        int leftTreeHeight = height(root.getLeftChild());
        int rightTreeHeight = height(root.getRightChild());

        diameter = Math.max(diameter, 1 + leftTreeHeight + rightTreeHeight);

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
}

package com.p2.dp.aditya.tree;

import com.p2.tree.binarytree.*;

/**
 * Type 3 recursion, Piggyback getOneDirectionalMaxSumAtAnyNode()(One directional max path sum of any branch)
 * i.e. At any node, actual recursion return = Max(nodeData, leftOneDirectionalSum + nodeData, rightOneDirectionalSum + nodeData)
 *
 * But At any node, max path sum = Max(nodeData, leftOneDirectionalSum + nodeData, rightOneDirectionalSum + nodeData, leftOneDirectionalSum + rightOneDirectionalSum + nodeData)
 *
 */
public class MaxPathSumAnyNodeToAnyNode {
    int maxPathSum = Integer.MIN_VALUE;

    int getOneDirectionalMaxSumAtAnyNode(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        int leftBranchMaxSumAtAnyNode = getOneDirectionalMaxSumAtAnyNode(root.getLeftChild());
        int rightBranchMaxSumAtAnyNode = getOneDirectionalMaxSumAtAnyNode(root.getRightChild());

        int oneDirectional = Math.max(
                Math.max(leftBranchMaxSumAtAnyNode + root.getData(), rightBranchMaxSumAtAnyNode + root.getData()),
                root.getData()
        );
        maxPathSum = Math.max(
                        oneDirectional,
                        leftBranchMaxSumAtAnyNode + rightBranchMaxSumAtAnyNode + root.getData()
                );

        return oneDirectional;
    }
}

package com.p2.disjointSet;

/**
 * Copied mostly from {@link com.p2.disjointSet.QuickUnionPlain}
 * By Weight or Size or Number-Of-Nodes-In-Tree
 *
 * Root stores -ve value of Tree Size
 */
public class QuickUnionByWeight {

    private int[] elementVsSetNameMap;

    //Each Node Pointing to It-self
    void makeSet(int[] elements) {
        elementVsSetNameMap = new int[elements.length];
        for(int element : elements) {
            elementVsSetNameMap[element] = -1;
        }
    }

    //Minimal CHANGE
    int find(int searchElement) {
        if(elementVsSetNameMap[searchElement] < 0) {//Root has -ve value
            return searchElement;
        }

        return find(elementVsSetNameMap[searchElement]);
    }

    void union(int root1, int root2) {
        if(root1 == root2) {//Same Set
            return;
        }

        //Root1 Bigger, So Make Root2 subtree of Root1. LOOK -ve value at root
        if (elementVsSetNameMap[root1] <= elementVsSetNameMap[root2])  {
            elementVsSetNameMap[root2] = root1;
            elementVsSetNameMap[root1] += elementVsSetNameMap[root2];
        } else {
            elementVsSetNameMap[root1] = root2;
            elementVsSetNameMap[root2] += elementVsSetNameMap[root1];
        }
    }
}

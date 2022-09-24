package com.p2.disjointSet;

/**
 * Copied mostly from {@link com.p2.disjointSet.QuickUnionPlain}
 * By Height or Rank
 *
 * Root stores -ve value of Height
 */
public class QuickUnionByHeight {

    private int[] elementVsSetNameMap;

    //Each Node Pointing to It-self
    void makeSet(int[] elements) {
        elementVsSetNameMap = new int[elements.length];
        for(int element : elements) {
            elementVsSetNameMap[element] = element;
        }
    }

    //Minimal CHANGE
    int find(int searchElement) {
        if(elementVsSetNameMap[searchElement] == -1) {//Root has -1
            return searchElement;
        }

        return find(elementVsSetNameMap[searchElement]);
    }

    void union(int root1, int root2) {
        if(root1 == root2) {//Same Set
            return;
        }

        //Root1 Bigger, So Make Root2 subtree of Root1
        if (elementVsSetNameMap[root1] == elementVsSetNameMap[root2])  {
            elementVsSetNameMap[root2] = root1;
            elementVsSetNameMap[root1] += -1;//Height increased by 1
        } else if (elementVsSetNameMap[root1] > elementVsSetNameMap[root2])  {
            elementVsSetNameMap[root2] = root1;
        } else {
            elementVsSetNameMap[root1] = root2;
        }
    }
}

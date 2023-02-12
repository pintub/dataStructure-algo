package com.p2.disjointSet;

/**
 * Amendment From {@link com.p2.disjointSet.QuickUnionByHeight}
 */
public class QuickUnionByHeightPathCompression {

    private int[] elementVsSetNameMap;

    //NO CHANGE from QuickUnionByHeight
    void makeSet(int[] elements) {

    }

    //Cache during 1st search
    int find(int searchElement) {
        if(elementVsSetNameMap[searchElement] < 0) {//Root has -ve value
            return searchElement;
        }

        int root = find(elementVsSetNameMap[searchElement]);
        elementVsSetNameMap[searchElement] = root;

        return root;
    }

    //NO CHANGE from QuickUnionByHeight
    void union(int root1, int root2) {
    }
}

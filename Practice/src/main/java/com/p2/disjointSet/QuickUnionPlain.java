package com.p2.disjointSet;

//SetName is Root of the Set
public class QuickUnionPlain {

    private int[] elementVsSetNameMap;

    //Each Node Pointing to It-self
    void makeSet(int[] elements) {
        elementVsSetNameMap = new int[elements.length];
        for(int element : elements) {
            elementVsSetNameMap[element] = element;
        }
    }

    //Traverse from Element till Root
    int find(int searchElement) {
        if(elementVsSetNameMap[searchElement] == searchElement) {//Root or Self-Pointer
            return searchElement;
        }

        return find(elementVsSetNameMap[searchElement]);
    }

    void union(int root1, int root2) {
        if(root1 == root2) {//Same Set
            return;
        }

        elementVsSetNameMap[root1] = root2;
    }
}

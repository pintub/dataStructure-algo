package com.p2.linkedlist;

/**
 * Created by I335831 on 4/9/2018.
 */
public class ListNode {
    private Object nodeValue;
    private ListNode nodeNext;

    public Object getNodeValue() {
        return nodeValue;
    }

    public ListNode(){
    }

    public ListNode(Object nodeValue, ListNode nodeNext) {
        this.nodeValue = nodeValue;
        this.nodeNext = nodeNext;
    }

    public void setNodeValue(Object nodeValue) {
        this.nodeValue = nodeValue;
    }

    public ListNode getNodeNext() {
        return nodeNext;
    }

    public void setNodeNext(ListNode nodeNext) {
        this.nodeNext = nodeNext;
    }

    public ListNode withNodeValue(Object nodeValue){
        this.nodeValue = nodeValue;
        return this;
    }

    public ListNode withNodeNext(ListNode nodeNext){
        this.nodeNext = nodeNext;
        return this;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "nodeValue=" + nodeValue +
                ", nodeNext=" + nodeNext +
                '}';
    }
}

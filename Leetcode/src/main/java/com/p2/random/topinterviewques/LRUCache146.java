package com.p2.random.topinterviewques;

import java.util.HashMap;
import java.util.Map;

/**
 * Below is Custom implementation of LinkedHashMap
 *
 * Thought Process:
 * 1st
 *      Reading the question, you will 2 about using 2 DS, 1st HashMap(key as key and value as <value, Order></value,> ,Then MinHeap(order as sorting_key)
 *      Time = O(logn)
*
 *  2nd
 *      As Question is LRU, which DS will give better time complexity in terms of deleting in between nodes and inserting at end , That is Double LL. we need not to store Order integer, as Double LL has natural ordering
 *      Node you will be tempted to use HashMap and DoubleLL
 *
 *  3rd
 *      Instead of duplicating objects in both DS use, same object in HashMap value and Double LL nodes
 */
public class LRUCache146 {

    private DoublyLinkedList dll;
    private Map<Integer, Node> keyVsNode;
    private int capacity;

    public LRUCache146(int c) {
        dll = new DoublyLinkedList();
        keyVsNode = new HashMap<>(capacity);
        this.capacity = c;
    }

    public int get(int key) {
        Node resultNode = keyVsNode.get(key);
        if(resultNode != null) {
            dll.deleteAnyWhere(resultNode);
            dll.insertAtEnd(resultNode);
        }

        return resultNode == null ? -1 : resultNode.val;
    }

    public void put(int key, int value) {
        Node resultNode = keyVsNode.get(key);
        //If Exists
        if(resultNode != null) {
            dll.deleteAnyWhere(resultNode);
            dll.insertAtEnd(resultNode);
            resultNode.val = value;

            return;
        }
        //If Not Exists And mapSize < capacity
        if(keyVsNode.size() < this.capacity) {
            Node newNode = dll.insertAtEnd(key, value);
            keyVsNode.put(key, newNode);

            return;
        }
        //If Not Exists And mapSize == capacity
        Node tempNode = dll.deleteAnyWhere(dll.head);
        keyVsNode.remove(tempNode.key);
        Node newNode = dll.insertAtEnd(key, value);
        keyVsNode.put(key, newNode);
    }

    class DoublyLinkedList {
        public Node head;
        public Node tail;

        public DoublyLinkedList() {
            //DO NOTHING
        }

        Node insertAtEnd(Node newNode) {
            if(head == null) {//Empty
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            return newNode;
        }

        Node insertAtEnd(int key, int val) {
            return insertAtEnd(new Node(key, val, null, null));
        }

        Node deleteAnyWhere(Node node) {
            if(head.next == null){//Only 1 node
                head = null;
                tail = null;
            } else if(node.prev == null) {//1st node
                head = head.next;
                head.prev = null;
                node.next = null;
                node.prev = null;
            } else if(node.next == null){//Last Node
                tail = tail.prev;
                tail.next = null;
                node.next = null;
                node.prev = null;
            } else {//Middle Node
                Node prevNode = node.prev;
                Node nextNode = node.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                node.next = null;
                node.prev = null;
            }

            return node;
        }
    }

    class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;

        public Node (int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        LRUCache146 lRUCache = new LRUCache146(2);
        lRUCache.put(1, 1);
        //System.out.println(lRUCache.cache);
        lRUCache.put(2, 2);
        //System.out.println(lRUCache.cache);
        lRUCache.get(1);
        //System.out.println(lRUCache.cache);
        lRUCache.put(3, 3);
        lRUCache.get(2);
        lRUCache.put(4, 4);
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
    }
}

package com.p2.random.topinterviewques;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Below is Custom implementation of LinkedHashMap
 *
 * Thought Process:
 * 1st
 *      Reading the question, you will 2 about using 2 DS, 1st HashMap(key as key and value as <value, Order></value,> ,Then MinHeap(order as sorting_key)
 *      Time = O(logn)
*
 *  2nd
 *      As Question is LRU, which DS will give better time complexity in terms of deleting in between nodes and inserting at end , That is Double LL and we need to store Order integer
 *      Node you will temp to use HashMap and DoubleLL
 *
 *  3rd
 *      Instead of duplicating objects in both DS use, same object in HashMap value and Double LL nodes
 */
public class LRUCache {

    private int capacity;
    Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    void deleteNodeFromDoubleLL(Node node) {//Param is existing Node
        if(cache.size() == 1) {//if size=1
            head= null;
            tail= null;
        } else if(node.prev == null) {//Delete 1st Node
            head = node.next;
            node.next = null;
            head.prev = null;
        } else if(node.next == null) {//Delete last Node
            tail = node.prev;
            node.prev = null;
            tail.next = null;
        } else {//Delete other Node
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    void addNodeToTailOfDoubleLL(Node newNode) {//Param is newNode
        if(head == null && tail == null) {//This is 1st node
            head = newNode;
            tail = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            newNode.next = null;
        }
    }

    public int get(int key) {
        int value = -1;
        if(cache.get(key) != null) {
            Node node = cache.get(key);
            value = node.value;

            deleteNodeFromDoubleLL(node);
            addNodeToTailOfDoubleLL(node);
        }

        return value;
    }

    public void put(int key, int value) {
        if(cache.get(key) != null) {
            Node node = cache.get(key);
            deleteNodeFromDoubleLL(node);

            Node newNode = new Node(key, value, null, null);
            cache.put(key, newNode);
            addNodeToTailOfDoubleLL(newNode);
        } else {
            if(capacity == cache.size()) {
                Node temp = head;
                deleteNodeFromDoubleLL(temp);
                cache.remove(temp.key);

                Node newNode = new Node(key, value, null, null);
                cache.put(key, newNode);
                addNodeToTailOfDoubleLL(newNode);
            } else {
                Node newNode = new Node(key, value, null, null);
                cache.put(key, newNode);
                addNodeToTailOfDoubleLL(newNode);
            }
        }
    }

    private static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node () {

        }

        public Node (int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        System.out.println(lRUCache.cache);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.cache);
        lRUCache.get(2);
        System.out.println(lRUCache.cache);
        lRUCache.put(1, 1);
        lRUCache.put(4, 1);
        lRUCache.get(2);
    }
}

package com.p2.trie;

public class TrieNode {
    TrieNode links[] = new TrieNode[26];
    boolean flag = false;

    public TrieNode() {
        //No OPS
    }

    //Utility Methods below
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    void set(char ch, TrieNode TrieNode) {
        links[ch - 'a'] = TrieNode;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

    //Below properties and method() count operations
    int countWord = 0;
    int countPrefix = 0;

    void increaseCountWord() {
        countWord++;
    }
    void increaseCountPrefix() {
        countPrefix++;
    }
    void reduceCountWord() {
        countWord--;
    }
    void reducePrefix() {
        countPrefix--;
    }
    int getCountWord() {
        return countWord;
    }
    int getCountPrefix() {
        return countPrefix;
    }
}

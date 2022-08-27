package com.p2.trie;

public class Trie {
    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //Inserts a word into the trie
    public static void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) { //Traverse the chars of Word
            if (!node.containsKey(word.charAt(i))) {
                node.set(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }

        node.setEnd();
    }

    //Returns if the word is in the trie
    public static boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }

        if (node.isEnd()) {
            return true;
        }

        return false;
    }

    //Returns if there is any word in the trie that starts with the given prefix
    public static boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }

        return true;
    }
}

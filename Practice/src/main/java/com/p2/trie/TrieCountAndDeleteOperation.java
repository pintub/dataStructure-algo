package com.p2.trie;

public class TrieCountAndDeleteOperation {

    private TrieNode root;

    TrieCountAndDeleteOperation() {
        root = new TrieNode();
    }


    //Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.set(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
            node.increaseCountPrefix();
        }
        node.increaseCountWord();
    }


    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                System.out.println("WHOAA!! Prefix doesn't exist!!");
                return 0;
            }
        }
        return node.getCountWord();
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.containsKey(prefix.charAt(i))) {
                node = node.get(prefix.charAt(i));
            } else {
                System.out.println("WHOAA!! Prefix doesn't exist!!");
                return 0;
            }
        }
        return node.getCountPrefix();
    }

    //Just Manipulates count, not deletes actual Nodes
    public void erase(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            } else {
                System.out.println("WHOAA!! Word doesn't exist!!");
                return;
            }
        }
        node.reduceCountWord();
    }
}

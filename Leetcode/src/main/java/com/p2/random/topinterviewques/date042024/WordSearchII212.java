package com.p2.random.topinterviewques.date042024;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII212 {

    /**
     * READ BELOW COMMENTS for smaller optimisations
     * - No need prefix string in recursion, Trie leaf node to keep the word
     * - No need of hashset, as Trie if once found nullifies the stored word
     */
    private final int[][] neighborDirections = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
        int boardSize = board.length * board[0].length;
        List<String> result = new ArrayList<>();

        TrieNode root = buildTrie(boardSize, words);

        if(root == null) {
            return new ArrayList<>();
        }

        for(int row =0; row < board.length; row++) {
            for(int col =0; col < board[0].length; col++) {
                dfs(row, col, board, root, result);
            }
        }

        return result;
    }

    void dfs(int row, int col, char[][] board, TrieNode root, List<String> result) {
        if(root.word != null) {
            result.add(root.word);
            root.word = null;//
        }

        if(row >= board.length || row < 0 || col < 0 || col >= board[0].length) {
            return;
        }

        char currentChar = board[row][col];

        if(currentChar == 'X') {
            return;
        }

        if(!root.charExists(currentChar)) {
            return;
        }

        board[row][col] = 'X';
        //root.charExists(board[row][col])
        for(int[] neighborDirection : neighborDirections) {
            dfs(row + neighborDirection[0], col + neighborDirection[1], board, root.getChar(currentChar), result);
        }
        board[row][col] = currentChar;
    }

    TrieNode buildTrie(int boardSize, String[] words) {
        TrieNode root = null;

        for(String word : words) {
            if(word.length() > boardSize) {//TODO check this searching as well
                continue;
            }
            if(root == null) {
                root = new TrieNode();
            }
            TrieNode temp = root;

            for(int idx= 0; idx <= word.length() - 1; idx++) {
                char c = word.charAt(idx);
                if(!temp.charExists(c)) {
                    temp.setChar(c);
                }

                temp = temp.getChar(c);
            }
            temp.word = word;
        }

        return root;

    }


    static class TrieNode {
        public TrieNode[] chArray;
        public String word;

        public TrieNode() {
            chArray = new TrieNode[26];
        }

        public void setChar(char c) {
            chArray[c - 'a'] = new TrieNode();
        }

        public TrieNode getChar(char c) {
            return chArray[c - 'a'];
        }

        public boolean charExists(char c) {
            return chArray[c - 'a'] != null;
        }
    }
}

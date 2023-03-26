package year2k21.common.pattern.trie.date23032023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII212 {

    private static List<int[]> neighborDirections = Arrays.asList(new int[]{-1, 0}, new int[]{0, -1}, new int[]{0, 1}, new int[]{1, 0});

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        Set<String> foundWords = new HashSet<>();
        for(int row = 0; row < board.length; row++) {
            for(int column = 0; column < board[0].length; column++) {
                dfs(row, column, board, root, "", foundWords);
            }
        }

        return new ArrayList<>(foundWords);
    }

    private void dfs(int row, int column, final char[][] board, TrieNode root, String prefix, Set<String> foundWords) {
        if(root.isWord) {
            foundWords.add(prefix);
        }

        if(row < 0 || row > board.length - 1 || column < 0 || column > board[0].length - 1){
            return;
        }

        if(root.isLeafNode()) {
            return;
        }

        char currentChar = board[row][column];
        if(currentChar == '/') {//Handle Loop, Just like Visited DS would have done
            return;
        }

        if(root.links[currentChar - 'a'] == null) {
            return;
        }

        board[row][column] = '/';

        for(int[] neighborDirection : neighborDirections) {
            dfs(row + neighborDirection[0], column + neighborDirection[1], board, root.links[currentChar - 'a'], prefix + currentChar, foundWords);
        }

        board[row][column] = currentChar;

    }

    private TrieNode buildTrie(String[] words) {//O(n * Len)
        TrieNode root = new TrieNode();

        for(String word : words) {
            TrieNode temp = root;
            for(int index = 0; index < word.length(); index++) {//Insert each word to Trie
                char currentChar = word.charAt(index);
                if(temp.links[currentChar - 'a'] == null) {
                    temp.links[currentChar - 'a'] = new TrieNode();
                }
                temp = temp.links[currentChar - 'a'];
            }
            temp.isWord = true;
        }

        return root;
    }

    private static class TrieNode {
        public TrieNode[] links = new TrieNode[26];
        public boolean isWord = false;

        public boolean isLeafNode() {
            for(TrieNode link : links) {
                if(link != null)
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        WordSearchII212 sol = new WordSearchII212();
        System.out.println(sol.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"}));//[oath, eat]
        System.out.println(sol.findWords(new char[][]{{'a','b'},{'c','d'}}, new String[]{"abcb"}));//[]
    }
}

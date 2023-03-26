package year2k21.common.pattern.trie.date23032023;

public class LongestWordInDictionary720 {

    /**
     * Total //2 * O(n * Len)
     */
    public String longestWord(String[] words) {
        String longestWord = "";

        TrieNode root = buildTrie(words);
        for(String word : words) {//O(n * Len)
            TrieNode temp = root;
            boolean isGoodWord = true;
            for(int index = 0; index < word.length(); index++) {
                char currentChar = word.charAt(index);
                if(temp.links[currentChar - 'a'] == null || !temp.links[currentChar - 'a'].isWord) {
                    isGoodWord = false;
                    break;
                }
                temp = temp.links[currentChar - 'a'];
            }
            if(isGoodWord && ((word.length() > longestWord.length()) ||
                    (word.length() == longestWord.length() && word.compareTo(longestWord) < 0))) {
                longestWord = word;
            }
        }
        return longestWord;
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
    }

    public static void main(String[] args) {
        LongestWordInDictionary720 sol = new LongestWordInDictionary720();
        System.out.println(sol.longestWord(new String[]{"w","wo","wor","world","worl"}).equals("world"));
        System.out.println(sol.longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"}).equals("apple"));
    }
}

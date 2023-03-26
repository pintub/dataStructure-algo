package year2k21.common.pattern.trie.date23032023;

/**
 * Or use array of 27 size, with one additional place for "."
 */
public class DesignAddAndSearchWordsDataStructure211 {

    private static class WordDictionary {

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode temp = root;
            for (int idx = 0; idx < word.length(); idx++) {
                char currentChar = word.charAt(idx);
                if (temp.links[currentChar - 'a'] == null) {
                    temp.links[currentChar - 'a'] = new TrieNode();
                }

                temp = temp.links[currentChar - 'a'];
            }

            temp.isWord = true;
        }

        public boolean search(String word) {
            TrieNode temp = root;
            return search(temp, word, 0);
        }

        private boolean search(TrieNode root, final String word, int wordIndex) {
            if (wordIndex == word.length()) {
                return root.isWord ? true : false;
            }

            char currentChar = word.charAt(wordIndex);
            if (currentChar != '.') {
                if (root.links[currentChar - 'a'] == null) {
                    return false;
                }
                return search(root.links[currentChar - 'a'], word, wordIndex + 1);
            } else {//If "." Present
                for (TrieNode link : root.links) {//Get all not-null links
                    if (link != null) {
                        if (search(link, word, wordIndex + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }

    private static class TrieNode {
        public TrieNode[] links = new TrieNode[26];
        public boolean isWord = false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
package year2k21.common.pattern.binaryoperation;

/**
 * Couldn't solve
 *
 * Naive solution
 *      For each word, check if other words have common letter, If not take product
 *      O(n*n*word1Len*word2Len)
 * Trick here is how to quickly check if 2 words have common letter or not
 *      for each word create a num whose binary representation 101 means c is present, b is not present, a is present
 *      If AND two binary represntation of any 2 strings =  all-0s', no common letter
 *      O(n*n)
 */
public class MaximumProductOfWordLengths318 {

    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        int wordsSize = words.length;

        int[] wordVsBinaryRepMap = new int[wordsSize];//Each value in array is binary representation 101 means c is present, b not present, a is present
        for (int i = 0; i < wordsSize; i++) {
            String currentWord = words[i];
            for (int j = 0; j < currentWord.length(); j++) {
                wordVsBinaryRepMap[i] = wordVsBinaryRepMap[i] | 1 << (currentWord.charAt(j) - 'a');//If already present, Keep 1. Not first time encountered, keep 1
            }
        }

        //Traverse and check if any common chars
        int maxProduct = 0;
        for (int i = 0; i < wordsSize; i++)
            for (int j = i + 1; j < wordsSize; j++) {
                if ((wordVsBinaryRepMap[i] & wordVsBinaryRepMap[j]) == 0) {//No common chars
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }

        return maxProduct;
    }
}

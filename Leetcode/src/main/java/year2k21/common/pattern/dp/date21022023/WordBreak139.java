package year2k21.common.pattern.dp.date21022023;

import java.util.List;

/**
 * CanConstruct problem
 * instead of below complicated memo[] , you can use Map<subString, boolean>
 */
public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];//All null

        return wordBreak(0, s, wordDict, memo);
    }

    private boolean wordBreak(int index, String s, List<String> wordDict, Boolean[] memo) {
        if(memo[index] != null) {
            return memo[index];
        }

        if (index == s.length()) {
            memo[index] = true;
            return true;
        }

        for (String word : wordDict) {
            if (s.substring(index).startsWith(word)) {
                if (wordBreak(index + word.length(), s, wordDict, memo)) {
                    memo[index] =  true;
                    return true;
                }
            }
        }

        memo[index] =  false;
        return false;
    }
}

package year2k21.common.pattern.general.string;

import java.util.*;

/**
 * Repeat of Sliding Window
 * Refer other Solution,which is better, you can jump the left directly to lastOccurrenceIndex + 1 {@link com.p2.slidiing.window.variable.LongestSubstringWithoutRepeatingCharacters3}
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String str) {
        int left = 0, right = 0;
        Map<Character, Integer> charVsLatestIndex = new HashMap<>();
        int maxWindowSize = 0;

        while (right < str.length()) {
            char rightIdxChar = str.charAt(right);
            if(!charVsLatestIndex.containsKey(rightIdxChar) || charVsLatestIndex.get(rightIdxChar) == -1) {//If valid, char has not occurred
                maxWindowSize = Math.max(maxWindowSize, right - left + 1);
                charVsLatestIndex.put(rightIdxChar, right);
                right++;
            } else {//Invalid window, Char already exists, move the left pointer to make window valid + move Right
                int latestOccurrenceIndex = charVsLatestIndex.get(rightIdxChar);
                while(left != latestOccurrenceIndex + 1) {
                    charVsLatestIndex.put(str.charAt(left), -1);
                    left++;
                }
                charVsLatestIndex.put(rightIdxChar, right);
                right++;
            }
        }

        return maxWindowSize;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("tmmzuxt"));
    }
}

package com.p2.slidiing.window.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Memo DS : charVsLastIndexMap
 *
 * **Concept***
 *      No need to increase left pointer only by one, instead if char is met twice, get the last index and jump left pointer to lastIndex + 1
 *      This concept needs to amend "isValidWindow" computation
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String str) {
        int left = 0, right = 0;
        Map<Character, Integer> charVsLatestIndexMap = new HashMap<>();

        int maxLongestSubStrLen = 0;
        boolean isValidWindow = true;

        while (right < str.length()) {
            char rightPointerChar = str.charAt(right);
            isValidWindow = !(charVsLatestIndexMap.get(rightPointerChar) != null &&
                    charVsLatestIndexMap.get(rightPointerChar) >= left);//Meeting the 2nd time
            if(isValidWindow) {
                charVsLatestIndexMap.put(rightPointerChar, right);
                maxLongestSubStrLen = Math.max(maxLongestSubStrLen, right - left + 1);
                ++right;
            } else {
                left = charVsLatestIndexMap.get(rightPointerChar) + 1;
                charVsLatestIndexMap.put(rightPointerChar, right);
                maxLongestSubStrLen = Math.max(maxLongestSubStrLen, right - left + 1);
                ++right;
            }
        }

        return maxLongestSubStrLen;
    }

    public static void main(String[] args) {
        /*System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("a") == 1);
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("") == 0);
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("dvdf") == 3);*/
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("abba") == 2);
    }
}

package com.p2.slidiing.window.variable;

import java.util.*;

/**
 * Memo DS : charVsLastIndexMap
 * Concept
 *      No need to increase left pointer only by one, instead if char is met twice, get the last index and jump left pointer to lastIndex + 1
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String str) {
        int left = 0, right = 0;
        Map<Character, Integer> charVsFreqMap = new HashMap<>();

        int maxLongestSubStrLen = 0;
        boolean isValidWindow = true;

        while (right < str.length()) {
            char rightPointerChar = str.charAt(right);
            if(isValidWindow) {
                if(charVsFreqMap.get(rightPointerChar) != null &&
                        charVsFreqMap.get(rightPointerChar) >= left) {//Meeting the 2nd time
                    isValidWindow = false;
                    continue;
                } else {
                    charVsFreqMap.put(rightPointerChar, right);
                    maxLongestSubStrLen = Math.max(maxLongestSubStrLen, right - left + 1);
                    ++right;
                }
            } else {
                left = charVsFreqMap.get(rightPointerChar) + 1;
                charVsFreqMap.put(rightPointerChar, right);
                maxLongestSubStrLen = Math.max(maxLongestSubStrLen, right - left + 1);
                isValidWindow=true;
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

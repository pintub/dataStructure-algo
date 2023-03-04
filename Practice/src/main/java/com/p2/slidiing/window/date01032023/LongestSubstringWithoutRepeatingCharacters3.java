package com.p2.slidiing.window.date01032023;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String str) {

        int left = 0, right = 0;

        //Memo
        Map<Character, Integer> charVsLastIndexMap = new HashMap<>();
        //Result
        int maxLength = 0;

        while (right < str.length()) {
            char rightPtrChar = str.charAt(right);
            boolean isValidWindow = charVsLastIndexMap.get(rightPtrChar) == null || charVsLastIndexMap.get(rightPtrChar) < left;//Visited 1st time

            if (isValidWindow) {
                maxLength = Math.max(maxLength, right - left + 1);
                charVsLastIndexMap.put(rightPtrChar, right);
                right++;
            } else { //Move Left Ptr and fix window
                left = charVsLastIndexMap.get(rightPtrChar) + 1;
                //charVsLastIndexMap.remove(rightPtrChar);
                maxLength = Math.max(maxLength, right - left + 1);
                charVsLastIndexMap.put(rightPtrChar, right);
                right++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 sol = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(sol.lengthOfLongestSubstring("a") == 1);
        System.out.println(sol.lengthOfLongestSubstring("") == 0);
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(sol.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(sol.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(sol.lengthOfLongestSubstring("dvdf") == 3);
        System.out.println(sol.lengthOfLongestSubstring("abba") == 2);
    }
}

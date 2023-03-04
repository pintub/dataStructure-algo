package com.p2.slidiing.window.date01032023;

import java.util.HashMap;
import java.util.Map;

/**
 * Memo DS: charVsFreqMap + Counter variable
 *
 * Counter not affected when count goes -ve. This is different than Count Anagrams
 */
public class MinimumWindowSubstring76 {

    public String minWindow(String s, String t) {

        int left = 0, right = 0;

        //Memo
        Map<Character, Integer> charVsCountMap = new HashMap<>();
        for(int count = 0; count < t.length(); count++) {
            charVsCountMap.compute(t.charAt(count), (existingKey, existingValue) -> existingValue == null ? 1 : existingValue + 1);
        }
        int counter = charVsCountMap.size();

        //Result
        String minWindowString = "";

        while (right < s.length()) {
            char rightPtrChar = s.charAt(right);

            if(charVsCountMap.get(rightPtrChar) == null) {
                ++right;
                continue;
            }
            int rightPtrCharCount = charVsCountMap.get(rightPtrChar);
            if(rightPtrCharCount == 1) {
                --counter;
            }
            charVsCountMap.put(rightPtrChar, rightPtrCharCount - 1);
            boolean isValidWindow = counter == 0;

            if(!isValidWindow) {
                ++right;
            } else {//Valid, Shift left to minimize valid window until it becomes invalid again
                while (counter == 0) {
                    minWindowString = right - left + 1 < minWindowString.length() || "".equals(minWindowString) ? s.substring(left, right + 1): minWindowString;
                    char leftPtrChar = s.charAt(left);
                    if (charVsCountMap.get(leftPtrChar) == null) {
                        ++left;
                    } else {
                        int leftPtrCharCount = charVsCountMap.get(leftPtrChar);
                        if(leftPtrCharCount == 0)
                            ++counter;
                        charVsCountMap.put(leftPtrChar, leftPtrCharCount + 1);
                        ++left;
                    }
                }
                ++right;
            }
        }
        return minWindowString;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring76 sol = new MinimumWindowSubstring76();
        System.out.println("BANC".equals(sol.minWindow("ADOBECODEBANC", "ABC")));
        System.out.println("".equals(sol.minWindow("a", "aa")));
        System.out.println("a".equals(sol.minWindow("a", "a")));
        System.out.println("BAANC".equals(sol.minWindow("ADOBECODEBAANC", "ABC")));

    }

}

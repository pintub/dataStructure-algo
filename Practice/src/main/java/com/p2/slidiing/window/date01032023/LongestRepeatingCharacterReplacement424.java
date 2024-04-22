package com.p2.slidiing.window.date01032023;

import java.util.HashMap;
import java.util.Map;

/**
* NOT  DP, as it looks
* 
* Is Valid window () -> When you are on a right-ptr character, if |current window| - |that right char's freq for current-valid-window | <= k, 
* i.e. you have k different letters(other than that right char in that window, but they can be replaced with right-char),
* Then you are still in valid window
*
* if non-right-letter char count increases than k, the window is invalid, move left char, update freqMap
**/
public class LongestRepeatingCharacterReplacement424 {

    public int characterReplacement(String s, int k) {

        int left = 0, right = 0;

        //Memorization
        Map<Character, Integer> charVsCountMap = new HashMap<>();
        int maxFrequency = 0;
        //Result
        int result = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            Integer rightCount = charVsCountMap.getOrDefault(rightChar, 0);
            charVsCountMap.put(rightChar, rightCount + 1);
            if(maxFrequency <= rightCount + 1){
                maxFrequency = rightCount+1;
            }

            if(right - left + 1 - maxFrequency <= k) {//valid window. windowSize - maxFrequency = Rest of Char Count is still less that k
                result = Math.max(result, right - left + 1);
                ++right;
            } else {//Move left Pointer and fix window
                while (right - left + 1 - maxFrequency > k) {//Till it is invalid
                    char leftChar = s.charAt(left);
                    Integer leftCount = charVsCountMap.getOrDefault(leftChar, 0);
                    charVsCountMap.put(leftChar, leftCount - 1);
                    maxFrequency = getMaxFreq(charVsCountMap);
                    ++left;
                }
                result = Math.max(result, right - left + 1);
                ++right;
            }
        }

        return result;
    }

    private int getMaxFreq(Map<Character, Integer> charVsCountMap) {
        int temp = 0;
        for(Map.Entry<Character, Integer> entry : charVsCountMap.entrySet()){
            temp = Math.max(temp, entry.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement424 sol = new LongestRepeatingCharacterReplacement424();
        System.out.println(sol.characterReplacement("AABABBA", 1) == 4);
    }


}

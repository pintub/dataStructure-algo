package com.p2.slidiing.window.variable;

import java.util.*;

/**
 * Memorization DS: charVsFreqMap
 */
public class LongestKUniqueCharactersSubString {

    public int longestKSubStr(String str, int kDistinctChars) {
        int left = 0, right = 0;
        Map<Character, Integer> charVsFreqMap = new HashMap<>(kDistinctChars + 1);

        int maxWindowSize = -1;

        while (right < str.length()) {

            char charAtRightPointer = str.charAt(right);

            if(charVsFreqMap.size() < kDistinctChars) {
                int rightPointerCharFreq = charVsFreqMap.getOrDefault(charAtRightPointer, 0);
                charVsFreqMap.put(charAtRightPointer, rightPointerCharFreq + 1);
                right++;
            } else if(charVsFreqMap.size() == kDistinctChars) {
                int freq = charVsFreqMap.getOrDefault(charAtRightPointer, 0);
                charVsFreqMap.put(charAtRightPointer, freq + 1);
                maxWindowSize = Math.max(maxWindowSize, right - left + 1);
                right++; //Increasing window Size to make window invalid
            } else if(charVsFreqMap.size() > kDistinctChars) {//Invalid Window, Make it valid by shifting left pointer only
                while (charVsFreqMap.size() != kDistinctChars) {
                    int leftPointerCharFreq = charVsFreqMap.get(str.charAt(left));
                    if(leftPointerCharFreq == 1) { //If freq is getting 1 to 0
                        charVsFreqMap.remove(charAtRightPointer);
                    } else {
                        charVsFreqMap.put(charAtRightPointer, leftPointerCharFreq - 1);
                    }
                    left++;
                }
            }
        }

        return maxWindowSize;
    }

    public static void main(String[] args) {
        System.out.println(new LongestKUniqueCharactersSubString().longestKSubStr("aabacbebebe", 3) == 7);
        System.out.println(new LongestKUniqueCharactersSubString().longestKSubStr("aaaa", 2) == -1);
    }
}

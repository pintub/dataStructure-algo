package com.p2.slidiing.window.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Str = “aabbcc”, k = 2
 * Output = 4, {“aabb” , “bbcc”}
 *
 * Memorization DS: charVsFreqMap
 */
public class LongestKUniqueCharactersSubString {

    public int longestKSubStr(String str, int kDistinctChars) {
        int left = 0, right = 0;

        Map<Character, Integer> charVsFreqMap = new HashMap<>(kDistinctChars + 1);

        int maxWindowSize = 0;

        while (right < str.length()) {

            char charAtRightPointer = str.charAt(right);
            int rightPointerCharFreq = charVsFreqMap.getOrDefault(charAtRightPointer, 0);
            charVsFreqMap.put(charAtRightPointer, rightPointerCharFreq + 1);

            if(charVsFreqMap.size() < kDistinctChars) {
                right++;
            } else if(charVsFreqMap.size() == kDistinctChars) {//Valid Window
                maxWindowSize = Math.max(maxWindowSize, right - left + 1);
                right++; //Increasing window Size , it might create valid or invalid window
            } else if(charVsFreqMap.size() > kDistinctChars) {//Invalid Window, Make it valid by shifting left pointer only
                while (charVsFreqMap.size() != kDistinctChars) {
                    char charAtLeftPointer = str.charAt(left);
                    int leftPointerCharFreq = charVsFreqMap.get(charAtLeftPointer);
                    if(leftPointerCharFreq == 1) { //If freq is getting 1 to 0
                        charVsFreqMap.remove(charAtLeftPointer);
                    } else {
                        charVsFreqMap.put(charAtLeftPointer, leftPointerCharFreq - 1);
                    }
                    left++;
                }
                maxWindowSize = Math.max(maxWindowSize, right - left + 1);
                right++;
            }
        }

        return maxWindowSize;
    }

    public static void main(String[] args) {
        LongestKUniqueCharactersSubString sol = new LongestKUniqueCharactersSubString();
        System.out.println(sol.longestKSubStr("aabacbebebe", 3) == 7);
        System.out.println(sol.longestKSubStr("aaaa", 2) == 0);
        System.out.println(sol.longestKSubStr("aabbcc", 1) == 2);
        System.out.println(sol.longestKSubStr("aabbcc", 2) == 4);
    }
}

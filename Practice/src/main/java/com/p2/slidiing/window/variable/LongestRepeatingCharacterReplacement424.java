package com.p2.slidiing.window.variable;

import java.util.*;

/**
 * Thought DP , but it's sliding window
 */
public class LongestRepeatingCharacterReplacement424 {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, end = 0, mostFreqLetterCount = 0, maxLength = 0;

        while (end < len) {
            int temp = ++count[s.charAt(end) - 'A'];
            mostFreqLetterCount = Math.max(mostFreqLetterCount, temp);//mostFreqLetterCount not changed when window shifted?? https://leetcode.com/problems/longest-repeating-character-replacement/discuss/358879/Java-Solution-Explained-and-Easy-to-Understand-for-Interviews/1314305
            while (end - start + 1 - mostFreqLetterCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);

            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        //System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("ABAB", 2) == 4);
        //System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("ACABABBAB", 2) == 6) ;
        //System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("ABABABBAB", 2) == 6) ;
        //System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("ACABABAAA", 2) == 7) ;
        //System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("AAAB", 0) == 3) ;
        //System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("AABABBA", 1) == 4) ;
        System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("AABCCACC", 2) == 4) ;
    }
}

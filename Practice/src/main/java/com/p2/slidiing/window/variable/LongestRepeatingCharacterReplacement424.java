package com.p2.slidiing.window.variable;

/**
 * Example 1:
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Example 2:
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 * Thought DP , but it's sliding window
 * Copied code
 *
 * Read for template solution {{@link com.p2.slidiing.window.date01032023.LongestRepeatingCharacterReplacement424}}
 */
public class LongestRepeatingCharacterReplacement424 {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int left = 0, right = 0, mostFreqLetterCount = 0, maxLength = 0;

        while (right < len) {
            int temp = ++count[s.charAt(right) - 'A'];
            mostFreqLetterCount = Math.max(mostFreqLetterCount, temp);
            while (right - left + 1 - mostFreqLetterCount > k) {//mostFreqLetterCount not decreased when window shifted?? https://leetcode.com/problems/longest-repeating-character-replacement/discuss/358879/Java-Solution-Explained-and-Easy-to-Understand-for-Interviews/1314305
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("ABAB", 2) == 4);
        System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("ACABABBAB", 2) == 6) ;
        System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("ABABABBAB", 2) == 6) ;
        System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("ACABABAAA", 2) == 7) ;
        System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("AAAB", 0) == 3) ;
        System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("AABABBA", 1) == 4) ;
        System.out.println(new LongestRepeatingCharacterReplacement424().characterReplacement("AABCCACC", 2) == 6) ;
    }
}

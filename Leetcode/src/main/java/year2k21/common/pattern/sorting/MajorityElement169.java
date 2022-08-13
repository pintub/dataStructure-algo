package year2k21.common.pattern.sorting;

/**
 * Ques: Find elem with count > n/2
 *
 * Definitely not easy to time = O(n) and space = o(1)
 * Boyer-Moore Voting Algorithm(https://leetcode.com/problems/majority-element/solution/)
 * This problem vs find number with the highest frequency
 *
 * Start from left to right
 * One count var is needed
 * Assume, the 1st element as majority elem, for each occurrence add +1 , for other elem -1. When reaches count=0, assume next elem as majority elem and repeat
 * The last assumed elem is answer
 *
 * Example: (Note, pipe is wen count=0 is reached)
 * [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 5, 5, 5, 5], Here ans = 5
 */
public class MajorityElement169 {
}

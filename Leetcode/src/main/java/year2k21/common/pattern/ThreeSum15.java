package year2k21.common.pattern;

import java.util.*;
import java.util.stream.*;

/**
 * Let's try map solution similar to {@link year2k21.common.pattern.TwoSum1}
 *
 * Question similar, answer is also similar https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
 *
 * Didn't solve
 * Solution Approach
 *      Sort Array O(nlogn)
 *      Traverse left to right, Thinking each element as potential 1st of three elements (n times * O(n))
 *          Do 2-sum operation on sorted array using 2 pointer
 *
 * Time complexity = O(n^2)
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }
}

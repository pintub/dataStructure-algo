package year2k21.common.pattern.graph.date16082022;

import java.util.*;
import java.util.stream.*;

/**
 * 1st of All, this is not DP
 *
 * Max nodes in any Graph component
 *
 * Optimised solution from LeetCode, No DFS or visited DS . Check for only next numbers in one direction
 * https://leetcode.com/problems/longest-consecutive-sequence/discuss/41057/Simple-O(n)-with-Explanation-Just-walk-each-streak/39195
 * public int longestConsecutive(int[] nums) {//No Graph, No shit
 *             Set<Integer> set = new HashSet<>();
 *             for(int n : nums) {
 *                 set.add(n);
 *             }
 *             int best = 0;
 *             for(int n : set) {
 *                 if(!set.contains(n - 1)) {  // check consecutive sequence only in one direction, i.e. if n-1 has existed, we would have already calculated count of consecutive sequence
 *                     int m = n + 1;
 *                     while(set.contains(m)) {
 *                         m++;
 *                     }
 *                     best = Math.max(best, m - n);
 *                 }
 *             }
 *             return best;
 *         }
 */
public class LongestConsecutiveSequence128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> nodeVsVisitedMap = new HashMap<>(nums.length);

        int maxCount = 0;

        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for(int num : nums) {
            if(nodeVsVisitedMap.get(num) != null && nodeVsVisitedMap.get(num)) {//Visited
                continue;
            }

            int count = dfs(num, nodeVsVisitedMap, numSet);
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    private int dfs(int num, Map<Integer, Boolean> nodeVsVisitedMap, Set<Integer> numSet) {
        try {
            if(nodeVsVisitedMap.get(num) != null && nodeVsVisitedMap.get(num)) {//Visited
                return 0;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {//Index invalid
            return 0;
        }

        if(!numSet.contains(num)) {
            return 0;
        }

        nodeVsVisitedMap.put(num, true);

        int count = 1;//Considering current num it-self

        //2 Possible neighbor of number
        count += dfs(num - 1, nodeVsVisitedMap, numSet);
        count += dfs(num + 1, nodeVsVisitedMap, numSet);

        return count;
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {100,4,200,1,3,2};//[1, 2, 3, 4]. Therefore its length is 4.
        int[] nums = new int[] {0,3,7,2,5,8,4,6,0,1};

        System.out.println(new LongestConsecutiveSequence128().longestConsecutive(nums));
    }
}

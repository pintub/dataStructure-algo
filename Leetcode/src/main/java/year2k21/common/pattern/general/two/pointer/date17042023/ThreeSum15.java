package year2k21.common.pattern.general.two.pointer.date17042023;

import year2k21.common.pattern.general.two.pointer.TwoSum1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * * Let's try map solution similar to {@link TwoSum1}
 *  *
 *  * Question similar, answer is also similar https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
 *  *
 *  * Didn't solve
 *  * Solution Approach
 *  *      Sort Array O(nlogn)
 *  *      Traverse left to right, Thinking each element as potential 1st of three elements (n times * O(n))
 *  *          Do 2-sum operation on sorted array using 2 pointer
 *  *
 *  * Time complexity = O(nlogn) + O(n^2) = O(n^2)
 *  *
 * "OR"
 *  Check For Non-Set solution or Squeezing solution
 *  https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;//Notice This
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0)
                    res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));//Notice This, Keep searching for more triplets with same "i"
                else if (sum > 0)
                    high--;
                else
                    low++;
            }

        }
        return new ArrayList<>(res);

    }

    public static void main(String[] args) {
        ThreeSum15 sol = new ThreeSum15();
        /*System.out.println(sol.threeSum(new int[]{-1,0,1,2,-1,-4}));//[[-1, -1, 2], [-1, 0, 1]]
        System.out.println(sol.threeSum(new int[]{0,1,1}));//[]
        System.out.println(sol.threeSum(new int[]{0,0,0}));//[0,0,0]
        System.out.println(sol.threeSum(new int[]{-3,-2,-1,2,3,4}));//[0,0,0]*/
        System.out.println(sol.threeSum(new int[]{1, -1, -1, 0}));

    }
}

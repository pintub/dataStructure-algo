package year2k21.common.pattern.general.two.pointer;

import java.util.*;

/**
 * Similar to {@link ThreeSum15}
 */
public class ThreeSumClosest16 {

    public int threeSumClosest(int[] nums, int targetSum) {
        Arrays.sort(nums);//O(n*logn)

        int closestSum = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++) {//O(n^2)
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {//O(n)
                int currentSum = nums[i] + nums[low] + nums[high];
                if(currentSum == targetSum) {
                    return targetSum;
                }

                closestSum = Math.abs(currentSum - targetSum) < Math.abs(closestSum - targetSum) ?
                        currentSum : closestSum;
                if(currentSum < targetSum) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest16().threeSumClosest(new int[]{0,0,0}, 1));
    }
}

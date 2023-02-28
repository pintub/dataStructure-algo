package year2k21.common.pattern.dp.date21022023;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/divide-the-array-in-k-segments-such-that-the-sum-of-minimums-is-maximized/
 */
public class DivideArrayInKSegmentsThatSumOfMinimumsIsMaximizedGFG {

    //K segments => k-1 partition
    public int solve(int[] nums, int k) {
        int[][] memo = new int[nums.length + 1][k];
        for(int[] row : memo)
            Arrays.fill(row,-1);

        return solve(0, nums, k-1, memo);
    }

    private int solve(int index, int[] nums, int k, int[][] memo) {

        if(memo[index][k] != -1)
            return memo[index][k];

        if(k == 0 && index == nums.length) {
            memo[index][k] = 0;
            return 0;
        }

        if(k == 0) {
            memo[index][k] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }

        if(index == nums.length) {
            memo[index][k] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }

        int temp = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int partition=index; partition <= nums.length - 1; partition++) {
            min = Math.min(min, nums[index]);
            temp = Math.max(temp, solve(partition + 1, nums, k-1, memo) + min);
        }

        memo[index][k] = temp;

        return temp;
    }

    public static void main(String[] args) {
        DivideArrayInKSegmentsThatSumOfMinimumsIsMaximizedGFG sol = new DivideArrayInKSegmentsThatSumOfMinimumsIsMaximizedGFG();
        System.out.println(sol.solve(new int[]{5, 7, 4, 2, 8, 1, 6}, 3));//13
        System.out.println(sol.solve(new int[]{6, 5, 3, 8, 9, 10, 4, 7, 10}, 4));//26
    }
}

package year2k21.common.pattern.general.two.pointer.date17042023;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/918/
 */
public class ThreeSumSmaller259_Premium {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            int newTargetSum = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int tempSum = nums[j] + nums[k];
                if (tempSum >= newTargetSum) {
                    --k;
                } else {
                    count += k - j;//THIS WAS TRICKYY!!
                    ++j;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ThreeSumSmaller259_Premium sol = new ThreeSumSmaller259_Premium();
        System.out.println(sol.threeSumSmaller(new int[]{-2,0,1,3}, 2));//2
        System.out.println(sol.threeSumSmaller(new int[]{-2,0,-1,3}, 2));//3
    }
}

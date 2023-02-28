package year2k21.common.pattern.dp.date21022023;

import java.util.Arrays;

public class CombinationSumIV377 {

    //Count target Sum, but duplicacy needed, So Approach1
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target+1];
        Arrays.fill(memo, -1);

        return combinationSum4(nums, target, memo);
    }

    private int combinationSum4(int[] nums, int target, int[] memo) {//TODO use memo
        if(memo[target] != -1) {
            return memo[target];
        }
        if(target == 0) {
            memo[target] = 1;
            return 1;
        }

        int tempCount = 0;
        for(int num : nums) {
            if(target - num >= 0) {
                tempCount += combinationSum4(nums, target - num, memo);
            }
        }

        memo[target] = tempCount;
        return memo[target];
    }
}

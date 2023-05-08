package com.p2.random.topinterviewques;

public class MaximumProductSubarray152 {
    int result = Integer.MIN_VALUE;

    public int maxProduct_tabulation(int[] nums) {
        result = Integer.MIN_VALUE;
        int[] memo = new int[]{1, 1};
        for (int idx = 0; idx <= nums.length - 1; idx++) {
            int currentNum = nums[idx];
            int[] temp = new int[]{
                    Math.max(memo[0] * currentNum, memo[1] * currentNum),
                    Math.min(memo[0] * currentNum, memo[1] * currentNum)
            };
            result = Math.max(temp[0], result);
            memo = temp;
        }

        return result;
    }

    public int maxProduct(int[] nums) {
        result = Integer.MIN_VALUE;
        maxProduct(nums, nums.length);

        return result;
    }

    /**
     * int[] --- <Max, Min>
     */
    private int[] maxProduct(int[] nums, int index) {
        if(index == 0)
            return new int[]{1, 1};

        int[] childResult = maxProduct(nums, index - 1);
        int currentNum = nums[index - 1];
        int[] temp = new int[]{
                Math.max(
                    Math.max(childResult[0] * currentNum, childResult[1] * currentNum),
                    currentNum),
                Math.min(
                    Math.min(childResult[0] * currentNum, childResult[1] * currentNum),
                    currentNum)
        };
        result = Math.max(temp[0], result);

        return temp;
    }

    public static void main(String[] args) {
        MaximumProductSubarray152 sol = new MaximumProductSubarray152();
        System.out.println(sol.maxProduct(new int[]{0,2}));
    }
}

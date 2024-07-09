package com.p2.random.topinterviewques.date042024;

import java.util.Arrays;

public class JumpGameII45 {

    public static void main(String[] args) {
        JumpGameII45 solution = new JumpGameII45();
        System.out.println(solution.jump(new int[]{1,2,1,1,1}));
    }

    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);

        return recursion(0, nums, memo);
    }

    int recursion(int index, final int[] nums, int[] memo) {
        if(index == nums.length - 1) {
            memo[index] = 0;
            return 0;
        }


        if(nums[index] == 0) {
            return Integer.MAX_VALUE;
        }

        for(int x = nums[index]; x > 0; x--) {
            if(index + x > nums.length - 1) {
                continue;
            }
            if(index + x == nums.length - 1) {
                memo[index] = 1;
                return 1;
            }

            int temp = recursion(index + x, nums, memo);
            memo[index] = Math.min(memo[index], temp == Integer.MAX_VALUE ? temp : temp + 1);
        }

        return memo[index];
    }
}

package year2k21.common.pattern.dp.date21022023;

import java.util.Arrays;

public class HouseRobberII213 {

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int previousToPrevious = -1;
        int previous = 0;

        for(int i = 1; i <= nums.length; i++) {
            if(i == 1)
                continue;
            int temp = 0;
            temp = Math.max(temp,
                    nums[i-1] + (i - 2 >= 1 ? previousToPrevious : 0
                    ));
            temp = Math.max(temp,
                    i - 1 >= 1 ? previous : 0
                    );
            previousToPrevious = previous;
            previous = temp;
        }

        int result = previous;

        //Reset
        previousToPrevious = -1;
        previous = 0;
        for(int i = 0; i <= nums.length - 1; i++) {
            if(i == 0)
                continue;
            int temp = 0;
            temp = Math.max(temp,
                    nums[i-1] + (i - 2 >= 0 ? previousToPrevious : 0
                    ));
            temp = Math.max(temp,
                    i - 1 >= 0 ? previous : 0
            );
            previousToPrevious = previous;
            previous = temp;
        }


        return Math.max(result, previous);
    }

    //Time = O(2*n)
    //Space can be O(2*n)
    public int rob_recursion(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);

        int temp = rob(nums.length, 1, nums, memo);//starting from last index
        Arrays.fill(memo, -1);
        return Math.max(temp, rob(nums.length-1, 0, nums, memo));
    }

    private int rob(int index, final int lastIndex, int[] nums, int[] memo) {
        if(memo[index] != -1) {
            return memo[index];
        }
        if(index == lastIndex) {
            memo[index] = 0;
            return 0;
        }

        int temp = 0;
        //Including current house
        temp = Math.max(temp,
                nums[index - 1] + (index - 2 >= lastIndex ? Math.max(temp, rob(index-2, lastIndex, nums, memo)) : 0));
        //Excluding current house
        temp = Math.max(temp,
                (index - 1 >= 0 ? rob(index-1, lastIndex, nums, memo) : 0));

        memo[index] = temp;
        return temp;
    }

    public static void main(String[] args) {
        HouseRobberII213 sol = new HouseRobberII213();
        System.out.println(sol.rob(new int[]{1}) == 1);
        System.out.println(sol.rob(new int[]{2,3,2}) == 3);
        System.out.println(sol.rob(new int[]{1,2,3,1}) == 4);
        System.out.println(sol.rob(new int[]{1,2,3}) == 3);
    }
}

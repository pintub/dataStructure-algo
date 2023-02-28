package year2k21.common.pattern.dp.date21022023;

/**
 * It's kadane
 */
public class MaximumSubarrayKadane53 {

    int result = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        int maxSubArray = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i <= nums.length-1; i++) {
            if(i==0) {
                maxEndingHere = nums[0];
                maxSubArray= nums[0];
                continue;
            }

            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSubArray = Math.max(maxEndingHere, maxSubArray);
        }

        return maxSubArray;
    }

    public static void main(String[] args) {
        MaximumSubarrayKadane53 sol = new MaximumSubarrayKadane53();
        //System.out.println(sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) == 6);
        System.out.println(sol.maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public int maxSubArray_Recursion(int[] nums) {
        getSumStartingFromIndex(nums.length, nums);

        return result;
    }

    private int getSumStartingFromIndex(int n, int[] nums) {
        if(n == 1) {
            result = Math.max(result, nums[0]);
            return nums[0];
        }

        int temp = getSumStartingFromIndex(n-1, nums);
        int temp2 = Math.max(temp + nums[n-1], nums[n-1]);
        result =  Math.max(result, temp2);

        return temp2;
    }

}

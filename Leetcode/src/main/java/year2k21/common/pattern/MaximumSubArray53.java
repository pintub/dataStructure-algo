package year2k21.common.pattern;

public class MaximumSubArray53 {

    public int maxSubArray(int[] nums) {
        int maxSumSoFar= nums[0], maxSumEndingWithCurrentNum = nums[0];//1st Element

        for(int idx = 1; idx < nums.length; idx++) {
            if(maxSumEndingWithCurrentNum < 0 && nums[idx] > maxSumEndingWithCurrentNum) {//If maxSumEndingWithCurrentNum is -ve, Discard maxSumEndingWithCurrentNum
                maxSumEndingWithCurrentNum = nums[idx];
            } else {
                maxSumEndingWithCurrentNum = maxSumEndingWithCurrentNum + nums[idx];
            }
            maxSumSoFar = Math.max(maxSumSoFar, maxSumEndingWithCurrentNum);
        }

        return maxSumSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubArray53().maxSubArray(new int[] {4, -1, 2, 3}) == 8);
        System.out.println(new MaximumSubArray53().maxSubArray(new int[] {4, -5, 2, 3}) == 5);
        System.out.println(new MaximumSubArray53().maxSubArray(new int[] {4, -5, 2, 1}) == 4);
    }
}

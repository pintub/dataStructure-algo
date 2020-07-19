import java.util.Arrays;

public class Solution1480 {
    public int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];

        for(int count = 0 ; count < nums.length ; count++){
            int currentNum = nums[count];
            if (count == 0) output[count] = currentNum;//1st element
            else output[count] = output[count - 1] + currentNum;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1480().runningSum(new int[]{0})));
    }
}
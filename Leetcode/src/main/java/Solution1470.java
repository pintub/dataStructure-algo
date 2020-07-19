import java.util.Arrays;

public class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] output = new int[nums.length];
        int outputArrayCount = 0;
        for(int count = 0 ; count < n; count++){
            output[outputArrayCount] = nums[count];
            output[outputArrayCount + 1] = nums[count + n];
            outputArrayCount += 2;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1470().shuffle(new int[]{1,2,3,4,4,3,2,1}, 4)));
    }
}

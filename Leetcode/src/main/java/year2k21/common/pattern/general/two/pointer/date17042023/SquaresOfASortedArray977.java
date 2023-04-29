package year2k21.common.pattern.general.two.pointer.date17042023;

public class SquaresOfASortedArray977 {

    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];
        int high = nums.length - 1, low = 0;
        int outputCounter = nums.length - 1;
        while (low <= high) {
            if (Math.abs(nums[high]) > Math.abs(nums[low])) {
                output[outputCounter] = nums[high] * nums[high];
                --high;
            } else {
                output[outputCounter] = nums[low] * nums[low];
                ++low;
            }
            --outputCounter;
        }
        return output;
    }
}

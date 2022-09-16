package year2k21.common.pattern.general.two.pointer;

/**
 * Wasted good enough time to identify it's a sliding window - variable type
 * Below Sliding window is good
 * count-result has issues, makes code clumsy
 * Refer for smart count https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC%2B%2B-Clean-Code-with-Explanation
 *          valid window [5] = count is 1
 *          valid window [5, 2] = existingCount + |{[2], [5, 2]}| = 3
 *          valid window [5, 2, 6] = existingCount + |{[6], [2, 6], [5, 2, 6]}| = 6
 *
*  My code was complex as i was counting considering valid windows starting with element "5"
 */
public class SubarrayProductLessThanK713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0 || k == 1) {
            return 0;
        }
        int left = 0, right = 0;
        int currentSubArrayProduct = 1;
        int count = 0;

        while (right < nums.length) {
            int rightPointerValue = nums[right];
            int tempProduct = currentSubArrayProduct * rightPointerValue;
            if (tempProduct < k) {//Still Valid after considering Current window
                currentSubArrayProduct = tempProduct;
                count++;
                right++;
            } else {//Move left pointer to make window Valid
                while (tempProduct >= k) {
                    tempProduct = tempProduct / nums[left];
                    left++;
                    if(tempProduct >= k)
                        count += right - left;
                }
                currentSubArrayProduct = tempProduct;
                count += right - left + 1;
                right++;
            }
        }

        //For end case if above logic ended with a valid window
        count += getCount(right - (left + 1));

        return count;
    }

    int getCount(int leftOverWindowSize) {
        return (leftOverWindowSize * (leftOverWindowSize + 1))/2;
    }

    public static void main(String[] args) {
        System.out.println(new SubarrayProductLessThanK713().numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    }
}

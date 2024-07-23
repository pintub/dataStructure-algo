package year2k21.common.pattern.binarysearch;

/**
 * Important :
 * ques says, nums[i] != nums[i + 1] for all valid i.
 * So adjacent will be > or <
 *
 * Now with above clarity, you can use Binary Search with better intuition
 * land on middle, move towards bigger element
 *
 * In worst case, end elements will be reached, which would satisfy peak element condition
 */
public class FindPeakElement162 {

    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if(length == 1) {
            return 0;
        }

        int lo = 0;
        int hi = length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if(isPeak(mid, nums)) {
                return mid;
            }

            if(nums[mid + 1] > nums[mid]) {
                lo= mid + 1;
            } else {//This means  nums[mid - 1] > nums[mid]
                hi = mid - 1;
            }
        }

        System.out.println("Hey!!! I am here");
        return lo;//Here lo = hi
    }

    private boolean isPeak(int idx, int[] nums) {
        return isStrictGreater(idx, idx - 1, nums) && isStrictGreater(idx, idx + 1, nums);
    }

    private boolean isStrictGreater(int idx1, int idx2, int[] nums) {
        if(idx2 < 0 || idx2 >= nums.length ){
            return true;
        }
        return nums[idx1] > nums[idx2];
    }

    public static void main(String[] args) {
        System.out.println(new FindPeakElement162().findPeakElement(new int[]{1,2,3,1}));
        System.out.println(new FindPeakElement162().findPeakElement(new int[]{2,5,1,5,2}));
    }
}

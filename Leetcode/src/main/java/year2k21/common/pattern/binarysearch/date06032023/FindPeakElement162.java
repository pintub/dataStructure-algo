package year2k21.common.pattern.binarysearch.date06032023;

/**
 * Important :
 * ques says, nums[i] != nums[i + 1] for all valid i.
 * So adjacent will be > or <
 *
 * Now with above clarity, you can use Binary Search with better intuition
 * Hint : At Mid either slope is rising or falling or has crest or has Trough, Decide whether to go Left or Right or Return index
 *
 * In worst case, end elements will be reached, which would satisfy peak element condition
 */
public class FindPeakElement162 {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if(isPeak(mid, nums))
                return mid;

            if(mid == nums.length - 1 ||
                    (mid > 0 && nums[mid - 1] > nums[mid + 1])){
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        //UnReachable
        return -1;
    }

    private boolean isPeak(int idx, int[] nums) {
        if(nums.length == 1 && idx == 0)
            return true;
        if(idx == 0 && nums[idx] > nums[idx + 1])
            return true;
        if(idx == nums.length - 1 && nums[idx-1] < nums[idx])
            return true;
        if(nums[idx] > nums[idx + 1] && nums[idx-1] < nums[idx])
            return true;
        return false;
    }

    public static void main(String[] args) {
        FindPeakElement162 sol = new FindPeakElement162();
        System.out.println(sol.findPeakElement(new int[]{1,2,3,1}));
        System.out.println(sol.findPeakElement(new int[]{2,5,1,5,2}));
        System.out.println(sol.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}

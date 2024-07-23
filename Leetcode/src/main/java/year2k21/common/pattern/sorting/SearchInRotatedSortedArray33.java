package year2k21.common.pattern.sorting;

//Similar to FindMinimumInRotatedSortedArray153

/**
 * Another simpler solution is find the minElement, then you would have 2 sorted arrays
 * then search in one of the sorted arrays based on element lies in between lo and hi
 *
 */

public class SearchInRotatedSortedArray33 {

    /**
    * Iteration
    */
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi) {//TODO check
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(lo == hi) {
                return -1;
            }
            if(lo <= mid - 1 && nums[lo] <= nums[mid - 1]) {//Left sorted
                if(nums[lo] <= target && target <=  nums[mid - 1]) {//Target is at left, So search at left
                    hi = mid - 1;
                } else {//Search at Right
                    lo = mid + 1;
                }
            } else if(mid + 1 <= hi){//Right Sorted
                if(nums[mid + 1] <= target && target <=  nums[hi]) {//Target at Right
                    lo = mid + 1;
                } else {//Search at Left
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public int search_Recursion(int[] nums, int target) {
        return search_Recursion(nums, target, 0, nums.length - 1);
    }

    
    /**
    * Recursion
    */
    private int search_Recursion(int[] nums, int target, int loIdx, int hiIdx) {
        if(hiIdx < loIdx) {
            System.out.println("How you found me ???");
            return Integer.MIN_VALUE;
        }

        if(nums[hiIdx] == target) {
            return hiIdx;
        }

        if(nums[loIdx] == target) {
            return loIdx;
        }

        if(hiIdx - loIdx == 1 || hiIdx == loIdx) {
            return -1;
        }

        int midIdx = (loIdx + hiIdx)/2;//Find mid-index and which part is sorted
        if(nums[midIdx] == target) {
            return midIdx;
        }

        if(nums[midIdx] > nums[loIdx]) {//left half is sorted
            if(target <= nums[midIdx - 1] && target > nums[loIdx]) {//target in between loIdx and mid-Idx
                return search_Recursion(nums, target, loIdx, midIdx - 1);
            } else {
                return search_Recursion(nums, target, midIdx + 1, hiIdx);
            }
        } else if(nums[hiIdx] > nums[midIdx]) {//right half is sorted
            if(target >= nums[midIdx + 1] && target < nums[hiIdx]) {//target in between hi and mid-Idx
                return search_Recursion(nums, target, midIdx + 1, hiIdx);
            } else {
                return search_Recursion(nums, target, loIdx, midIdx - 1);
            }
        }

        System.out.println("How you found me ???");
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray33().search(new int[]{2,3,4,5,6,7,8,9,1}, 9));
    }
}

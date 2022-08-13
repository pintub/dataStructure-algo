package year2k21.common.pattern.sorting;

//Similar to FindMinimumInRotatedSortedArray153

public class SearchInRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int loIdx, int hiIdx) {
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
                return search(nums, target, loIdx, midIdx - 1);
            } else {
                return search(nums, target, midIdx + 1, hiIdx);
            }
        } else if(nums[hiIdx] > nums[midIdx]) {//right half is sorted
            if(target >= nums[midIdx + 1] && target < nums[hiIdx]) {//target in between hi and mid-Idx
                return search(nums, target, midIdx + 1, hiIdx);
            } else {
                return search(nums, target, loIdx, midIdx - 1);
            }
        }

        System.out.println("How you found me ???");
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray33().search(new int[]{2,3,4,5,6,7,8,9,1}, 9));
    }
}

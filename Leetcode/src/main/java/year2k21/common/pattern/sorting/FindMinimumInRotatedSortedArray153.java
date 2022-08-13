package year2k21.common.pattern.sorting;

//Use Binary Search
//How to decide left or right ? If nums[hiIdx] > nums[lowIdx] , that part of array is sorted, look into other part
public class FindMinimumInRotatedSortedArray153 {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int loIdx, int hiIdx) {
        if(hiIdx < loIdx) {
            System.out.println("How you found me ???");
            return Integer.MIN_VALUE;
        }

        if(hiIdx-loIdx == 1 || hiIdx == loIdx) {//When one 2 or 1 elements left
            return Math.min(nums[loIdx], nums[hiIdx]);
        }

        if(nums[hiIdx] > nums[loIdx]) {//nums[loIdx...hiIdx] is sorted
            return nums[loIdx];
        }

        int midIdx = (loIdx+hiIdx)/2;
        if(nums[midIdx] > nums[loIdx]) {//Left part including midIdx is sorted, Look up right part
            return findMin(nums, midIdx, hiIdx);
        } else {//Left part including midIdx is not sorted
            return findMin(nums, loIdx, midIdx);
        }
    }


    public static void main(String[] args) {
        System.out.println("Min Element:" + new FindMinimumInRotatedSortedArray153().findMin(new int[]{3,4,5,6,7,8,1,2}));
        System.out.println("Min Element:" + new FindMinimumInRotatedSortedArray153().findMin(new int[]{7,8,1,2,3,4,5,6}));
        System.out.println("Min Element:" + new FindMinimumInRotatedSortedArray153().findMin(new int[]{5,6,7,8,1,2,3,4}));
        System.out.println("Min Element:" + new FindMinimumInRotatedSortedArray153().findMin(new int[]{3,4,5,1,2}));
        System.out.println("Min Element:" + new FindMinimumInRotatedSortedArray153().findMin(new int[]{2,1}));
        System.out.println("Min Element:" + new FindMinimumInRotatedSortedArray153().findMin(new int[]{1}));
    }
}

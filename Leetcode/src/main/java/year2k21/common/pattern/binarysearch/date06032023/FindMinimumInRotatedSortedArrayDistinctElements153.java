package year2k21.common.pattern.binarysearch.date06032023;

public class FindMinimumInRotatedSortedArrayDistinctElements153 {

    public int findMin(int[] nums) {
        int len = nums.length;
        return binarySearch(nums, 0, len - 1);
    }

    private int binarySearch(int[] nums, int low, int high) {
        if(nums[low] < nums[high])
            return nums[low];

        if((low == high) ||
                (high - low) == 1) {
            return Math.min(nums[low], nums[high]);
        }

        int mid = (low + high) >> 1; // Divide by 2
        if(nums[low] < nums[mid] || low == mid) { //Look up right side
            return binarySearch(nums, mid + 1, high);
        } else if (nums[mid + 1] < nums[high] || mid+1 == high) { //Look up Left side
            return binarySearch(nums, low, mid);
        }

        System.out.println("I am Unreachable!!");
        return -1;//
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayDistinctElements153 sol = new FindMinimumInRotatedSortedArrayDistinctElements153();
        System.out.println("Min Element:" + sol.findMin(new int[]{3,4,5,6,7,8,1,2}));
        System.out.println("Min Element:" + sol.findMin(new int[]{7,8,1,2,3,4,5,6}));
        System.out.println("Min Element:" + sol.findMin(new int[]{5,6,7,8,1,2,3,4}));
        System.out.println("Min Element:" + sol.findMin(new int[]{3,4,5,1,2}));
        System.out.println("Min Element:" + sol.findMin(new int[]{2,1}));
        System.out.println("Min Element:" + sol.findMin(new int[]{1}));
    }
}

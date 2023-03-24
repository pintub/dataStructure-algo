package year2k21.common.pattern.binarysearch.date06032023;

public class SearchInRotatedSortedArrayIINonDistinctNums81 {

    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int temp = nums[low];

            //Trim down until dups are eliminated
            while (low <= high && nums[low] == temp) //Move low to right
                low++;
            low -= 1;

            temp = nums[high];
            while (high >= low && nums[high] == temp ) //Move hi to left
                high--;
            high += 1;

            int mid = (low + high)/2;

            if(nums[mid] == target)
                return true;

            if(nums[mid] >= nums[low]) //Left Sorted
                if(nums[mid] >= target && target >= nums[low])//In between
                    high = mid - 1;
                else
                    low = mid + 1;
            else
                if(nums[high] >= target && target >= nums[mid])//In between
                    low = mid + 1;
                else
                    high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayIINonDistinctNums81 sol = new SearchInRotatedSortedArrayIINonDistinctNums81();
        System.out.println(sol.search(new int[]{2,5,6,0,0,1,2}, 0));//true
        System.out.println(sol.search(new int[]{2,5,6,0,0,1,2}, 3));//false
        System.out.println(sol.search(new int[]{1}, 0));
    }
}

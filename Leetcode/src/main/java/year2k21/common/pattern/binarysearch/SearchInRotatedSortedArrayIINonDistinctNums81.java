package year2k21.common.pattern.binarysearch;

/**
 * Got the intuition, couldn't solve
 * Difference vs normal Binary-search
 *      It has dup numbers, so eliminate dups by shifting low to right until dups are covered , similar shirt high to left
 * Refer : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/1890363/python-or-binary-search-or-explained-or
 */
public class SearchInRotatedSortedArrayIINonDistinctNums81 {

    public boolean search(int[] nums, int target) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArrayIINonDistinctNums81().search(new int[]{1}, 0));
    }
}

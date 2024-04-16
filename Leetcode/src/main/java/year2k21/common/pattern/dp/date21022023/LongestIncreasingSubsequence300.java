package year2k21.common.pattern.dp.date21022023;

/**
 * Question is Increase sequence, so i am going left to right, unlike other problems.
 * Using Zero indexing in below solution
 *
 * Below is VVIMP:
 * - If the current element is greater than the previous element, then we can either pick it or don't pick it because we may get a smaller element somewhere ahead which is greater than previous and picking that would be optimal. So we try both options. So 2 choice branches
 * - If the current element is smaller or equal to previous element, it can't be picked. So 1 choice branch
 *
 * Input : [0,10,3,4]
 *                                      (0,MIN)         --1st arg Index, 2nd arg  previousPickedValue
 *                              pick 0 /           \No-pick 0
 *                              (1,0)               (1,MIN)
*                         pick 10/   \No-pick 10
 *                           (2,10)     (2,0)
 *                     pick 3/
 *                          (3,3)
 *                   pick 4/      \No-pick 4
 *                     (4,4)--ret 0  (4,3)--ret 0
 *
 * memo Map or 2D array(little complicated) can be used, space can be optimized to O(n) from O(n*2)
 * Time = O(n^2), space = O(n^2) or O(n)
 */
public class LongestIncreasingSubsequence300 {

    public int printLIS_BruteForceRecursion(int[] arr) {
        return printLIS_BruteForceRecursion(arr, 0, Integer.MIN_VALUE);
    }

    //Without Memo
    private int printLIS_BruteForceRecursion(int[] arr, int index, int previousPickedValue) {
        if(index == arr.length) {
            return 0;
        }

        int max = printLIS_BruteForceRecursion(arr, index + 1, previousPickedValue);
        if(arr[index] > previousPickedValue) {
            max = Math.max(max, 1 + printLIS_BruteForceRecursion(arr, index + 1, arr[index]));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence300().printLIS_BruteForceRecursion(new int[]{7,7,7,7,7,7,7}) == 1);
        System.out.println(new LongestIncreasingSubsequence300().printLIS_BruteForceRecursion(new int[]{0}));
    }
}

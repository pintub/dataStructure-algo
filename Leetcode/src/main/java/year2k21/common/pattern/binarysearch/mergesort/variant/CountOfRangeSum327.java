package year2k21.common.pattern.binarysearch.mergesort.variant;

/**
 * Read only explanation & solve (https://leetcode.com/problems/count-of-range-sum/discuss/1178174/Java-Clean-Merge-Sort-O(N-logN)-Solution-oror-with-detailed-Explanation)
 *          [PrefixSum passed to MergeSort]
 *          Note: PrefixSum gets sorted in this process
 *
 *          Imp point:
 *              starting point in [low, mid] & ending point in [mid+1, high]. For each starting point k, find ending points i & j such that
 *
 *              i is the first index with pfxSum[i] - pfxSum[k] >= lower
 *              j is the last index with pfxSum[j] - pfxSum[k] <= upper
 *
 *
 * Other similar problems:
 *      493. Reverse Pairs
 *      315. Count of Smaller Numbers After Self
 *      1885. Count Pairs in Two Arrays
 */
public class CountOfRangeSum327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        return -1;
    }
}

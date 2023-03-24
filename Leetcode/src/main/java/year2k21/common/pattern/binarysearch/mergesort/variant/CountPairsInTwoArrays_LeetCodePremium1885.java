package year2k21.common.pattern.binarysearch.mergesort.variant;

/**
 * Question : https://leetcode.ca/2021-07-23-1885-Count-Pairs-in-Two-Arrays/
 *
 *
 *      nums1[i] + nums1[j] > nums2[i] + nums2[j]
 *  ==> (nums1[i] - nums2[i]) + (nums1[j] - nums2[j]) > 0
 *
 *  So Create a diff[] and find pair where diff[i] + diff[j] >0 where j > i
 *  Use diff[] in Merge-Sort
 *
 */
public class CountPairsInTwoArrays_LeetCodePremium1885 {

    private long count = 0;

    public long countPairs(int[] nums1, int[] nums2) {
        int[] diff = new int[nums1.length];
        for(int idx = 0; idx < nums1.length; idx++) {
            diff[idx] = nums1[idx] - nums2[idx];
        }

        mergeSort(diff, 0, diff.length - 1);

        return count;
    }

    private void mergeSort(int[] diff, int low, int high) {
        if(low >= high) {
            return;
        }

        int mid = (low + high)/2;
        mergeSort(diff, low, mid);
        mergeSort(diff, mid + 1, high);

        merge(diff, low, mid, high);
    }

    private void merge(int[] diff, int low, int mid, int high) {
        for(int left = low; left <= mid; left++) {
            for (int right = mid + 1; right <= high; right++) {
                if (diff[right] > (0 - diff[left])) {
                    count += (high - right + 1);
                    break;
                }
            }
        }

        int left = low;
        int right = high;
        int[] auxSpace = new int[diff.length];
        int auxSpaceCounter = 0;
        while (left <= mid && right <= high) {
            if(diff[left] <= diff[right]) {
                auxSpace[auxSpaceCounter] = diff[left];
                auxSpaceCounter++;
                left++;
            } else {
                auxSpace[auxSpaceCounter] = diff[right];
                auxSpaceCounter++;
                right++;
            }
        }

        while (left <= mid) {
            auxSpace[auxSpaceCounter] = diff[left];
            auxSpaceCounter++;
            left++;
        }

        while (right <= high){
            auxSpace[auxSpaceCounter] = diff[right];
            auxSpaceCounter++;
            right++;
        }

        auxSpaceCounter = 0;
        for(int idx = low; idx <= high; idx++) {
            diff[idx] = auxSpace[auxSpaceCounter];
            auxSpaceCounter++;
        }
    }

    public static void main(String[] args) {
        CountPairsInTwoArrays_LeetCodePremium1885 sol = new CountPairsInTwoArrays_LeetCodePremium1885();
        System.out.println(sol.countPairs(new int[]{1,10,6,2}, new int[]{1,4,1,5}) == 5);
        sol.count = 0;
        System.out.println(sol.countPairs(new int[]{2,1,2,1}, new int[]{1,2,1,2}) == 1);
    }
}

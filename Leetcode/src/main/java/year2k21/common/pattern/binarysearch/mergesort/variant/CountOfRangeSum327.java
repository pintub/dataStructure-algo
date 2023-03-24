package year2k21.common.pattern.binarysearch.mergesort.variant;

/**
 * Read only explanation & solve (https://leetcode.com/problems/count-of-range-sum/discuss/1178174/Java-Clean-Merge-Sort-O(N-logN)-Solution-oror-with-detailed-Explanation)
*            Why PrefixCumulativeSum Used ? PrefixCumulativeSum[i] stores sum of ) to uth index, Sum[i to j] = PrefixCumulativeSum[j](i.e. Sum ) to jth) - PrefixCumulativeSum[i-1](i.e. Sum 0 to i-1th) & we need to find those differences which lie between [lower, upper]
 *          PrefixCumulativeSum Size = Original.size + 1, 1st index value= 0
 *          Note: PrefixCumulativeSum gets sorted in this process
 *
 *          Imp point:
 *              starting point in [low, mid] & ending point in [mid+1, high].
 *              For each starting point k, find ending points i & j such that,
 *                  i is the first index with pfxSum[i] - pfxSum[k] >= lower
 *                  j is the last index with pfxSum[j] - pfxSum[k] <= upper
*               Thus all elements Sum[k..i] till Sum[k..j] falls within lower and upper range
 *
 * 1. Choose which array which be part of mergesort. Here build PrefixCumulativeSum[] , size = inputSize + 1
 * 2. Global variable count = 0
 * 3. Use mergesort by passing above array
 * 4. Implement merge algorithm ,which is specific to problem statement. For each element in 1st half, find the other end of pair in 2nd half. For example, for each element in left half, find 2 points in right half such that pfxSum[i] - pfxSum[k] >= lower and pfxSum[j] - pfxSum[k] <= upper
 * 5. Then merge the sorted arrays
 *
 * Other similar problems:
 *      493. Reverse Pairs
 *      315. Count of Smaller Numbers After Self
 *      1885. Count Pairs in Two Arrays
 */
public class CountOfRangeSum327 {

    private int lower;
    private int upper;
    private int count= 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int originalLen = nums.length;
        long[] prefixCumulativeSum = new long[originalLen + 1];//Notice the size

        this.lower = lower;
        this.upper = upper;

        //Populate prefixCumulativeSum
        prefixCumulativeSum[0] = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            prefixCumulativeSum[idx+1] = prefixCumulativeSum[idx] + nums[idx];
        }

        mergeSort(prefixCumulativeSum, 0, prefixCumulativeSum.length - 1);

        return count;
    }

    //Recursion, Almost same as Actual Merge sort
    private void mergeSort(long[] prefixCumulativeSum, int low, int high) {
        if(low >= high) {
            return;
        }

        int mid = (low + high)/2;

        mergeSort(prefixCumulativeSum, low, mid);
        mergeSort(prefixCumulativeSum, mid + 1, high);

        merge(prefixCumulativeSum, low, mid, high);
    }

    //Sort 2 parts of Array
    //And does the count, which is problem statement
    private void merge(long[] prefixCumulativeSum, int low, int mid, int high) {

        int i = mid + 1, j = mid + 1;
        for (int k = low; k <= mid; k++) {
            while (i <= high && prefixCumulativeSum[i] - prefixCumulativeSum[k] < lower) i++; //"i" is the 1st element which Less-Than lower, i.e. breaking rule
            while (j <= high && prefixCumulativeSum[j] - prefixCumulativeSum[k] <= upper) j++; //"j" is the 1st element which Greater-Than upper, i.e. breaking rule

            count += j - i;
        }

        //Merge 2 sorted parts of  PrefixCumulativeSum
        CountOfRangeSum327.mergeTwoSortedArrays(prefixCumulativeSum, low, mid, high);
    }

    public static void mergeTwoSortedArrays(long[] prefixCumulativeSum, int low, int mid, int high) {
        int firstPartPointer = low;
        int secondPartPointer = mid + 1;
        long[] temp = new long[high - low + 1];//Auxiliary space
        int tempCounter = 0;

        while (firstPartPointer <= mid && secondPartPointer <= high) {
            if(prefixCumulativeSum[firstPartPointer] <= prefixCumulativeSum[secondPartPointer]) {
                temp[tempCounter++] = prefixCumulativeSum[firstPartPointer];
                firstPartPointer++;
            } else {
                temp[tempCounter++] = prefixCumulativeSum[secondPartPointer];
                secondPartPointer++;
            }
        }

        while (firstPartPointer <= mid){
            temp[tempCounter++] = prefixCumulativeSum[firstPartPointer];
            firstPartPointer++;
        }

        while (secondPartPointer <= high){
            temp[tempCounter++] = prefixCumulativeSum[secondPartPointer];
            secondPartPointer++;
        }

        int originalArrayCounter = low;
        for(long num : temp) {
            prefixCumulativeSum[originalArrayCounter++] = num;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountOfRangeSum327().countRangeSum(new int[]{0,-1,-2,-3,0,2}, 3, 5));
    }
}

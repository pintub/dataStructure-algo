package year2k21.common.pattern.binarysearch.mergesort.variant;

import java.util.ArrayList;
import java.util.List;

/**
 * Is sliding window possible ==> NO
 *
 * Using Merge-Sort-like solution
 *
 * Here array which is part of merge sort is => int[nums.len][2] ,each element has num and index
 *
 * Decreasing Order merge sort
 */
public class CountOfSmallerNumbersAfterSelf315 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int ignored : nums) {
            result.add(0);
        }

        int[][] numAndIndices = new int[nums.length][2];
        for(int index = 0; index < nums.length; index++) {
            numAndIndices[index] = new int[]{nums[index], index};
        }
        mergeSort(numAndIndices, 0, nums.length - 1, result);

        return result;
    }

    private void mergeSort(int[][] numAndIndices, int low, int high, List<Integer> result) {
        if(low >= high) {
            return ;
        }

        int mid = (low + high) / 2;
        mergeSort(numAndIndices, low, mid, result);
        mergeSort(numAndIndices, mid + 1, high, result);

        merge(numAndIndices, low, mid, high, result);
    }

    /**
     * Both halves are in decreasing order
     */
    private void merge(int[][] numAndIndices, int low, int mid, int high, List<Integer> result) {
        //For each element on left side, find which elements on the right side are smaller
        /*for(int left = low; left <= mid; left++) {
            for(int right = mid + 1; right <= high; right++) {
                if(numAndIndices[right][0] < numAndIndices[left][0]) {
                    result.set(numAndIndices[left][1], result.get(numAndIndices[left][1]) + (high - right + 1));
                    break;
                }
            }
        }*/

        int leftPtr = low;
        int rightPtr = mid + 1;
        int[][] auxSpace = new int[high - low + 1][2];
        int auxSpaceCounter = 0;
        while (leftPtr <= mid && rightPtr <= high) {
            if(numAndIndices[leftPtr][0] > numAndIndices[rightPtr][0]) {
                result.set(numAndIndices[leftPtr][1], result.get(numAndIndices[leftPtr][1]) + (high - rightPtr + 1));
                auxSpace[auxSpaceCounter] = new int[]{numAndIndices[leftPtr][0], numAndIndices[leftPtr][1]};
                auxSpaceCounter++;
                leftPtr++;
            } else {
                auxSpace[auxSpaceCounter] = new int[]{numAndIndices[rightPtr][0], numAndIndices[rightPtr][1]};
                auxSpaceCounter++;
                rightPtr++;
            }
        }

        while (leftPtr <= mid) {
            auxSpace[auxSpaceCounter] = new int[]{numAndIndices[leftPtr][0], numAndIndices[leftPtr][1]};
            auxSpaceCounter++;
            leftPtr++;
        }

        while (rightPtr <= high) {
            auxSpace[auxSpaceCounter] = new int[]{numAndIndices[rightPtr][0], numAndIndices[rightPtr][1]};
            auxSpaceCounter++;
            rightPtr++;
        }

        auxSpaceCounter = 0;
        for (int count = low; count <= high; count++) {
            numAndIndices[count] = auxSpace[auxSpaceCounter];
            auxSpaceCounter++;
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf315 sol = new CountOfSmallerNumbersAfterSelf315();
        //System.out.println(sol.countSmaller(new int[]{5,2,6,1}));
        //System.out.println(sol.countSmaller(new int[]{-1,-1}));
        System.out.println(sol.countSmaller(new int[]{0,2,1}));
    }
}

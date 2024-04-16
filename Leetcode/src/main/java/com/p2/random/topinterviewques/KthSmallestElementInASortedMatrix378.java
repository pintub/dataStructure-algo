package com.p2.random.topinterviewques;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ~~~~~~~~~~~~Post Regarding Binary Search Solution~~~~~~
 * Binary Search usually reduces search-space y selecting one direction.
 * All questions known to me was Index-Binary search, low/high/mid are indices
 *
 * There is another type binary search which is Range-binary search. Example Below question. lo is the smallest number and the highest number. Mid is an number which may not exist in input[].
 *At "mid" check for the condition, here count of nums <= mid should be k
 *
 * Template :
 *  low = lowest num
 *  hi = highest num
 *  while(low < high)
 *      mid = low + (high - low) / 2; //Middle number in the Range
 *      if(Traverse through input[] and check some conditionAroundMid)
 *          Reduce hi or Increase low
 *
 * Time :
 *      logn searches. Each search through input[] and check conditionAroundMid
 *      O(nlogn)
 */
public class KthSmallestElementInASortedMatrix378 {

    //Similar to build "Sort n sorted lists" Problem
    //Space= 2 * O(n) for MinHeap, as stores pair <rowIndex, colIndex>
    //Time = k log(n)
    public int kthSmallest_MinHeap(int[][] matrix, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> matrix[pair[0]][pair[1]]));
        int matrixDimension = matrix.length;
        for(int row = 0; row < Math.min(k, matrix.length); row++) {//Build Min Heap w/ 1st element of each row, O(n)
            minHeap.add(new int[]{row, 0});
        }

        int removedCount = 0;
        int[] indexOfResult = new int[2];
        while (removedCount < k) {
            indexOfResult = minHeap.remove();
            int rowIndex = indexOfResult[0], colIndex = indexOfResult[1];
            if(colIndex < matrixDimension - 1){
                minHeap.add(new int[]{rowIndex, colIndex + 1});
            }
            removedCount++;
        }

        return matrix[indexOfResult[0]][indexOfResult[1]];
    }

    //N = n^2
    //Time = O(NlogN * N)
    public int kthSmallest_BinarySearch(int[][] matrix, int k) {
        int low = matrix[0][0];
        int rowLen = matrix.length, colLen = matrix[0].length;
        int high = matrix[rowLen - 1][colLen - 1];
        while (low < high) {//Notice
            int mid = low + (high - low) / 2;//Notice
            if(countOfElementsLessOrEqualToMid(matrix, mid) >= k) {
                high = mid;//Notice
            } else {
                low = mid + 1;//Notice
            }
        }

        return low;//TODO I don't understand this, how low is always a valid number from input array
    }

    private int countOfElementsLessOrEqualToMid(int[][] matrix, int elem) {
        int count = 0;
        for(int row = 0; row < matrix.length; row++) {
            int col = matrix[row].length - 1;
            while ( col >= 0 && matrix[row][col] > elem) {
                col--;
            }
            count += col + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix378 sol = new KthSmallestElementInASortedMatrix378();
        System.out.println(sol.kthSmallest_BinarySearch(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));//13
        //System.out.println(sol.kthSmallest_MinHeap(new int[][]{{1,2},{4,11}}, 3));//4
    }

}

package com.p2.dp.aditya.mcm;

import java.util.*;

/** arr[] = {40, 20, 30, 10, 30}
 * Here, 4 Matrices = {40*20, 20*30, 30*10, 10*30}.
 * We have 3 partition possibility of multiplication A(BCD) or (AB)(CD) or (ABC)D
 * Each partition is a choice
 *
 * Choices :
 *                          (1     ,   4)  //Index i means Matrix(arr[i-1]*arr[i]), example idx 1 means arr(40*20)
 *                     k=1 /    \k=2      \k=3
 *                        /      \         \
 *                       /        \         \
 *               (1,1)*(2,4)   (1,2)*(3,4)  (1,3)*(4,4)
 *                      k=1/  \k=2
 *                        /    \
 *                      /       \
 *                (2,2)*(3,4)  (2,3)*(4,4)
 *
 * Note , for memo[][] no additional row or column required
 * Also Note, for MCM 1st row last cell is the answer
 *
 * 2 memo[][], one for cost another for parenthesis
*/
public class MCM {
    int findLowestCostAndPrintParenthesis(int[] arr) {
        int arrLen = arr.length;
        int[][] memoCost = new int[arrLen - 1][arrLen - 1];
        for(int[] row : memoCost) {//Fill with -1
            Arrays.fill(row, -1);
        }
        String[][] memoParenthesisString = new String[arrLen - 1][arrLen - 1];

        int lowestCost = recursion(1, arrLen - 1, memoCost, memoParenthesisString, arr);
        System.out.println(memoParenthesisString[0][arrLen - 2]);//1st row,last column cell has the answer

        return lowestCost;
    }

    private int recursion(int matrixStart, int matrixEnd, int[][] memoCost, String[][] memoParenthesisString, int[] arr) {
        if(memoCost[matrixStart - 1][matrixEnd - 1] != -1) {
            return memoCost[matrixStart - 1][matrixEnd - 1];
        }
        if(matrixStart == matrixEnd) {
            memoCost[matrixStart - 1][matrixEnd - 1] = 0;
            //memoParenthesisString[matrixStart - 1][matrixEnd - 1] = "(" + matrixStart + ")";
            memoParenthesisString[matrixStart - 1][matrixEnd - 1] = "" + matrixStart;
            return 0;
        }
        int lowCost = Integer.MAX_VALUE;
        int winnerPartition = -1;
        for(int partition = matrixStart; partition < matrixEnd; partition++) {//Template format for MCM type
            int temp = recursion(matrixStart, partition, memoCost, memoParenthesisString, arr) +
                    recursion(partition + 1, matrixEnd, memoCost, memoParenthesisString, arr) +
                    (arr[matrixStart - 1] * arr[partition] * arr[matrixEnd]);
            if(temp < lowCost) {
                winnerPartition = partition;
                lowCost = temp;
            }
        }

        memoCost[matrixStart - 1][matrixEnd - 1] = lowCost;
        memoParenthesisString[matrixStart - 1][matrixEnd - 1] = "(" + memoParenthesisString[matrixStart - 1][winnerPartition - 1] + ")" + "(" + memoParenthesisString[winnerPartition][matrixEnd - 1] + ")";

        return lowCost;
    }

    public static void main(String[] args) {
        System.out.println(new MCM().findLowestCostAndPrintParenthesis(new int[]{10, 20, 30}) == 6000);
        System.out.println(new MCM().findLowestCostAndPrintParenthesis(new int[]{10, 20, 30, 40, 30}) == 30000);
    }
}

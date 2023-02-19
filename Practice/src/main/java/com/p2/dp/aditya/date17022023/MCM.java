package com.p2.dp.aditya.date17022023;

import java.util.Arrays;

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
        int memoCost[][] = new int[arrLen - 1][arrLen - 1];
        String memoParenthesisString[][] = new String[arrLen - 1][arrLen - 1];

        recursion(arr, 1, arrLen - 1, memoCost, memoParenthesisString);

        System.out.println(memoParenthesisString[0][arrLen - 2]);
        return memoCost[0][arrLen -2];
    }

    private int recursion(int[] arr, int matrixStart, int matrixEnd, int[][] memoCost, String[][] memoParenthesisString) {
        if(memoCost[matrixStart -1][matrixEnd - 1]  == -1) {
            return memoCost[matrixStart -1][matrixEnd - 1];
        }

        if(matrixStart == matrixEnd) {
            memoCost[matrixStart-1][matrixEnd-1] =0;
            memoParenthesisString[matrixStart-1][matrixEnd-1]= String.valueOf(matrixStart);
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        String parenthesisWithMinCost = "";
        for(int k = matrixStart; k < matrixEnd; k++) {
            int tempCost = recursion(arr, matrixStart, k, memoCost, memoParenthesisString) +
                    recursion(arr, k+1, matrixEnd, memoCost, memoParenthesisString) +
                    arr[matrixStart - 1] * arr[k] * arr[matrixEnd];
            if(tempCost < minCost) {
                minCost = tempCost;
                parenthesisWithMinCost = "(" + memoParenthesisString[matrixStart-1][k-1] + ")" + "(" + memoParenthesisString[k][matrixEnd-1] + ")";
            }
        }

        memoCost[matrixStart-1][matrixEnd-1] = minCost;
        memoParenthesisString[matrixStart-1][matrixEnd-1] = parenthesisWithMinCost;

        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(new MCM().findLowestCostAndPrintParenthesis(new int[]{10, 20, 30}) == 6000);
        System.out.println(new MCM().findLowestCostAndPrintParenthesis(new int[]{10, 20, 30, 40, 30}) == 30000);//(((A*B)*C)*D)
    }
}

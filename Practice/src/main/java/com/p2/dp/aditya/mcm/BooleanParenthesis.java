package com.p2.dp.aditya.mcm;

import com.p2.*;

/**
 * memo Pair[][]
 * Pair<#Ways-True, #Ways-False>
 *
 *  char of string ∈ {T, F, &, |, ^)
 */
public class BooleanParenthesis {

    private int getCountForTrueEvaluation(String booleanString) {
        int boolLen = booleanString.length();//Always Odd
        int memoLen = (boolLen + 1) / 2;
        Pair<Integer,  Integer>[][] memo = new Pair[memoLen][memoLen];//memoLen is size

        Pair<Integer, Integer> resultPair = recursion(1, boolLen, memo, booleanString);
        System.out.println("True Count:" + resultPair.left);
        System.out.println("False Count:" + resultPair.right);

        return resultPair.left;
    }

    private Pair<Integer, Integer> recursion(int start, int end, Pair<Integer, Integer>[][] memo, final String booleanString) {
        if(start == end) {
            return booleanString.charAt(start - 1) == 'T' ? new Pair<>(1, 0) : new Pair<>(0, 1);
        }

        Pair<Integer, Integer> pair = new Pair<>(0, 0);
        for(int partition = start; partition < end; partition = partition + 2) {
            Pair<Integer, Integer> leftChildResult = recursion(start, partition, memo, booleanString);
            Pair<Integer, Integer> rightChildResult = recursion(partition + 2, end, memo, booleanString);
            Pair<Integer, Integer> totalResult = mergePair(leftChildResult, rightChildResult, booleanString.charAt(partition));

            pair.left += totalResult.left;
            pair.right += totalResult.right;
        }

        return pair;
    }

    private Pair<Integer, Integer> mergePair(Pair<Integer, Integer> pair1, Pair<Integer, Integer> pair2, char bitWiseOperator) {
        Pair<Integer, Integer> merged = null;
        switch (bitWiseOperator) {
            case '|' :
                merged = new Pair<>(pair1.left * pair2.left + pair1.left * pair2.right + pair1.right * pair2.left,
                        pair1.right*pair2.right);
                break;
            case '&' :
                merged = new Pair<>(pair1.left * pair2.left,
                        + pair1.left * pair2.right + pair1.right * pair2.left + pair1.right*pair2.right);
                break;
            case '^' :
                merged = new Pair<>(pair1.left * pair2.right + pair1.right * pair2.left,
                        pair1.left * pair2.left + pair1.right*pair2.right);
                break;
            default :
                System.out.println("How you reached me ??");

        }

        return merged;
    }

    public static void main(String[] args) {
        System.out.println(new BooleanParenthesis().getCountForTrueEvaluation("T^F&T"));
    }
}

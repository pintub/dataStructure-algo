package com.p2.dp.aditya.lcs;

/**
 * X = "abcdgh"
 * Y = "abedfhr"
 *
 * O/P = "abdh"
 *
 * DP Choices :
 *          (6,6) //Matching chars
 *          / + h
 *         /
 *        (5, 5)
 *
 *              (6,7) //Not Matching chars
 *             /    \
 *            /      \
 *         (5, 7)  (6,6)
 *
 * Print LCS
 *      Approach1: Store subsequence in memo[][]
 *      Approach2: Store int(largest subsequence length) in memo[][] and traverse from end (m,n)cell to (0,0) cell based on matching/non-matching condition. But for this you need to store data in memo[m][n]. Space-optimized version might not work
 */
public class LongestCommonSubsequence {

    private String printLCS(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();

        String[][] memo = new String[2][str2Len + 1];//Space O(2* str2Len * max(Str1Len, Str2Len)) as stores LCS strings

        for(int row = 0; row <= str1Len; row++){//Virtual rows
           for (int column = 0; column <= str2Len; column++) {
                if(row == 0 || column == 0) {
                    memo[row % 2][column] = "";//Initialize to empty string
                    continue;
                }

               boolean isMatch = str1.charAt(row - 1) == str2.charAt(column - 1);

               if(row % 2 == 1) {//If row index 1 or 3 or 5...
                    if(isMatch) {//Matching
                        memo[1][column] = memo[0][column - 1] + str1.charAt(row - 1);
                    } else {//Not matching
                        memo[1][column] =
                                (memo[0][column].length() >= memo[1][column - 1].length()) ?
                                        memo[0][column] :
                                        memo[1][column - 1];
                    }
                } else {
                    if(isMatch) {//Matching
                        memo[0][column] = memo[1][column - 1] + str1.charAt(row - 1);
                    } else {//Not matching
                        memo[0][column] =
                                (memo[1][column].length() >= memo[0][column - 1].length()) ?
                                        memo[1][column] :
                                        memo[0][column - 1];
                    }
                }
           }
        }

        return str1Len %2 == 1 ? memo[1][str2Len] : memo[0][str2Len];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().printLCS("abe", "ae").equals("ae"));
        System.out.println(new LongestCommonSubsequence().printLCS("abcdgh", "abedfhr").equals("abdh"));
    }
}

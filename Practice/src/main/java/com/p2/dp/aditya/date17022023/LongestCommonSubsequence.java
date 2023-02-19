package com.p2.dp.aditya.date17022023;

/**
 * Space optimized version
 *  memo[0..str1.length] + a temp var to store left-diagonal value
 */
public class LongestCommonSubsequence {

    public String printLCS(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        String[] memo = new String[str1Len + 1];
        String tempDiagonal = null;

        for(int col = 0; col <= str2Len; col++) {
            for(int row = 0; row <= str1Len; row++) {
                if(col == 0) {
                    memo[row] = "";
                    continue;
                }

                if(row == 0) {
                    tempDiagonal = "";
                    continue;
                }

                if (str1.charAt(row-1) == str2.charAt(col-1)) {//Match
                    String temp = memo[row];
                    memo[row] = tempDiagonal + str1.charAt(row-1);
                    tempDiagonal = temp;
                } else {//No Match
                    String temp = memo[row];
                    memo[row] = memo[row].length() > memo[row-1].length() ? memo[row] : memo[row -1];
                    tempDiagonal = temp;
                }
            }
        }

        return memo[str1Len];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();
        System.out.println(sol.printLCS("abe", "ae").equals("ae"));
        System.out.println(sol.printLCS("abcdgh", "abedfhr").equals("abdh"));
    }
}

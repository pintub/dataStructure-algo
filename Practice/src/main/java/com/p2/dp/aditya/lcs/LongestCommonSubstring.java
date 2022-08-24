package com.p2.dp.aditya.lcs;

/**
 * X = "abcdgh"
 * Y = "abedfhr"
 *
 * O/P = "ab"
 *
 * Till now you have seen problems where memo table each cell stores the result of a sub-problem. But here in LCSS that principle doesn't work. Actual result is outside the memo object and calculated separately, while memo object contents only help to derive actual result
 *
 * Trick here is to draw the recursion tree and what is return value of each node in recursion
 *
 * DP choices same as LCS
 */
public class LongestCommonSubstring {
    private String lcssString = "";

    //Recursion + Memorization
    private String printLCSS(String str1, String str2) {
        String[][] memo = new String[str1.length() + 1][str2.length() + 1];
        recursion(str1, str2, str1.length(), str2.length(), memo);

        return lcssString;
    }

    private String recursion(String str1, String str2, int str1Idx, int str2Idx, String[][] memo) {
        if(memo[str1Idx][str2Idx] != null) {
            return memo[str1Idx][str2Idx];
        }

        if(str1Idx == 0 || str2Idx == 0) {
            memo[str1Idx][str2Idx] = "";
            return "";
        }

        if(str1.charAt(str1Idx - 1) == str2.charAt(str2Idx - 1)) {//Matching
            String temp = recursion(str1, str2, str1Idx - 1, str2Idx - 1, memo) + str1.charAt(str1Idx - 1);
            lcssString = temp.length() > lcssString.length() ? temp : lcssString;

            memo[str1Idx][str2Idx] = temp;
            return temp;
        } else {//Not matching
            recursion(str1, str2, str1Idx - 1, str2Idx, memo);
            recursion(str1, str2, str1Idx, str2Idx - 1, memo);

            memo[str1Idx][str2Idx] = "";
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubstring().printLCSS("abcdih", "ibcdehf"));
        //System.out.println(new LongestCommonSubstring().printLCSS("abcd", "abfc").equals("ab"));
    }
}

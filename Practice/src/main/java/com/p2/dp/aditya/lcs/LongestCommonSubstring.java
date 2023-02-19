package com.p2.dp.aditya.lcs;

/**
 * X = "abed"
 * Y = "ababe"
 *
 * O/P = "abe"
 *
 Couldn't understand recursion solution(it needs 3 states)
    Start with Tabulation of LCS

 If X[i], Y[j] non-matching, mark memo as "", as it won't contribute to next iterations
 Else ,Check if X[i-1], Y[j-1] matched & Do memo[i-1][j-1] + currentChar

 Each cell contains longest common suffix "must-including" those indices
 X = "abed"
 Y = "gababe"

 memo[2][3] = "ab"
 memo[3][3] = ""
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println(LongestCommonSubstring.LCS_Tabulation("abcdih", "ibcdehf").equals("bcd"));
        System.out.println(LongestCommonSubstring.LCS_Tabulation("abcd", "abfc").equals("ab"));
        System.out.println(LongestCommonSubstring.LCS_Tabulation("abedd", "abebedd").equals("bedd"));
        System.out.println(LongestCommonSubstring.LCS_Tabulation("aba", "abea").equals("ab"));
        System.out.println(LongestCommonSubstring.LCS_Tabulation("zxabcdezy", "yzabcdezx").equals("abcdez"));
        System.out.println(LongestCommonSubstring.LCS_Tabulation("abcdxyz", "xyzabcd").equals("abcd"));
        System.out.println(LongestCommonSubstring.LCS_Tabulation("abe", "beabe").equals("abe"));
    }

    public static String LCS_Tabulation(String X, String Y) {
        int xLen = X.length();
        int yLen = Y.length();

        String lcss = "";

        // `memo[i][j]` stores the length of LCS of substring
        // `X[0…i-1]`, `Y[0…j-1]`
        String[][] memo = new String[xLen + 1][yLen + 1];

        // fill the memo table in a bottom-up manner
        for (int i = 0; i <= xLen; i++) {
            for (int j = 0; j <= yLen; j++) {

                if (i == 0 || j == 0) {
                    memo[i][j] = "";
                    continue;
                }

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {// if the current character of `X` and `Y` matches
                    memo[i][j] = memo[i - 1][j - 1] + X.charAt(i - 1);

                    if (memo[i][j].length() > lcss.length()) {
                        lcss = memo[i][j];
                    }
                } else {
                    memo[i][j] = "";
                }
            }
        }

        return lcss;
    }

}

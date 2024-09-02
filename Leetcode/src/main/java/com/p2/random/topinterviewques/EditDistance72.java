package com.p2.random.topinterviewques;

public class EditDistance72 {

    public int minDistance(String word1, String word2) {
        int[] memo = new int[word1.length() + 1];//horizontal memo

        for(int row = 0; row <= word2.length(); row++) {
            int prevValueInMemo = 0;
            for(int col = 0; col <= word1.length(); col++) {
                if(row == 0) {
                    int temp = memo[col];
                    memo[col] = col;
                    prevValueInMemo = temp;
                    continue;
                }
                if(col == 0) {
                    int temp = memo[col];
                    memo[col] = row;
                    prevValueInMemo = temp;
                    continue;
                }
                if(word1.charAt(col - 1) == word2.charAt(row - 1)) {//Same
                    int temp = memo[col];
                    memo[col] = prevValueInMemo;
                    prevValueInMemo = temp;
                } else {//Different
                    int temp = memo[col];
                    memo[col] = Math.min(Math.min(memo[col - 1], temp), prevValueInMemo) + 1;
                    prevValueInMemo = temp;
                }
            }
        }

        return memo[memo.length - 1];
    }

    public static void main(String[] args) {
        EditDistance72 sol = new EditDistance72();
        System.out.println(sol.minDistance("sea", "ate"));
    }
}

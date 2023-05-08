package com.p2.random.topinterviewques;

public class ClimbingStairs70 {

    public int climbStairs_dp_iteration_lookBack(int n) {
        int memo1 = 1, memo2 = 1;

        for(int i = 2; i <= n; i++) {
            int temp = memo2 + memo1;
            memo1 = memo2;
            memo2 = temp;
        }
        return memo2;
    }

    public int climbStairs_dp_iteration_lookahead(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for(int i = 0; i <= n - 1; i++) {
            memo[i+1] += memo[i];
            if(i+2 <= n)
                memo[i+2] += memo[i];
        }
        return memo[memo.length - 1];
    }

    public static void main(String[] args) {
        ClimbingStairs70 sol = new ClimbingStairs70();
        System.out.println(sol.climbStairs_dp_iteration_lookBack(2) == 2);
        System.out.println(sol.climbStairs_dp_iteration_lookBack(3) == 3);
    }
}

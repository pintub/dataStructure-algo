package year2k21.common.pattern.dp.date21022023;

public class ClimbingStairs70 {

    public int climbStairs(int n) {
        int[] memo = new int[n+1];//Including ZERO

        return climbStairs(n, memo);
    }

    public int climbStairs(int n, int[] memo) {
        if(memo[n] != 0) {
            return memo[n];
        }

        if(n == 0) {
            memo[n] = 1;
            return memo[n];
        }

        memo[n] = climbStairs(n-1, memo) +
                (n-2 >= 0 ? climbStairs(n-2, memo) : 0) ;

        return memo[n];
    }
}

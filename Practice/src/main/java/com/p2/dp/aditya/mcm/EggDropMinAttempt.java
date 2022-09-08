package com.p2.dp.aditya.mcm;

import java.util.*;

/**
 * If you get DP Choice + Base Conditions, you can solve this
 *
 * DP Choice 2 level
 *      1st level partition from floor [1 to floorMax]
 *      2nd level at each partition or floor, if egg drops
 *                          solve(eggCount, fCount) @Partition kth floor
 *                          /          \
 *                         /(Egg brks)  \(Egg Not brks)
 *                        /(Go Down)     \(Go Up)
 *                       /                \
 *        solve(eggCount-1,k-1)   solve(eggCount,TotalFloor-k)//Remember this (TotalFloor-k) not (fCount+1), as we want #floors here
 *
 *
 *   Base Condition
 *          if egg =0, attempt=0, if egg=1, attempt=f(with 1 egg you will go simply bottom-up)
 *          if floor =0, attempt=0, if floor=1, attempt=1
 *
 *   memo [eggCount+1][floorCount+1] // Incl ZERO indices
 */
public class EggDropMinAttempt {

    int countAttempt(int eggCount, int floorCount) {
        int[][] memo = new int[eggCount+1][floorCount+1];
        for(int[] row : memo) {//initialize -1
            Arrays.fill(row, -1);
        }

        return recursion(eggCount, floorCount, memo);
    }

    private int recursion(int eggCount, int floorCount, int[][] memo) {

        if(memo[eggCount][floorCount] != -1) {
            return memo[eggCount][floorCount];
        }
        if(eggCount == 1) {
            memo[eggCount][floorCount] = floorCount;
            return floorCount;
        }

        if(eggCount == 0) {
            memo[eggCount][floorCount] = 0;
            return 0;
        }

        if(floorCount == 0) {
            memo[eggCount][floorCount] = 0;
            return 0;
        }

        if(floorCount == 1) {
            return 1;
        }

        int minAttempt = Integer.MAX_VALUE;

        for(int partition = 1; partition <= floorCount; partition++) {//Incl. top floor
            int temp = 1 + Math.max(//Math.max because any floor can be threshold floor, so we have to go both side to see worst case attempt
                    recursion(eggCount - 1, partition - 1, memo),
                    recursion(eggCount, floorCount - partition, memo)
                );
            minAttempt = Math.min(minAttempt, temp);//math.min base of result, we can decide which partition to choose for min# attempts
        }

        memo[eggCount][floorCount] = minAttempt;
        return minAttempt;
    }

    public static void main(String[] args) {
        System.out.println(new EggDropMinAttempt().countAttempt(2, 36) == 8);
        System.out.println(new EggDropMinAttempt().countAttempt(2, 6) == 3);
    }
}

package com.p2.random.topinterviewques.date042024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * I Did it
 *
 * Same intuition, Better readable solution of O(2n) with O(n) space
 *  https://leetcode.com/problems/candy/solutions/4037646/99-20-greedy-two-one-pass/?envType=study-plan-v2&envId=top-interview-150
 *
 *  O(n) Solution with O(1) space
 *      https://leetcode.com/problems/candy/solutions/135698/simple-solution-with-one-pass-using-o-1-space/?envType=study-plan-v2&envId=top-interview-150
 */
public class Candy135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 0);

        if(ratings.length == 1)//1 child
            return 1;

        List<Integer> localMinimaIndices = new ArrayList<>();

        //O(n)
        for(int idx = 0; idx < ratings.length; idx++) {
            if(isLocalMinima(ratings, idx)) {
                localMinimaIndices.add(idx);
            }
        }

        //O(n)
        for(int index : localMinimaIndices) {//Check left and right side of index and reach till local maxima
            int tempidx = index;
            int localCount = 1;
            candies[tempidx] = 1;
            while(tempidx - 1 >= 0 && ratings[tempidx - 1] >= ratings[tempidx]) {//Check Left
                if(ratings[tempidx - 1] == ratings[tempidx]) {
                    localCount = 1;
                } else {
                    ++localCount;
                }
                --tempidx;
                candies[tempidx] = Math.max(candies[tempidx], localCount);
            }

            tempidx = index;
            localCount = 1;
            while(tempidx + 1 < ratings.length && ratings[tempidx] <= ratings[tempidx + 1]) {//Check Right
                if(ratings[tempidx] == ratings[tempidx + 1]) {
                    localCount = 1;
                } else {
                    ++localCount;
                }
                ++tempidx;
                candies[tempidx] = Math.max(candies[tempidx], localCount);
            }

        }

        int result  = 0;
        for(int candy : candies) {
            result += candy;
        }
        return result;
    }

    boolean isLocalMinima(int[] ratings, int index) {
        return index == 0 ?
                ratings[index] < ratings[index + 1] :
                index == ratings.length - 1 ?
                ratings[index - 1] > ratings[index] :
                        (ratings[index] <= ratings[index + 1] && ratings[index - 1] >= ratings[index]) && (ratings[index] < ratings[index + 1] || ratings[index - 1] > ratings[index]);
    }

    public static void main(String[] args) {
        Candy135 sol = new Candy135();
        System.out.println(sol.candy(new int[]{1,2,87,87,87,2,1}));
    }
}

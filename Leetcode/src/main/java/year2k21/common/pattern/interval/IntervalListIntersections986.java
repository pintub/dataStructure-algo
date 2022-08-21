package year2k21.common.pattern.interval;

import java.util.*;

public class IntervalListIntersections986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        if(firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }

        //Below is like merging 2 sorted arrays
        int firstListCount = 0, secondListCount = 0;
        while (firstListCount < firstList.length && secondListCount < secondList.length){
            if(firstList[firstListCount][1] <= secondList[secondListCount][1]){
                if(secondList[secondListCount][0] <= firstList[firstListCount][1]) {
                    result.add(new int[]{Math.max(secondList[secondListCount][0], firstList[firstListCount][0])
                            , Math.min(secondList[secondListCount][1], firstList[firstListCount][1])});
                }
                ++firstListCount;
            } else if (secondList[secondListCount][1] <= firstList[firstListCount][1] ){
                if(firstList[firstListCount][0] <= secondList[secondListCount][1]){
                    result.add(new int[]{Math.max(secondList[secondListCount][0], firstList[firstListCount][0])
                            , Math.min(secondList[secondListCount][1], firstList[firstListCount][1])});
                }
                ++secondListCount;
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] result = new IntervalListIntersections986().intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}
                , new int[][]{{1,5},{8,12},{15,24},{25,26}});
        System.out.println(result);
    }
}

package year2k21.common.pattern.interval;

import java.util.*;

/**
 * Greedy problem
 */
public class NonOverlappingIntervals435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int count= 0;

        //Sort
        Arrays.sort(intervals,
                (interval1,interval2) -> Integer.compare(interval1[0], interval2[0])
        );

        for(int idx = 1; idx < intervals.length; idx++) {
            if(intervals[idx][0] < intervals[idx - 1][1]) {//Overlap
                count++;
                //Eliminate interval with higher end value by manipulating current element
                intervals[idx][1] = Math.min(intervals[idx][1], intervals[idx-1][1]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NonOverlappingIntervals435().eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }
}

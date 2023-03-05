package year2k21.common.pattern.interval.date05032023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class NonOverlappingIntervals435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int count= 0;

        //Sort
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0])
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
        NonOverlappingIntervals435 sol = new NonOverlappingIntervals435();
        System.out.println(sol.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}) == 1);
        System.out.println(sol.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}) == 2);
        System.out.println(sol.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}) == 0);
    }
}

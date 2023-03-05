package year2k21.common.pattern.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Start with Binary Search , code gets messy
 *
 * O(n) solution is fine, Copied Solution
 * 3 loop
 *      Add interval if less than newInterval
 *      Resolve overlapped intervals
 *      Add rest of intervals
 *
 * Note: Struggled in isOverLapping() method
 */
public class InsertInterval57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int intervalCounter = 0;

        //Push intervals less than newInterval
        while (intervalCounter < intervals.length && !isOverLapping(intervals[intervalCounter], newInterval)
        && intervals[intervalCounter][0] < newInterval[0] && intervals[intervalCounter][1] < newInterval[1]) {//!isOverLapping(intervals[intervalCounter], newInterval) && intervals[intervalCounter][0] < newInterval[0] && intervals[intervalCounter][1] < newInterval[1] Can be simplified if end of current interval < start of new interval
            result.add(new int[]{intervals[intervalCounter][0], intervals[intervalCounter][1]});
            ++intervalCounter;
        }

        //Resolve overlapping
        while (intervalCounter < intervals.length && isOverLapping(intervals[intervalCounter], newInterval)) {//isOverLapping can be simplified if start of newInterval in between interval
            newInterval = new int[] {Math.min(intervals[intervalCounter][0], newInterval[0]),
                    Math.max(intervals[intervalCounter][1], newInterval[1])};
            ++intervalCounter;
        }
        result.add(newInterval);

        //Push intervals greater than newInterval
        while (intervalCounter < intervals.length) {
            result.add(intervals[intervalCounter]);
            ++intervalCounter;
        }
        return result.toArray(new int[result.size()][2]);
    }

    private boolean isOverLapping(int[] interval, int[] newInterval) {
        return (interval[0] >= newInterval[0] && interval[0] <= newInterval[1]
                || interval[1] >= newInterval[0] && interval[1] <= newInterval[1]
                || newInterval[0] >= interval[0] && newInterval[0] <= interval[1]
                || newInterval[1] >= interval[0] && newInterval[1] <= interval[1]);
    }

    public static void main(String[] args) {
        //int[][] input = new int[][]{{1,3}, {6,9}};
        int[][] input = new int[][] {{1,2}, {3,5} ,{6,7},{8,10},{12,16}};
        System.out.println(Arrays.toString(input));
        int[][] result = new InsertInterval57().insert(new int[][] {{1, 5}}, new int[]{0, 0});
        System.out.println(Arrays.toString(result));
    }
}

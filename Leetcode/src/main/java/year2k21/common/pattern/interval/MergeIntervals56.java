package year2k21.common.pattern.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Sort the array increasing order of start elements
 * Then traverse and merge
 *
 * Tricks
 *      - While Merging interval, don't remove and add, Rather actually merge last-interval
 *      - If overlapped, lastIntervalFromResult[1] = Math.max(lastIntervalFromResult[1], currentInterval[1]); This is for cases like [10, 15] , [11, 14]
 **/
public class MergeIntervals56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList();

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int[] lastIntervalFromResult = null;

        for(int count=0; count < intervals.length; ++count) {
            int[] currentInterval = intervals[count];
            if(count == 0) {
                result.add(currentInterval);
                lastIntervalFromResult = currentInterval;
                continue;
            }

            //int[] lastIntervalFromResult = result.get(result.size() - 1);
            if(isOverlapped(lastIntervalFromResult, currentInterval)) {
                lastIntervalFromResult[1] = Math.max(lastIntervalFromResult[1], currentInterval[1]);
            } else {
                result.add(currentInterval);
                lastIntervalFromResult = currentInterval;
            }
        }

        return result.toArray(new int[][]{});
    }

    private boolean isOverlapped(int[] interval1, int[] interval2) {
        return interval2[0] <= interval1[1];
    }
}

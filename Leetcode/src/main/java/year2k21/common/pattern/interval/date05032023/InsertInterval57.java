package year2k21.common.pattern.interval.date05032023;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean isNewIntervalMerged = false;

        for (int[] currentInterval : intervals) {
            if (!isNewIntervalMerged && isLessThan(currentInterval, newInterval)) {
                result.add(newInterval);
                result.add(currentInterval);
                isNewIntervalMerged = true;
            } else if (!isNewIntervalMerged && isOverlapped(currentInterval, newInterval)) {
                currentInterval[1] = Math.max(currentInterval[1], newInterval[1]);
                currentInterval[0] = Math.min(currentInterval[0], newInterval[0]);
                result.add(currentInterval);
                isNewIntervalMerged = true;
            } else {
                result.add(currentInterval);
            }
        }

        if(!isNewIntervalMerged) {
            result.add(newInterval);
        }

        return result.toArray(new int[][]{});
    }

    private boolean isLessThan(int[] interval1, int[] interval2) {
        return interval2[1] < interval1[0];
    }

    private boolean isOverlapped(int[] interval1, int[] interval2) {
        return interval1 != null && interval2[0] <= interval1[1];
    }
}

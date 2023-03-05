package year2k21.common.pattern.interval.date05032023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Can be solved by single pass
 */
public class IntervalListIntersections986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> mergedList = merge(firstList, secondList);//O(m+n), Merge by start-value
        List<int[]> result = new ArrayList<>();

        int[] lastInterval = null;

        for(int[] interval : mergedList) {//O(m+n)
            if(lastInterval != null && interval[0] <= lastInterval[1]) {
                result.add(new int[]{interval[0], Math.min(lastInterval[1], interval[1])});
            }

            if(lastInterval == null || lastInterval[1] < interval[1]) {
                lastInterval = interval;
            }
        }

        return result.toArray(new int[][]{});
    }

    private List<int[]> merge(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int firstListPointer  = 0;
        int secondListPointer  = 0;

        while (firstListPointer != firstList.length && secondListPointer != secondList.length) {
            if(secondList[secondListPointer][0] <= firstList[firstListPointer][0]) {
                result.add(secondList[secondListPointer]);
                ++secondListPointer;
            } else if (firstList[firstListPointer][0] <= secondList[secondListPointer][0]) {
                result.add(firstList[firstListPointer]);
                ++firstListPointer;
            }
        }

        while (firstListPointer < firstList.length) {
            result.add(firstList[firstListPointer]);
            ++firstListPointer;
        }

        while (secondListPointer < secondList.length) {
            result.add(secondList[secondListPointer]);
            ++secondListPointer;
        }

        return result;
    }

    public static void main(String[] args) {
        IntervalListIntersections986 sol = new IntervalListIntersections986();
        //int[][] result = sol.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        int[][] result = sol.intervalIntersection(new int[][]{{1, 3}, {5, 9}}, new int[][]{});
        for(int[] arr :result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

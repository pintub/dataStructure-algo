package year2k21.common.pattern.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Question : https://aaronice.gitbook.io/lintcode/sweep-line/meeting-rooms-ii
//Minimum number of conference rooms required
public class MeetingRoomsII_LeetCodePremium {

    //Assume minimal 1 interval in input
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        Queue<Integer> descendingEndValues = new PriorityQueue<>();
        descendingEndValues.add(intervals[0][1]);
        int result = 1;

        for(int count = 1; count < intervals.length; count++) {//O(n)
            int[] currentInterval = intervals[count];
            if(currentInterval[0] < descendingEndValues.peek()) {
                result++;
                descendingEndValues.add(currentInterval[1]);
            } else {//O(logn)
                descendingEndValues.remove();
                descendingEndValues.add(currentInterval[1]);
            }
        }//TotalO(nlogn)

        return result;
    }
}

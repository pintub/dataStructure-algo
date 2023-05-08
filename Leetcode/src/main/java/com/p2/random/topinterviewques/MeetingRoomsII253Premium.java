package com.p2.random.topinterviewques;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.ca/all/253.html
 */
public class MeetingRoomsII253Premium {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        Queue<Integer> minHeapOfEndingTime = new PriorityQueue<>();

        minHeapOfEndingTime.add(intervals[0][1]);
        int roomCount = 1;
        for(int intervalIdx = 1; intervalIdx < intervals.length; intervalIdx++) {
            int minEndingTime = minHeapOfEndingTime.peek();
            if(intervals[intervalIdx][0] < minEndingTime){
                ++roomCount;
                minHeapOfEndingTime.add(intervals[intervalIdx][1]);
            } else {//continue is same room as that of minEndingTime
                minHeapOfEndingTime.remove();
                minHeapOfEndingTime.add(intervals[intervalIdx][1]);
            }
        }

        return roomCount;
    }
}

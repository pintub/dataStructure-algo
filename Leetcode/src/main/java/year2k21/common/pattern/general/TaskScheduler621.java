package year2k21.common.pattern.general;

import java.util.*;

/**
 * I had quit, solutions are simply fluke.
 * Note: This has no relation to interval questions & This is definitely not Medium problem :(
 *
 * https://leetcode.com/problems/task-scheduler/discuss/760131/Java-Concise-Solution-Intuition-Explained-in-Detail
 * {A,A,A,B,B,B,C,C,C,D,E,D} -> This is a bouncer
 */
public class TaskScheduler621 {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int m = tasks.length;
        int[] charVsFreq = new int[26];
        /* Build the count array with frequency of each task */
        for (char task: tasks) {
            charVsFreq[task - 'A']++;
        }
        Arrays.sort(charVsFreq); //Ascending order

        int singleGapOfMaxFreqChar = charVsFreq[25]-1;
        int idleSpaces = singleGapOfMaxFreqChar * n;//Gap between each high frequency same-letter

        /* Iterate over rest of the array and reduce the idle space count */
        for (int i = 24; i >= 0; i--) {//Decreasing order as sorting is ascending
            idleSpaces -= Math.min(singleGapOfMaxFreqChar, charVsFreq[i]);//If charVsFreq[i]>singleGapOfMaxFreqChar, it will lie right to high frequent char
        }

        return idleSpaces > 0 ? tasks.length + idleSpaces : tasks.length;
    }

    public static void main(String[] args) {
        //System.out.println(new TaskScheduler621().leastInterval(new char[]{'A','A','A','B','B','B'}, 2) == 8);
        //System.out.println(new TaskScheduler621().leastInterval(new char[]{'A','B','C','D','E','A','B','C','D','E'}, 4) == 10);
        System.out.println(new TaskScheduler621().leastInterval(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2) == 12);
    }

}

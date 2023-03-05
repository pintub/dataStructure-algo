package year2k21.common.pattern.interval.date05032023;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(xCoordinate -> xCoordinate[0]));

        int result = 1;
        int bestEndValue = points[0][1];

        for(int count = 1; count < points.length; count++) {
            int[] currentXCoordinate = points[count];

            if(currentXCoordinate[0] <= bestEndValue) {
                bestEndValue = Math.min(bestEndValue, currentXCoordinate[1]);
            } else {
                bestEndValue = currentXCoordinate[1];
                ++result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons452 sol = new MinimumNumberOfArrowsToBurstBalloons452();
        System.out.println(sol.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}) == 2);
        System.out.println(sol.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}) == 4);
        System.out.println(sol.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}) == 2);
    }
}

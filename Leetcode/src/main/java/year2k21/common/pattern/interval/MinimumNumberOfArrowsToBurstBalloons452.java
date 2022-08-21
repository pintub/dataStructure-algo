package year2k21.common.pattern.interval;

import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons452 {

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points,
                (point1, point2) -> Integer.compare(point1[0], point2[0])
        );

        int lastBalloonBurstPoint = points[0][1];//Xend of 1st balloon
        int balloonBurstCount = 0;
        for(int counter = 1; counter < points.length; counter++){
            if(points[counter][0] <= lastBalloonBurstPoint) {//Overlap
                //Don't burst balloons yet, next balloon may fall in vertical line
                lastBalloonBurstPoint = Math.min(lastBalloonBurstPoint, points[counter][1]);
                continue;
            }
            lastBalloonBurstPoint = points[counter][1];
            ++balloonBurstCount;
        }
        return balloonBurstCount + 1;
    }

    public static void main(String[] args) {
        //System.out.println(new MinimumNumberOfArrowsToBurstBalloons452().findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}) == 2);
        //System.out.println(new MinimumNumberOfArrowsToBurstBalloons452().findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}) == 4);
        //System.out.println(new MinimumNumberOfArrowsToBurstBalloons452().findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}) == 2);
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons452().findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}) == 2);

    }
}

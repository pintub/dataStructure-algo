package com.p2.random.topinterviewques.date042024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnALine149 {
    public int maxPoints(int[][] points) {
        int max = 1;
        Map<Double, Set<Integer>> slopeVsPointIndices = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            //slopeVsPointIndices = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                double slope = (points[j][0] == points[i][0]) ? Double.MAX_VALUE : (points[j][1] == points[i][1]) ? 0 :((double) (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]));
                Set<Integer> temp = slopeVsPointIndices.getOrDefault(slope , new HashSet<>());
                temp.add(i);
                temp.add(j);

                slopeVsPointIndices.put(slope , temp);

                max = Math.max(max , temp.size());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxPointsOnALine149 solution = new MaxPointsOnALine149();
        //System.out.println(solution.maxPoints(new int[][]{{2,3},{3,3},{-5,3}}));

        System.out.println((int)' ');
    }
}

package com.p2.random.topinterviewques;

public class TrappingRainWater42 {

    public int trap(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int leftSideHighest = -1, rightSideHighest = -1;
        int recentlyMovedIndex = 0;
        int waterContained = 0;
        while (low < high) {
            leftSideHighest = Math.max(leftSideHighest, height[low]);
            rightSideHighest = Math.max(rightSideHighest, height[high]);
            waterContained += Math.min(leftSideHighest, rightSideHighest) > height[recentlyMovedIndex] ? Math.min(leftSideHighest, rightSideHighest) - height[recentlyMovedIndex] : 0;

            if(leftSideHighest <= rightSideHighest) {
                ++low;
                recentlyMovedIndex = low;
            } else {
                --high;
                recentlyMovedIndex = high;
            }
        }

        return waterContained;
    }

    public static void main(String[] args) {
        TrappingRainWater42 sol = new TrappingRainWater42();
        System.out.println(sol.trap(new int[]{4,2,0,3,2,5}));
    }
}

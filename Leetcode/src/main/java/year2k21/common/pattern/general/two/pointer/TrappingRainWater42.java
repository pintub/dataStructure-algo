package year2k21.common.pattern.general.two.pointer;

/**
 * Same concept as {@link year2k21.common.pattern.general.two.pointer.ContainerWithMostWater11}
 * 2 pointer,Move the smaller pointer to make the height bigger
 * Another 2 pointer(leftMaxHeightIdx, rightMaxHeightIdx), to keep track of maxHeightIdx at both sides
 * At any place, the water held  = Math.min(height[leftMaxHeightIdx], height[rightMaxHeightIdx]) - height[current-place]
 */
public class TrappingRainWater42 {

    public int trap(int[] height) {
        int length = height.length;
        if(length == 1 || length == 2) {
            return 0;
        }

        int water = 0;
        int left = 0, right = length - 1;
        int leftMaxHeightIx = 0, rightMaxHeightIdx = length - 1;
        Boolean hasLeftMoved = null;//Invalid value at Start
        while (left <= right) {
            if(hasLeftMoved != null) {//Ignore for 1st iteration
                int recentlyMovedToIdx = hasLeftMoved ? left : right;
                water += (height[recentlyMovedToIdx] < height[leftMaxHeightIx] && height[recentlyMovedToIdx] < height[rightMaxHeightIdx]) ?
                        Math.min(height[leftMaxHeightIx], height[rightMaxHeightIdx]) - height[recentlyMovedToIdx]  :
                        0;

                if(hasLeftMoved) {
                    leftMaxHeightIx = (height[recentlyMovedToIdx] > height[leftMaxHeightIx]) ? recentlyMovedToIdx : leftMaxHeightIx;
                } else {
                    rightMaxHeightIdx = (height[recentlyMovedToIdx] > height[rightMaxHeightIdx]) ? recentlyMovedToIdx : rightMaxHeightIdx;
                }
            }

            if(height[left] < height[right]) {//Move smaller to increase height
                 ++left;
                 hasLeftMoved = true;
            } else {
                --right;
                hasLeftMoved = false;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        //System.out.println(new TrappingRainWater42().trap(new int[]{4,2,0,3,2,5}) == 9);
        //System.out.println(new TrappingRainWater42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) == 6);
        System.out.println(new TrappingRainWater42().trap(new int[]{2,0,1,0,3}));
    }
}

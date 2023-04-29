package year2k21.common.pattern.general.two.pointer.date17042023;

/**
 * Same concept as {@link year2k21.common.pattern.general.two.pointer.date17042023.ContainerWithMostWater11}
 * 2 pointer,Move the smaller pointer to make the height bigger
 * Another 2 pointer(leftMaxHeightIx, rightMaxHeightIdx), to keep track of maxHeightIdx at both sides, at any place, the water held  = Math.min(leftMaxHeight, rightMaxHeight) - height[current-place]
 */
public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] <= height[right])//Comparing height of both sides
                left++;
            else
                right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater11 sol = new ContainerWithMostWater11();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}) == 49);
        System.out.println(sol.maxArea(new int[]{1,1}) == 1);
    }
}

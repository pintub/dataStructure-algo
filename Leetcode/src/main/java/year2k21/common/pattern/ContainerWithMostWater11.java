package year2k21.common.pattern;

/**
 * Could not solve
 * https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation
 * 2 pointer solution from both sides, as width decrease try to increase width by looking for higher left or right value
 */
public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;//For height[left] == height[right] as well reduce right pointer
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater11().maxArea(new int[]{3, 7, 1, 7, 3}) == 14);
        System.out.println(new ContainerWithMostWater11().maxArea(new int[]{1,0}) == 0);
        System.out.println(new ContainerWithMostWater11().maxArea(new int[]{1,1}) == 1);
    }
}

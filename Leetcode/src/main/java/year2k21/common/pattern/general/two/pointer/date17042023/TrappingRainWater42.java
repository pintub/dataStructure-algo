package year2k21.common.pattern.general.two.pointer.date17042023;

public class TrappingRainWater42 {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMaxHeightIdx = 0;
        int rightMaxHeightIdx = height.length - 1;
        boolean hasLeftMoved = (height[left] <= height[right]);

        int result = 0;

        while(left < right) {//TODO
            if(height[left] > height[leftMaxHeightIdx]) {
                leftMaxHeightIdx = left;
            }
            if(height[right] > height[rightMaxHeightIdx]) {
                rightMaxHeightIdx = right;
            }
            int temp = Math.min(height[leftMaxHeightIdx], height[rightMaxHeightIdx]) - (hasLeftMoved ? height[left] : height[right]);
            if(temp > 0 ) {
                result += temp;
            }
            if(height[left] <= height[right]) {
                ++left;
                hasLeftMoved = true;
            } else {
                --right;
                hasLeftMoved = false;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater42 sol = new TrappingRainWater42();
        System.out.println(sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));//6
        System.out.println(sol.trap(new int[]{4,2,0,3,2,5}));//9
    }
}

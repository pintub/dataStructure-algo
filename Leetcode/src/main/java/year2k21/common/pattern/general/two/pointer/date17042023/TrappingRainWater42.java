package year2k21.common.pattern.general.two.pointer.date17042023;

public class TrappingRainWater42 {

    public int trap(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int newPosition = -1;
        int trappingWater = 0;
        int lowMaxHeight = height[low];
        int highMaxHeight = height[high];

        while (low < high) {
            if(newPosition != -1) {
                int temp =Math.min(lowMaxHeight, highMaxHeight) - height[newPosition];
                trappingWater += temp > 0 ? temp : 0 ;
            }
            if(height[low] <= height[high]) {//Compare both sides
                ++low;
                newPosition = low;
                lowMaxHeight = Math.max(lowMaxHeight, height[low]);
            } else {
                --high;
                newPosition = high;
                highMaxHeight = Math.max(highMaxHeight, height[high]);
            }
        }

        return trappingWater;
    }

    public static void main(String[] args) {
        TrappingRainWater42 sol = new TrappingRainWater42();
        System.out.println(sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));//6
        System.out.println(sol.trap(new int[]{4,2,0,3,2,5}));//9
    }
}

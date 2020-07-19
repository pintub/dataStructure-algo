public class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int output = 0;
        for(int count = 0; count < points.length-1; count++){
            output += distance(points[count], points[count+1]);
        }
        return output;
    }

    private int distance(int[] point1, int[] point2) {
        return Math.max(Math.abs(point1[1] - point2[1]) ,
                    Math.abs(point1[0] - point2[0]));
    }

    public static void main(String[] args) {
        System.out.println(new Solution1266().minTimeToVisitAllPoints(new int[][]{{559,511},{932,618}}));
    }
}

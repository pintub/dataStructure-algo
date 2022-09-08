package year2k21.common.pattern.binarysearch;

/**
 * 1st search row , then search column in above row
 * Time = logm+logn = log(mn)??
 * <p>
 * I made a mess of this using Recursion,
 * Refer Leetcode solution on same idea https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list/178290
 */
public class Search2DMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int low = -1;
        int high= -1;

        // first search in first column, use binary search, Coincidently same code works
        for (low = 0, high = matrix.length - 1; low <= high; ) {
            int middle = (low + high) / 2;
            if (matrix[middle][0] < target) {
                low = middle + 1;
            } else if (matrix[middle][0] > target) {
                high = middle - 1;
            } else {
                return true;
            }
        }

        // when above loop ends, search in selectedRow[high]
        int selectedRow = high;
        if (selectedRow < 0) {
            return false;
        }

        for (low = 0, high = matrix[selectedRow].length - 1; low <= high; ) {
            int middle = (low + high) / 2;
            if (matrix[selectedRow][middle] < target) {
                low = middle + 1;
            } else if (matrix[selectedRow][middle] > target) {
                high = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Search2DMatrix74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 11));//true
        //System.out.println(new Search2DMatrix74().searchMatrix(new int[][]{{1, 3}}, 2));//false
        //System.out.println(new Search2DMatrix74().searchMatrix(new int[][]{{1}, {3}}, 2));//false
        //System.out.println(new Search2DMatrix74().searchMatrix(new int[][]{{-10, -8}, {-6, -5}, {-2, -2}, {-1, 0}, {3, 4}, {7, 7}, {8, 9}, {10, 10}, {11, 11}, {12, 14}, {15, 16}, {17, 19}, {20, 21}, {22, 22}, {25, 27}, {28, 30}, {32, 32}, {35, 36}}, 16));//true

    }
}

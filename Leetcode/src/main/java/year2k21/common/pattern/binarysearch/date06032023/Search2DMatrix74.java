package year2k21.common.pattern.binarysearch.date06032023;

public class Search2DMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        //Search in 1st Column
        int rowIndex = getRowIndex(matrix, target);
        if(rowIndex < 0)
            return false;

        //Search in Row with Dups
        return searchRowWithDups(matrix[rowIndex], target);
    }

    private boolean searchRowWithDups(int[] row, int target) {
        int low = 0, high = row.length - 1;

        while (low <= high) {
            //Squeeze by removing Dups
            while (low <= high && low + 1 <= row.length - 1 && row[low] == row[low + 1]) {
                ++low;
            }

            while (low <= high && high - 1 >= 0 && row[high] == row[high - 1]) {
                --high;
            }

            int mid = (low + high)/2;

            if(row[mid] == target)
                return true;

            if(target < row[mid]){
                high = mid - 1;
            } else if(target > row[mid]) {
                low = mid + 1;
            }
        }

        return false;
    }

    private int getRowIndex(int[][] matrix, int target) {//No Dups
        int low = 0, high = matrix.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            }

            if(target < matrix[mid][0]) {
                high = mid - 1;
            } else if(target > matrix[mid][matrix[0].length - 1]) {
                low = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        //System.out.println(new Search2DMatrix74().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 11));//true
        //System.out.println(new Search2DMatrix74().searchMatrix(new int[][]{{1, 3}}, 2));//false
        //System.out.println(new Search2DMatrix74().searchMatrix(new int[][]{{1}, {3}}, 2));//false
        System.out.println(new Search2DMatrix74().searchMatrix(new int[][]{{-10, -8}, {-6, -5}, {-2, -2}, {-1, 0}, {3, 4}, {7, 7}, {8, 9}, {10, 10}, {11, 11}, {12, 14}, {15, 16}, {17, 19}, {20, 21}, {22, 22}, {25, 27}, {28, 30}, {32, 32}, {35, 36}}, 16));//true

    }
}

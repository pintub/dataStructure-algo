import java.util.*;

public class Solution1380 {

    //Brute Force 2 * O(m*n)
    public List<Integer> luckyNumbersV2 (int[][] matrix) {
        int rowSize =  matrix.length;
        int columnSize = matrix[0].length;

        Set<Integer> columnIndicesOfRowMins = new HashSet<>(columnSize);//Store column index of all row mins
        //Only columnIndicesOfRowMins will be iterated in 2nd outer for loop

        Set<Integer> rowMins = new HashSet<>();//Store Row mins

        List<Integer> luckyNumbers = new ArrayList<>();


        for(int row = 0; row < rowSize; row++){
            int min = 100001; int minColumn = 0;
            for(int column = 0; column < columnSize; column++){
                if(matrix[row][column] < min){
                    min = matrix[row][column];
                    minColumn = column;
                }
            }
            columnIndicesOfRowMins.add(minColumn);
            rowMins.add(min);
        }

        for(int column : columnIndicesOfRowMins){
            int max = 0;
            for(int row = 0; row < rowSize; row++){
                if(matrix[row][column] > max){
                    max = matrix[row][column];
                }
            }
            if(!rowMins.add(max)){
                luckyNumbers.add(max);
            }
        }
        return luckyNumbers;
    }

    //O(m*n)+O(m)
    public List<Integer> luckyNumbers(int[][] matrix) {

        int rowSize =  matrix.length;
        int columnSize = matrix[0].length;

        int columnIndexOfMaxOfRowMin = -1;//Column index of Lowest row minimum
        int maxOfRowMin = -1 ;//Lowest row minimum

        for(int row = 0; row < rowSize; row++){
            int min = 100001; int minColumn = 0;
            for(int column = 0; column < columnSize; column++){
                if(matrix[row][column] < min){
                    min = matrix[row][column];
                    minColumn = column;
                }
            }
            if(min > maxOfRowMin){
                maxOfRowMin = min;
                columnIndexOfMaxOfRowMin = minColumn;
            }
        }

        for(int row = 0; row < rowSize; row++){
            if(matrix[row][columnIndexOfMaxOfRowMin] > maxOfRowMin){
                return Collections.emptyList();
            }
        }

        List<Integer> luckyNumbers =  new ArrayList<>();
        luckyNumbers.add(maxOfRowMin);

        return luckyNumbers;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1380().luckyNumbers(new int[][]{{7,8},{1,2}}));
    }
}

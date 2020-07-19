public class Solution1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int oddCellCount = 0;
        int[][] initArray = new int[n][m];
        for (int count = 0; count < indices.length; count++) {
            oddCellCount += addOneToRow(initArray, indices[count][0], m);
            oddCellCount += addOneToColumn(initArray, indices[count][1], n);
        }
        return oddCellCount;
    }

    private int addOneToRow(int[][] array, int rowIndex, int columnSize){
        int changeInOddCellCount = 0;
        for(int count = 0; count < columnSize; count++){
            if(array[rowIndex][count] % 2 ==0){
                ++changeInOddCellCount;
            } else {
                --changeInOddCellCount;
            }
            array[rowIndex][count] += 1;
        }
        return changeInOddCellCount;
    }

    private int addOneToColumn(int[][] array, int columnIndex, int rowSize){
        int changeInOddCellCount = 0;
        for(int count = 0; count < rowSize; count++){
            if(array[count][columnIndex] % 2 ==0){
                ++changeInOddCellCount;
            } else {
                --changeInOddCellCount;
            }
            array[count][columnIndex] += 1;
        }
        return changeInOddCellCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1252().oddCells(2, 3, new int[][]{{0,1},{1,1}}));
    }
}

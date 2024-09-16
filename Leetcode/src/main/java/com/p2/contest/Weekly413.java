package com.p2.contest;

import java.util.*;
import java.util.stream.Collectors;

public class Weekly413 {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        boolean result = getColor(coordinate1) ==  getColor(coordinate2);

        System.out.println(result);
        return result;
    }

    //1 if White, 0 if Black
    private int getColor(String coordinate) {
        int column = coordinate.charAt(0) - 'a';
        int row = (coordinate.charAt(1) - '0') - 1;

        return (column + row) % 2  == 0 ? 0 : 1 ;
    }

    public int[] resultsArray(int[][] queries, int k) {
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        if(k > queries.length) {
            return result;
        }

        Queue<int[]> maxHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(Math.abs(pair2[0]) + Math.abs(pair2[1]), Math.abs(pair1[0]) + Math.abs(pair1[1])));

        for(int count = 0; count < queries.length; count++) {
            int[] query = queries[count];
            int[] maxHeapMax = maxHeap.peek();
            if(maxHeap.isEmpty() || maxHeap.size() < k) {
                maxHeap.add(query);
            } else if(Math.abs(query[0]) + Math.abs(query[1]) < Math.abs(maxHeapMax[0]) + Math.abs(maxHeapMax[1])) {
                maxHeap.remove();
                maxHeap.add(query);
            }

            if(maxHeap.size() >= k) {
                maxHeapMax = maxHeap.peek();
                result[count] = Math.abs(maxHeapMax[0]) + Math.abs(maxHeapMax[1]);
            }
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    private int maxScore = 0;
    public int maxScore(List<List<Integer>> grid) {
        int rowLen = grid.size();
        int colLen = grid.get(0).size();
        recursion(0, new HashSet<>(), 0, grid, rowLen) ;

        System.out.println(maxScore);
        return maxScore;
    }

    void recursion(int rowNum, Set<Integer> uniqueCellSet, int uniqueCellSetSum, final List<List<Integer>> grid, final int rowLen){
        if(rowNum >= rowLen) {
            maxScore = Math.max(maxScore, uniqueCellSetSum);
            return;
        }

        boolean isRowSkipped = true;
        for(int cell : grid.get(rowNum)) {
            if(!uniqueCellSet.add(cell)) {//Dup added, so not valid
                continue;
            }

            isRowSkipped = false;
            uniqueCellSetSum += cell;

            recursion(rowNum + 1, uniqueCellSet, uniqueCellSetSum, grid, rowLen);

            uniqueCellSet.remove(cell);
            uniqueCellSetSum -= cell;
        }

        if(isRowSkipped) {
            recursion(rowNum + 1, uniqueCellSet, uniqueCellSetSum, grid, rowLen);
        }
    }

    public static void main(String[] args) {
        Weekly413 weekly413 = new Weekly413();
        /*weekly413.checkTwoChessboards("a1", "c3");
        weekly413.checkTwoChessboards("a1", "h3");
        weekly413.checkTwoChessboards("e6", "d4");*/
        //weekly413.resultsArray(new int[][]{{-6,3}}, 11);
        int[][] arr = {{92 , 11 , 45 , 88 , 38 , 13 , 65 , 85} , {52 , 83 , 3 , 14 , 82 , 51 , 27 , 59} , {65 , 69 , 99 , 27 , 7 , 70 , 39 , 43} , {43 , 46 , 22 , 19 , 75 , 70 , 57 , 50} , {54 , 36 , 91 , 80 , 74 , 43 , 62 , 61} , {35 , 45 , 19 , 32 , 92 , 50 , 93 , 88} , {60 , 15 , 93 , 10 , 89 , 32 , 51 , 11} , {82 , 66 , 42 , 61 , 78 , 94 , 66 , 7} , {75 , 56 , 49 , 78 , 81 , 61 , 79 , 50}};
        List<List<Integer>> grid = new ArrayList<>();
        for(int[] rows : arr) {
            //Arrays.sort(rows);
            grid.add(Arrays.stream(rows).boxed().collect(Collectors.toList()));
        }
        //System.out.println(grid);
        weekly413.maxScore(grid);
    }
}

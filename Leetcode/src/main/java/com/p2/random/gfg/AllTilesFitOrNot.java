package com.p2.random.gfg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllTilesFitOrNot {

    public static void main(String[] args) {
        //System.out.println(AllTilesFitOrNot.ifAllTilesFitOrNot(6, 2, 8, new int[][]{{4,6}, {4,2}, {2,2}, {2,1}}));//false
        System.out.println(AllTilesFitOrNot.ifAllTilesFitOrNot(6, 5, 8, new int[][]{{3,5}, {6,3}, {1,6}, {1,6} }));//false
    }
    public static boolean ifAllTilesFitOrNot(int start, int end, int placesToFill, int[][] tiles) {
        if(tiles.length * 2 != placesToFill) {
            return false;
        }

        Set<String> numberAndTileIndex = new HashSet<>();
        for(int idx = 0; idx <= tiles.length - 1; idx++) {//TODO do we need left and right
            int[] tile = tiles[idx];
            numberAndTileIndex.add(tile[0] + "#" + idx);
            numberAndTileIndex.add(tile[1] + "#" + idx);
        }

        return recursion(start + "#" + -1, end, numberAndTileIndex, 'R', tiles);
    }

    private static boolean recursion(String currentNode, final int end , Set<String> numberAndTileIndex, char leftOrRight, final int[][] tiles) {
        int currentNodeNum = Integer.parseInt(currentNode.split("#")[0]);

        if(currentNodeNum == end && leftOrRight == 'R' && numberAndTileIndex.isEmpty()) {
            return true;
        }

        if(numberAndTileIndex.isEmpty()) {
            System.out.println("How you reached me !!!");
            return false;
        }
        //TODO

        int currentNodeIndex = Integer.parseInt(currentNode.split("#")[1]);

        if(leftOrRight == 'L') {//If currentNode is 'L, Only one next node possible, Uses currentNodeIndex
            int[] tile = tiles[currentNodeIndex];
            int nextNodeNum = (tile[0] == currentNodeNum) ? tile[1] : tile[0];
            String nextNode = nextNodeNum + "#" + currentNodeIndex;
            numberAndTileIndex.remove(nextNode);
            if(recursion(nextNode, end, numberAndTileIndex, 'R', tiles)) {
                return true;
            }
            numberAndTileIndex.add(nextNode);
            return false;
        } else {//If CurrentNode is 'R', All Tiles which has the number is eligible, Uses currentNodeNum
            List<String> candidates = findAllNodesWhichHasTheNumber(numberAndTileIndex, currentNodeNum);
            for(String candidateNode : candidates) {
                numberAndTileIndex.remove(candidateNode);
                if(recursion(candidateNode, end, numberAndTileIndex, 'L', tiles)){
                    return true;
                }
                numberAndTileIndex.add(candidateNode);
            }

            return false;
        }
    }

    //TODO use number vs TileIndices List Mapping
    private static List<String> findAllNodesWhichHasTheNumber(Set<String> numberAndTileIndex , int num) {
        List<String> result = new ArrayList<>();
        for(String node : numberAndTileIndex) {
            if (Integer.parseInt(node.split("#")[0]) == num) {
                result.add(node);
            }
        }

        return result;
    }
}

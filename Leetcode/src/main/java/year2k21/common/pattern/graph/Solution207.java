package year2k21.common.pattern.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Directed Graph Cycle detection
 * - DFS(Recusrion + vis[] + unidirectional[]
 * - BFS(kahn's algo using topo sort) (Queue + incomingDegree[])
 */
public class Solution207 {

    //Cycle => can not finish
    public static boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getAdjacentList(numCourses, prerequisites);
        if(adjList == null) {
            return true;
        }

        return !cycleDetection_DFS(numCourses, adjList);
    }

    public static boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getAdjacentList(numCourses, prerequisites);
        if(adjList == null) {
            return true;
        }
        int[] incomingDegree = getIncomingDegreeArray(numCourses, prerequisites);
        List<Integer> topoSort = new ArrayList<>();

        List<Integer> zeroInDegreeNodes = getZeroIncomingDegreeIndices(numCourses, incomingDegree);

        Queue<Integer> queue = new LinkedList<>();

        if(zeroInDegreeNodes.size() > 0) {
            queue.addAll(zeroInDegreeNodes);
            topoSort.addAll(zeroInDegreeNodes);
        }
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for(int neighbor : adjList.get(currentNode)) {
                --incomingDegree[neighbor];
                if(incomingDegree[neighbor] == 0){
                    queue.add(neighbor);
                    topoSort.add(neighbor);
                }
            }
        }

        return (topoSort.size() == numCourses);//Same means no cycle, can finish. Not same=>cycle=>can't finish
    }

    private static int[] getIncomingDegreeArray(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return null;
        }
        int[] incomingDegreeArray = new int[numCourses];//Initialized to 0

        for(int[] row : prerequisites) {//Each row has 2 elements [a, b] which is b->a
            ++incomingDegreeArray[row[0]];
        }

        return incomingDegreeArray;
    }

    private static List<Integer> getZeroIncomingDegreeIndices(int numCourses, int[] incomingDegreeArray){
        List<Integer> result = new ArrayList<>();
        for(int idx=0; idx<numCourses; idx++){
            if (incomingDegreeArray[idx] == 0) {
                result.add(idx);
            }
        }

        return result;
    }

    private static boolean cycleDetection_DFS(int numCourses, List<List<Integer>> adjList) {
        int[] visitedCourses = new int[numCourses];
        int[] unidirectionalCourses = new int[numCourses]; //Courses found while traversing a direction
        for(int courseNum=0; courseNum < numCourses; courseNum++) {//Covers all disconnected components
            if(visitedCourses[courseNum] != 0) {//Visited
                continue;
            }

            visitedCourses[courseNum] = 1;
            unidirectionalCourses[courseNum] = 1;
            if(dfsCycle(courseNum, adjList, visitedCourses, unidirectionalCourses))
                return true;
        }

        return false;
    }

    private static boolean dfsCycle(int courseNum, List<List<Integer>> adjList, int[] visitedCourses, int[] unidirectionalCourses) {
        for(int neighbor : adjList.get(courseNum)){
            if (unidirectionalCourses[neighbor] == 1) {//Cycle detected ,same node found in same direction traversal
                return true;
            }
            if(visitedCourses[neighbor] == 0) {//Not visited
                visitedCourses[neighbor] = 1;
                unidirectionalCourses[neighbor] = 1;
                if(dfsCycle(neighbor, adjList, visitedCourses, unidirectionalCourses)) {
                    return true;
                }
            }
        }
        unidirectionalCourses[courseNum] = 0;

        return false;
    }

    private static List<List<Integer>> getAdjacentList(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return null;
        }
        List<List<Integer>> adjList = new ArrayList<>(numCourses);

        for(int count=0; count<numCourses; count++){
            adjList.add(count, new ArrayList<>());
        }

        for(int[] row : prerequisites) {//Each row has 2 elements [a, b] which is b->a
            adjList.get(row[1]).add(row[0]);
        }

        return adjList;
    }

    public static void main(String[] args) {
        System.out.println(canFinish_DFS(3, new int[][]{{1,0}, {2, 1}}));
    }
}

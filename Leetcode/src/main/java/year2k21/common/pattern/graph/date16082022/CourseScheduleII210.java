package year2k21.common.pattern.graph.date16082022;

import java.util.*;

//Topological Sorting using Kahn's BFS Algorithm
public class CourseScheduleII210 {

    //Intuition: Start with nodes with Zero-InDegree
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int[] nodeVsInDegreeCountMap = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] sortedResult = new int[numCourses];
        int sortedResultCount = 0;

        //Prepare InDegree Map & adjList
        for(int[] pair : prerequisites){
            ++nodeVsInDegreeCountMap[pair[0]];

            List<Integer> neighborList = adjList.getOrDefault(pair[1], new ArrayList<>());
            neighborList.add(pair[0]);
            adjList.put(pair[1], neighborList);
        }

        //Start with node w/ InDegree=0
        queue.addAll(findNodesWithZeroInDegree(nodeVsInDegreeCountMap));

        while (!queue.isEmpty()) {
            int current = queue.remove();
            nodeVsInDegreeCountMap[current] = Integer.MIN_VALUE;//Not to consider again
            sortedResult[sortedResultCount] = current;
            ++sortedResultCount;

            if(adjList.get(current) != null) {
                for (int neighbor : adjList.get(current)) {
                    --nodeVsInDegreeCountMap[neighbor];
                    if (nodeVsInDegreeCountMap[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return (sortedResultCount != numCourses) ?  new int[0] : sortedResult;
    }

    private static List<Integer> findNodesWithZeroInDegree(int[] nodeVsInDegreeMap) {
        List<Integer> nodesWithZeroInDegree = new ArrayList<>();

        for(int node = 0; node < nodeVsInDegreeMap.length; node++){
            if(nodeVsInDegreeMap[node] == 0){
                nodesWithZeroInDegree.add(node);
            }
        }

        return nodesWithZeroInDegree;
    }

    public static void main(String[] args) {
        //int[][] prerequisites = new int[][] {{1,0},{2,0},{3,1},{3,2}};
        int[][] prerequisites = new int[][]{{0,1},{1,0}};

        System.out.println(Arrays.toString(new CourseScheduleII210().findOrder(2, prerequisites)));
    }
}

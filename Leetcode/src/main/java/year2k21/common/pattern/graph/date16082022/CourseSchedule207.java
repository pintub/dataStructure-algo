package year2k21.common.pattern.graph.date16082022;

import java.util.*;

//Directed Graph Cycle Detection
public class CourseSchedule207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = getAdjacencyList(numCourses, prerequisites);
        Map<Integer, Boolean> nodeVsVisitedFlagMap = new HashMap<>();//Better to use ArrayMap
        Map<Integer, Boolean> nodeVsUnidirectionalVisitedFlagMap = new HashMap<>();//Better to use ArrayMap
        for(int course = 1; course <= numCourses; course++) {
            if(nodeVsVisitedFlagMap.get(course) != null && nodeVsVisitedFlagMap.get(course)) {
                continue;
            }

            if(dfsIsCycle(course, nodeVsVisitedFlagMap, nodeVsUnidirectionalVisitedFlagMap, adjList)){//If any cycle, course can not be completed
                return false;
            }
        }

        return true;
    }

    private boolean dfsIsCycle(int course, Map<Integer, Boolean> nodeVsVisitedFlagMap, Map<Integer, Boolean> nodeVsUnidirectionalVisitedFlagMap, Map<Integer, List<Integer>> adjList) {
        if(nodeVsUnidirectionalVisitedFlagMap.get(course) != null
            && nodeVsUnidirectionalVisitedFlagMap.get(course)) {//Cycle
            return true;
        }

        if(nodeVsVisitedFlagMap.get(course) != null && nodeVsVisitedFlagMap.get(course)) {//Already Visited
            return false;
        }

        nodeVsVisitedFlagMap.put(course, true);
        nodeVsUnidirectionalVisitedFlagMap.put(course, true);

        if(adjList.get(course) != null) {
            for (int neighborCourse : adjList.get(course)) {
                if (dfsIsCycle(neighborCourse, nodeVsVisitedFlagMap, nodeVsUnidirectionalVisitedFlagMap, adjList)) {
                    return true;
                }
            }
        }

        nodeVsUnidirectionalVisitedFlagMap.put(course, false);//Rollback
        return false;
    }

    //O(prerequisites.length)
    private Map<Integer, List<Integer>> getAdjacencyList(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] pair : prerequisites) {
            List<Integer> neighborList = adjList.getOrDefault(pair[0], new ArrayList<>());
            neighborList.add(pair[1]);
            adjList.put(pair[0], neighborList);
        }

        return adjList;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule207().canFinish(2, new int[][]{{1,0}, {0,1}}));
    }
}

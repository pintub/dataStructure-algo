package com.p2.feb2024;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSorting {

    public List<Integer> topSortByDfs(Map<Integer, List<Integer>> adjList) {
        Map<Integer, Boolean> dfsVisitedNodeMap = new HashMap<>();
        Stack<Integer> dfsExternalStack = new Stack<>();
        for (int node : adjList.keySet()) {
            if(dfsVisitedNodeMap.containsKey(node)) {
                continue;
            }

            dfsRecursion(node, dfsVisitedNodeMap, adjList, dfsExternalStack);
        }
        return reverseStack(dfsExternalStack);
    }

    private List<Integer> reverseStack(Stack<Integer> dfsExternalStack) {
        List<Integer> topoSotrtedList = new ArrayList<>();
        while (!dfsExternalStack.isEmpty()) {
            topoSotrtedList.add(dfsExternalStack.pop());
        };

        return topoSotrtedList;
    }

    private void dfsRecursion(int node, Map<Integer, Boolean> dfsVisitedNodeMap, Map<Integer, List<Integer>> adjList, Stack<Integer> dfsExternalStack) {
        if(dfsVisitedNodeMap.containsKey(node)) {
            return;
        }

        dfsVisitedNodeMap.put(node, true);
        for (int neighbor : adjList.get(node)) {
            dfsRecursion(neighbor, dfsVisitedNodeMap, adjList, dfsExternalStack);
        }

        dfsExternalStack.push(node);
    }

    public List<Integer> topSortByBfsKhans(Map<Integer, List<Integer>> adjList) {
        Map<Integer, Integer> nodeVsIndegreeeMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        findInDegreeOfAllNodes(nodeVsIndegreeeMap, adjList);
        findAndSetInDegreeOfZero(nodeVsIndegreeeMap, queue);

        while (!queue.isEmpty()) {
            int removedNode = queue.poll();
            result.add(removedNode);

            for(int neighbor : adjList.get(removedNode)) {
                int inDegreeNow = nodeVsIndegreeeMap.get(neighbor) - 1 ;
                if(inDegreeNow == 0) {
                    queue.add(neighbor);
                }
                nodeVsIndegreeeMap.put(neighbor, inDegreeNow);
            }

        }
        return result;
    }

    private void findAndSetInDegreeOfZero(Map<Integer, Integer> nodeVsIndegreeeMap, Queue<Integer> queue) {
        for(int node : nodeVsIndegreeeMap.keySet()) {
            if(nodeVsIndegreeeMap.get(node) == 0) {
                queue.add(node);
            }
        }
    }

    private void findInDegreeOfAllNodes(Map<Integer, Integer> nodeVsIndegreeeMap, Map<Integer, List<Integer>> adjList) {
        for(int node : adjList.keySet()) {
            nodeVsIndegreeeMap.putIfAbsent(node, 0);
            for(int neighbor : adjList.get(node)) {
                nodeVsIndegreeeMap.compute(neighbor, (key, oldValue) -> (oldValue == null) ? 1 : oldValue + 1);
            }
        }
    }

    private void findAndSetZeroInDegreeNodes(Map<Integer, List<Integer>> adjList, Queue<Integer> queue) {
        Set<Integer> allNodesWithIncomingDegree = adjList.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
        for(int node : adjList.keySet()) {
            if(!allNodesWithIncomingDegree.contains(node)) {
                queue.add(node);
            }
        }
    }


    public static void main(String args[]) {
        TopologicalSorting topologicalSorting = new TopologicalSorting();

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int nodeCount = 6;
        for (int i = 0; i < nodeCount; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            adjList.put(i, arr);
        }

        adjList.get(5).add(2);
        adjList.get(5).add(0);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);

        //List<Integer> result = topologicalSorting.topSortByDfs(adjList);
        List<Integer> result = topologicalSorting.topSortByBfsKhans(adjList);

        System.out.println("Topological Sort of the given graph is:" + result);
    }
}

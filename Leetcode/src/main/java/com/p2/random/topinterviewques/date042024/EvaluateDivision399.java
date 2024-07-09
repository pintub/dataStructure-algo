package com.p2.random.topinterviewques.date042024;

import java.util.*;
import java.util.stream.Collectors;

public class EvaluateDivision399 {

    public static void main(String[] args) {
        EvaluateDivision399 solution = new EvaluateDivision399();
        String[][] equations = {{"a","b"}};
        List<List<String>> equationList = Arrays.stream(equations).map(Arrays::asList).collect(Collectors.toList());
        String[][] queries = {{"a","b"},{"b","a"},{"a","c"},{"x","y"}};
        List<List<String>> queryList = Arrays.stream(queries).map(Arrays::asList).collect(Collectors.toList());

        System.out.println(Arrays.toString(solution.calcEquation(equationList, new double[]{0.5}, queryList)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adjList = buildGraph(equations, values);//TODO, Bidirectional

        double[] result = new double[queries.size()];

        Map<String, Map<String, Double>> srcVsDestinationValueMap = new HashMap<>();

        //Fetch src vs DestinationList
        for(int count = 0; count < queries.size(); count++) {
            List<String> query = queries.get(count);

            if(!adjList.containsKey(query.get(0)) || !adjList.containsKey(query.get(1))) {
                continue;
            }
            if(query.get(0).equals(query.get(1))) {
                continue;
            }

            Map<String, Double> tempMap = srcVsDestinationValueMap.getOrDefault(query.get(0), new HashMap<>());//TODO when map is read key might be missing
            tempMap.put(query.get(1), -1.0);
            srcVsDestinationValueMap.put(query.get(0), tempMap);
        }

        for(String src : srcVsDestinationValueMap.keySet()) {
            findShortestPathAndValue(src, srcVsDestinationValueMap.get(src).keySet(), adjList, srcVsDestinationValueMap);
        }

        for(int count = 0; count < queries.size(); count++) {
            List<String> query = queries.get(count);
            if(!adjList.containsKey(query.get(0)) || !adjList.containsKey(query.get(1))) {
                result[count] = -1;
            } else if(Objects.equals(query.get(0) , query.get(1))) {
                result[count] = 1;
            } else {
                result[count] = srcVsDestinationValueMap.get(query.get(0)).get(query.get(1));
            }
        }
        return result;
    }

    Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> adjList = new HashMap<>();

        for(int count = 0; count < equations.size(); count++){
            List<String> equation = equations.get(count);
            Map<String, Double> tempMap = adjList.getOrDefault(equation.get(0), new HashMap<>());
            tempMap.put(equation.get(1), values[count]);
            adjList.put(equation.get(0), tempMap);

            Map<String, Double> tempMap1 = adjList.getOrDefault(equation.get(1), new HashMap<>());
            tempMap1.put(equation.get(0), 1 / values[count]);
            adjList.put(equation.get(1), tempMap1);
        }

        return adjList;
    }

    void findShortestPathAndValue(String src, Set<String> destSet, Map<String, Map<String, Double>> adjList, Map<String, Map<String, Double>> srcVsDestinationValueMap) {
        Queue<String> q = new LinkedList<>();
        q.add(src);

        srcVsDestinationValueMap.get(src).put(src, 1.0);

        int destFoundCount = 0;
        while(!q.isEmpty() && destFoundCount != destSet.size()) {
            String currentNode = q.remove();
            for(String neighbor : adjList.get(currentNode).keySet()) {
                if(srcVsDestinationValueMap.get(src).get(neighbor) != null &&
                        srcVsDestinationValueMap.get(src).get(neighbor) != -1) {//Already visited & computed
                } else {
                    srcVsDestinationValueMap.get(src).put(neighbor,
                            srcVsDestinationValueMap.get(src).get(currentNode) * adjList.get(currentNode).get(neighbor));
                    q.add(neighbor);
                    ++destFoundCount;
                }
            }
        }
    }
}

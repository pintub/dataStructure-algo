package year2k21.common.pattern.graph.date11022023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Can be solved using Union-Find Also
 */
public class AccountsMerge721 {

    /**
     * Union Find by weight & Path Compression
     */
    //Using DFS/Recursion
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        //UnDirected Graph
        Map<String, Set<String>> graph = new HashMap<>();

        //EmailVsName Map
        Map<String, String> emailVsNameMap = new HashMap<>();

        Set<String> visitedNodes = new HashSet<>();

        //O(m*n)
        //Build Adj List
        for(List<String> account : accounts) {//MakeSet & populate emailVsNameMap
            List<String> emailList = account.subList(1, account.size());
            for(int count =1; count < account.size(); count ++) {
                String tempEmail = account.get(count);
                Set<String> emailSet = new HashSet<>(emailList);
                emailSet.remove(tempEmail);

                Set<String> existingSet = graph.getOrDefault(tempEmail, new HashSet<>());
                existingSet.addAll(emailSet);
                graph.put(tempEmail, existingSet);

                emailVsNameMap.put(account.get(count), account.get(0));
            }
        }

        //O(m*n) log(m*n)
        Map<String, Set<String>> oneEmailVsEmailGroup = new HashMap<>();
        for(String emailNode : graph.keySet()) {//So-Called outer loop
            if(visitedNodes.contains(emailNode)) {
                continue;
            }

            Set<String> groupSet = new TreeSet<>(); //Ordering
            dfs(emailNode, visitedNodes, graph, groupSet);

            oneEmailVsEmailGroup.put(emailNode, groupSet);
        }

        List<List<String>> result = new ArrayList<>();
        for(String email : oneEmailVsEmailGroup.keySet()) {
            List<String> tempList = new ArrayList<>();
            tempList.add(emailVsNameMap.get(email));
            tempList.addAll(oneEmailVsEmailGroup.get(email));

            result.add(tempList);
        }

        return result;
    }

    private void dfs(String emailNode, Set<String> visitedNodes, Map<String, Set<String>> graph, Set<String> groupSet) {
        if(visitedNodes.contains(emailNode)) {
            return;
        }

        visitedNodes.add(emailNode);
        groupSet.add(emailNode);

        for(String neighbor : graph.get(emailNode)) {
            dfs(neighbor, visitedNodes, graph, groupSet);
        }
    }

    public static void main(String[] args) {
        year2k21.common.pattern.unionfind.date15022023.AccountsMerge721 sol = new year2k21.common.pattern.unionfind.date15022023.AccountsMerge721();
        System.out.println(sol.accountsMerge(Arrays.asList(
                Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com")
        )));
    }

}

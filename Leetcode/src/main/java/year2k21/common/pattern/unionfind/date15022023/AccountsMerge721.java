package year2k21.common.pattern.unionfind.date15022023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Can be solved using Graph BF/DFS also
 */
public class AccountsMerge721 {

    /**
     * Union Find by weight & Path Compression
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        //EmailVsParentEmailMap
        Map<String, String> unionFindDS = new HashMap<>();

        //EmailVsName Map
        Map<String, String> emailVsNameMap = new HashMap<>();

        //O(m*n)
        for(List<String> account : accounts) {//MakeSet & populate emailVsNameMap
            for(int count =1; count < account.size(); count ++) {
                unionFindDS.put(account.get(count), "-1");
                emailVsNameMap.put(account.get(count), account.get(0));
            }
        }

        //O(m*n)
        for(List<String> account : accounts) {//Find & Union
            String firstMailInTheGroup = account.get(1);
            for(int count =2; count < account.size(); count ++) {
                String root1 =find(firstMailInTheGroup, unionFindDS);
                String root2 =find(account.get(count), unionFindDS);
                union(root1, root2, unionFindDS);
            }
        }

        //O(m*n) * log(m*n)
        Map<String, Set<String>> parentEmailVsGroupEmails = new HashMap<>();
        for(String email : unionFindDS.keySet()) {
            String root = find(email, unionFindDS);
            Set<String> groupSet = parentEmailVsGroupEmails.getOrDefault(root, new TreeSet<>()); //For Ordering
            groupSet.add(email);
            parentEmailVsGroupEmails.put(root, groupSet);
        }

        //O(m*n)
        List<List<String>> result = new ArrayList<>();
        for(String parentEmail : parentEmailVsGroupEmails.keySet()) {
            List<String> groupList = new ArrayList<>();
            groupList.add(emailVsNameMap.get(parentEmail));
            groupList.addAll(parentEmailVsGroupEmails.get(parentEmail));

            result.add(groupList);
        }

        return result;
    }

    private void union(String root1, String root2, Map<String, String> unionFindDS) {
        int root1Size = Integer.parseInt(unionFindDS.get(root1));
        int root2Size = Integer.parseInt(unionFindDS.get(root2));
        if(root1.equals(root2)) {// Same Size
            return;
        }

        if (root1Size > root2Size) {//Root2 is big
            unionFindDS.put(root1, root2);
            unionFindDS.put(root2, String.valueOf(root1Size + root2Size));
        } else {//Root1 is big
            unionFindDS.put(root2, root1);
            unionFindDS.put(root1, String.valueOf(root1Size + root2Size));
        }
    }

    private String find(String email, Map<String, String> unionFindDS) {
        if(!unionFindDS.get(email).contains("@")) { //Means Root reached & it's a -ve number
            return email;
        }

        String root = find(unionFindDS.get(email), unionFindDS);
        unionFindDS.put(email, root);

        return root;
    }

    public static void main(String[] args) {
        AccountsMerge721 sol = new AccountsMerge721();
        System.out.println(sol.accountsMerge(Arrays.asList(
                Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com")
        )));
    }
}

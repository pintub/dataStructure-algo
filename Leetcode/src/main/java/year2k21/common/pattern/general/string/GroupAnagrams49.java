package year2k21.common.pattern.general.string;

import java.util.*;

/**
 * Approach1 :
 *          Sorting of chars of String O(mlogm), m string length and use sorted char-string as map key
 *          Total : O(n* mlogm)
* Approach2:
*           Build a genius Key O(m), m string length and use this key as map key
*           "aacd" -> 2#0#1#1#0#0#0#0
 *          Total : O(n* m)
 *          genius solution concept referred from here : https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
 */
public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0){
            return result;
        }
        if(strs.length == 1){
            result.add(Collections.singletonList(strs[0]));
            return result;
        }

        Map<String, List<String>> specialKeyVsGroupedAnagrams = new HashMap<>();

        for (String str : strs) {
            int[] charVsCount = new int[26];
            for(int count = 0; count < str.length(); count++) {
                ++charVsCount[str.charAt(count) - 'a'];
            }

            StringBuilder specialStrKey = new StringBuilder();
            for(int count : charVsCount) {
                specialStrKey.append(count).append("#");
            }

            List<String> groupedAnagrams = specialKeyVsGroupedAnagrams.getOrDefault(specialStrKey.toString(), new ArrayList<>());
            groupedAnagrams.add(str);
            specialKeyVsGroupedAnagrams.put(specialStrKey.toString(), groupedAnagrams);
        }

        return new ArrayList<>(specialKeyVsGroupedAnagrams.values());
    }

    public List<List<String>> groupAnagrams_Copied(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams49().groupAnagrams_Copied(new String[]{"aa", "a"}));
    }
}

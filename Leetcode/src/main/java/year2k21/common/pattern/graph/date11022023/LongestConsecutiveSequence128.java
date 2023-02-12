package year2k21.common.pattern.graph.date11022023;

import java.util.HashMap;
import java.util.Map;

/**
 * Optimized solution w/o dfs
 * {{@link year2k21.common.pattern.graph.date16082022.LongestConsecutiveSequence128}}
 * Intuition behind opt solution :
 *  [100,4,200,1,3,2]
 *  Once LCS starting from 1 is computed, no need of computing 2's LCS. So actually no need of map
 */
public class LongestConsecutiveSequence128 {

    private int result = 0;

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> elemVsLCSFromThatElemMap = new HashMap();

        for(int num : nums) {//O(n)
            elemVsLCSFromThatElemMap.put(num, 0);
        }

        //iterate over nums
        for(int num : nums) {      //O(n)
            dfs(num, elemVsLCSFromThatElemMap);
        }

        return result;
    }

    int dfs(int elem, Map<Integer, Integer> elemVsLCSFromThatElemMap) {
        Integer value = elemVsLCSFromThatElemMap.get(elem);
        if(value == null) {//Element does nto exist
            return 0;
        }

        if(value > 0) {//Already visited
            return value;
        }

        int temp =  1 + dfs (elem + 1, elemVsLCSFromThatElemMap);

        elemVsLCSFromThatElemMap.put(elem, temp);

        this.result = Math.max(result , temp);

        return temp;
    }
}

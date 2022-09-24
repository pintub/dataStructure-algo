package com.p2.dp.aditya.mcm;

import java.util.HashMap;
import java.util.Map;

/**
 * Memo object can be Map<String, Boolean> = <str1#str2, T or F>
 * Also, note Map<str1#str2> = Map<str2#str1>
 *
 * DP Choice: (2 levels)
 *      1st level at partitioning(k=1 or 2 or 3...)
 *      2nd level at each partition(k=1),  "great" can be "g + reat" or "reat + g"
 *
 *                      isScr(great, etagr) //Only k=1 is depicted here
 *              k=1/                     \k=2    \k=3   \ k=4
 *               /                        \       \      \
 *         isScr(g,e)&&isScr(reat,tagr)
 *         ||
 *         isScr(g,r)&&isScr(reat,etag)//Considering Swapped case
 *
 * 2nd level Better Intuition:(for k=1 ie partition at 1st char)
 *              g   reat                            g   reat  //Swapping case
 *              |    |              or                \ /
 *              |    |                               / \
 *              e   tagr                          etag   r
 */
public class IsScrambledString  {

    boolean isScrambledString(String str1, String str2) {
        Map<String, Boolean> stringsVsIsScrambledMap = new HashMap<>();

        return isScrambledString(str1, str2, stringsVsIsScrambledMap);
    }

    private boolean isScrambledString(String str1, String str2, Map<String, Boolean> stringsVsIsScrambledMap) {
        int strLen = str1.length();//Both string of same length

        String cacheKey = str1 + "#" + str2;
        String cacheReverseKey = str2 + "#" + str1;

        if(stringsVsIsScrambledMap.get(cacheKey) != null) {
            return stringsVsIsScrambledMap.get(cacheKey);
        }
        if(stringsVsIsScrambledMap.get(cacheReverseKey) != null) {
            return stringsVsIsScrambledMap.get(cacheReverseKey);
        }
        if(strLen == 1) {
            stringsVsIsScrambledMap.put(cacheKey, str1.equals(str2));
            return str1.equals(str2);
        }

        for(int partition = 0; partition < strLen - 1; partition++){
            String str1Left = str1.substring(0, partition + 1);
            String str1Right = str1.substring(partition + 1);
            String str2Left = str2.substring(0, partition + 1);
            String str2Right = str2.substring(partition + 1);
            if(isScrambledString(str1Left, str2Left)
            && isScrambledString(str1Right, str2Right)) {
                stringsVsIsScrambledMap.put(cacheKey, true);
                return true;
            }
            str1Left = str1.substring(0, partition + 1);//Remains Same
            str1Right = str1.substring(partition + 1);//Remains Same
            str2Left = str2.substring(0, strLen - partition - 1);
            str2Right = str2.substring(strLen - partition - 1);
            if(isScrambledString(str1Left, str2Right)
                    && isScrambledString(str1Right, str2Left)) {
                stringsVsIsScrambledMap.put(cacheKey, true);
                return true;
            }
        }
        stringsVsIsScrambledMap.put(cacheKey, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsScrambledString().isScrambledString("great", "etagr"));
    }
}

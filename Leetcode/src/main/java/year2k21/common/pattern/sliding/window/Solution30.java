package year2k21.common.pattern.sliding.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 30. Substring with Concatenation of All Words
 * Almost there, but space complexity is huge
 */
public class Solution30 {
    public static List<Integer> findSubstring_LeetCode_Solution(String s, String[] words) {

        List<Integer> startIndexList = new ArrayList<>();

        if(words.length == 0 ) {
            return startIndexList;
        }

        int wordLen = words[0].length();
        int strLen = s.length();
        Map<String, Integer> wordVsCount = new HashMap<>();
        for (String word : words) {
            wordVsCount.put(word, wordVsCount.getOrDefault(word, 0) + 1);
        }

        for(int i=0; i < wordLen; i++){
            for(int left= i, right =0; right < strLen ; right+=3 ) {

            }
        }
        return null;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> startIndexList = new ArrayList<>();

        if(words.length == 0 ) {
            return startIndexList;
        }

        int wordLen = words[0].length();
        int strLen = s.length();

        Set<String> matchCandidates = new HashSet<>();
        Map<String, List<Integer>> wordVsLatestIndices = new HashMap<>();
        Map<String, Integer> wordVsCount = new HashMap<>();
        for (String word : words) {
            for(int index = 0; index < wordLen ; index++){
                matchCandidates.add(word.substring(0, index+1));
            }
            wordVsCount.put(word, wordVsCount.getOrDefault(word, 0) + 1);
        }

        for(int left = 0, checkPoint = 0, right = 1; right < strLen; right++) {
            if(right - checkPoint <= wordLen) {
                String substring = s.substring(checkPoint, right);
                if(matchCandidates.contains(substring)) {
                    if(right - checkPoint == wordLen ) {//a word found
                        List<Integer> latestIndices = wordVsLatestIndices.get(substring);
                        if(latestIndices == null){//word not found yet
                            latestIndices = new ArrayList<>();
                            latestIndices.add(checkPoint);
                            wordVsLatestIndices.put(substring, latestIndices);
                        } else if(countOfLatestIndicesMoreThanLeft(latestIndices, left)
                                == wordVsCount.get(substring)){//word earlier discovered and within window
                            left =
                                    latestIndices.get(latestIndices.size() - 1 - (wordVsCount.get(substring) - 1)) + wordLen;
                            latestIndices.add(checkPoint);
                            wordVsLatestIndices.put(substring, latestIndices);
                        } else {
                            latestIndices.add(checkPoint);
                            wordVsLatestIndices.put(substring, latestIndices);
                        }
                        checkPoint = checkPoint + wordLen;
                    } else {
                        continue;
                    }
                } else {
                    left = right;
                    checkPoint = right;
                    continue;
                }
            }

            if(right - left == words.length * wordLen){
                startIndexList.add(left);
                left = left + wordLen;
            }
        }

        return startIndexList;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

    static int countOfLatestIndicesMoreThanLeft(List<Integer> list, int left){
        int count = 0;
        for(int i: list){
            if(i >= left)
                count++;
        }
        return count;
    }

    /**
     * "wordgoodgoodgoodbestword"
     * ["word","good","best","good"]
     */
}

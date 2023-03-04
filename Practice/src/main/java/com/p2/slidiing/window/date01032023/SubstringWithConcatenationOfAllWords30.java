package com.p2.slidiing.window.date01032023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * It is similar to Count of Anagrams with wordVsCount Map instead of CharVsCount Map
 *
 * Another solution
 *  Use 2 for loop
 *  1st loop i=0; i < s.length-words.len * eachWordLen; i++
 *  2nd loop j=i, j<s.length-words.len; j+eachwordLen;
 *
 *
 *
 */
public class SubstringWithConcatenationOfAllWords30 {

    public List<Integer> findSubstring(String s, String[] words) {
         int left = 0, right = 0;
         int wordLen = words[0].length();

         if(s.length() < wordLen * words.length)
             return new ArrayList<>();

         //Memo
        Map<String, Integer> wordVsCountFinal = new HashMap<>();
        for(String word : words) {
            wordVsCountFinal.compute(word, (existingKey, existingValue) -> existingValue == null ? 1 : existingValue + 1);
        }
        Map<String, Integer> wordVsCount = new HashMap<>(wordVsCountFinal);
        int counter = wordVsCountFinal.size();

        //Result
        List<Integer> result = new ArrayList<>();

        while (right < s.length()) {
            if(right - left + 1 <= words.length * wordLen) {
                String rightPtrSubstring = s.substring(right, right + wordLen);
                Integer rightPtrSubStringCount = wordVsCount.get(rightPtrSubstring);
                if(rightPtrSubStringCount == null) {
                    right += wordLen;
                } else {
                    wordVsCount.put(rightPtrSubstring, rightPtrSubStringCount - 1);
                    if (rightPtrSubStringCount == 1)
                        --counter;
                    else if (rightPtrSubStringCount == 0)
                        ++counter;
                    right += wordLen;
                }
            } else {//Valid Window Size
                if(counter == 0) {
                    result.add(left);
                }

                String leftPtrSubstring = s.substring(left, left + wordLen);
                Integer leftPtrSubStringCount = wordVsCount.get(leftPtrSubstring);
                if (leftPtrSubStringCount == null) {
                    ++left;
                } else {
                    wordVsCount.put(leftPtrSubstring, leftPtrSubStringCount + 1);
                    if (leftPtrSubStringCount == -1)
                        --counter;
                    else if (leftPtrSubStringCount == 0)
                        ++counter;
                    ++left;
                }

                right = left;
                counter = wordVsCountFinal.size();
                wordVsCount = new HashMap<>(wordVsCountFinal);
            }
        }

        if(counter == 0)
            result.add(left);
        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords30 sol = new SubstringWithConcatenationOfAllWords30();
        System.out.println(sol.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}).equals(Arrays.asList(0, 9)));
        System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}).equals(new ArrayList<>()));
        System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}).equals(Arrays.asList(8)));
        System.out.println(sol.findSubstring("a", new String[]{"a"}).equals(Arrays.asList(0)));
    }
}

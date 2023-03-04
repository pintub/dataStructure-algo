package com.p2.slidiing.window.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Memo DS: charVsFreqMap + Counter variable
 *
 * Counter not affected when count goes -ve. This is different than Count Anagrams
 */
public class MinimumWindowSubstring76 {

    public String minWindow(String src, String target) {
        int left = 0, right = 0;

        Map<Character, Integer> charVsFreqMap = new HashMap<>();
        for(int count= 0; count < target.length(); count++){
            int freq = charVsFreqMap.getOrDefault(target.charAt(count), 0);
            charVsFreqMap.put(target.charAt(count), ++freq);
        }

        int counter = charVsFreqMap.size();

        String result = "";

        while (right < src.length()){
            char rightPtrChar = src.charAt(right);
            if(charVsFreqMap.get(rightPtrChar) == null) {
                right++;
                continue;
            }

            if(counter > 0) {//chars yet to be consumed expected number times, move right pointer only
                int rightPtrCharFreq = charVsFreqMap.get(rightPtrChar);
                if (rightPtrCharFreq == 1) {//Going 1 to 0, decrease counter
                    --counter;
                }
                charVsFreqMap.put(rightPtrChar, --rightPtrCharFreq);
                if (counter != 0) {
                    ++right;
                    continue;
                }
            }

            while (counter == 0) {//Move Left pointer to make window invalid . When left is positioned properly, move Right
                char leftPtrChar = src.charAt(left);
                result = "".equals(result) ? src.substring(left, right + 1) : (result.length() < right - left + 1 ? result : src.substring(left, right + 1));

                if(charVsFreqMap.get(leftPtrChar) == null) {
                    ++left;
                    continue;
                }

                int leftPtrCharFreq = charVsFreqMap.get(leftPtrChar);
                if(leftPtrCharFreq == 0) {//Going 0 to 1, increase counter
                    ++counter;
                }
                charVsFreqMap.put(leftPtrChar, ++leftPtrCharFreq);
                ++left;
            }
            ++right;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring76().minWindow("ADOBECODEBANC", "ABC"));//BANC
    }
}

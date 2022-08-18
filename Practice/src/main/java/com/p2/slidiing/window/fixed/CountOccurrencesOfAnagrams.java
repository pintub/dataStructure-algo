package com.p2.slidiing.window.fixed;

//Count Occurrences of Anagrams
//Anagram of a String for : for, orf and ofr (By juggling characters)

//Fixed window, window size =searchWord.len

import java.util.*;

/**
 * Simple solution : Use a map of charVsCount and see if all values = respective expected Count.
 * Example If searchWord (aaba), then anagram found if a=3,b=1 map state has reached. This check is costly
 *
 * Instead, Counter variable used along w/ map. Also decrement instead of incrementing count
 * Initialize map to a=3,b=1 & counter var to 2
 * For each occurrence of char, decrease count
 * If window has abba, Map will be a=1,b= -1 and counter will be =2 (Note this)
 * If window has aaca, Map will be a=0,b=1 and counter will be =1 (as "a" is consumed expected times)
 * If window has aaba, Map will be a=0,b=0 and counter will be =1 (as "a","b" both is consumed expected times)
 *
 * So, if all chars are consumed expected times, counter=0
 * counter=0 vs checkAllValuesInMapIsZero() problem solved
 */
public class CountOccurrencesOfAnagrams {

    int search(String searchWord, String text) {
        Map<Character, Integer> charVsCountMap = new HashMap<>();
        int searchWordLen = searchWord.length();

        for(int count = 0; count < searchWordLen; count++){
            char character = searchWord.charAt(count);
            int charCount = charVsCountMap.getOrDefault(character, 0);
            charVsCountMap.put(character, ++charCount);
        }

        int counter = charVsCountMap.size();//Counter variable

        int resultCount = 0;

        int left = 0;
        int right = 0;

        while (right < text.length()){
            char rightPointerChar = text.charAt(right);
            if(charVsCountMap.get(rightPointerChar) != null) {
                int rightPointerCharCount = charVsCountMap.get(rightPointerChar);
                charVsCountMap.put(rightPointerChar, --rightPointerCharCount);
                if (rightPointerCharCount == 0) {//previously it was 1, now 0, So decrease counter
                    --counter;
                } else if (rightPointerCharCount == -1) {//previously it was 0, now -1, So increase counter
                    ++counter;
                }
            }

            if(right - left + 1 < searchWordLen) {
                ++right;
            } else if (right - left + 1 == searchWordLen) {
                if(counter == 0) {
                    ++resultCount;
                }

                //Just consider outgoing left pointer here, right pointer gets updated in outer while loop
                char leftPointerChar = text.charAt(left);
                if(charVsCountMap.get(leftPointerChar) != null) {
                    int leftPointerCharCount = charVsCountMap.get(leftPointerChar);
                    charVsCountMap.put(leftPointerChar, ++leftPointerCharCount);
                    if (leftPointerCharCount == 0) {//previously it was -1, now 0, So increase counter
                        --counter;
                    } else if (leftPointerCharCount == 1) {//previously it was 0, now 1, So decrease counter
                        ++counter;
                    }
                }

                ++right;
                ++left;
            }

        }
        return resultCount;
    }

    public static void main(String[] args) {
        System.out.println(new CountOccurrencesOfAnagrams().search("for", "forxxorfxdofr"));
    }
}

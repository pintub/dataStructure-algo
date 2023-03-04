package com.p2.slidiing.window.fixed;

import java.util.HashMap;
import java.util.Map;

//Count Occurrences of Anagrams
//Anagram of a String for : for, orf and ofr (By juggling characters)

//Fixed window, window size =searchWord.len
/**
 * Simple solution : Use a map of charVsCount and see if all values = respective expected Count.
 * Example If searchWord (aaba), then anagram found if a=3,b=1 map state has reached. This check is costly
 *
 * Instead, Counter variable used along w/ Map. Also decrement instead of incrementing count
 * Initialize Map to a=3,b=1 & counter var to 2 (which is no. of characters)
 * For all occurrence of char, decrease count from Map. But for counter if all chars are consumed expected times, counter=0
 * counter var will never be (-)ve
 *
 * If window has abba, Map will be a=1,b=-1 and counter will be =2 (When individual count is -ve, count rather increased)
 * If window has aaca, Map will be a=0,b=1 and counter will be =1 (as only "a" is consumed expected times)
 * If window has aaba, Map will be a=0,b=0 and counter will be =0 (as "a","b" both is consumed expected times)
 *
 * So, if all chars are consumed expected times, counter=0 and counter var will never be (-)ve
 * counter=0 vs checkAllValuesInMapIsZero() problem solved
 */
public class CountOccurrencesOfAnagrams {

    public int search(String searchWord, String text) {

        int searchWordLen = searchWord.length();

        //Memorization Map and counter var
        Map<Character, Integer> charVsCountMap = new HashMap<>();
        for(int count = 0; count < searchWordLen; count++){
            char character = searchWord.charAt(count);
            int charCount = charVsCountMap.getOrDefault(character, 0);
            charVsCountMap.put(character, ++charCount);
        }

        int counter = charVsCountMap.size();//Counter variable

        //Result
        int resultCount = 0;

        int left = 0;
        int right = 0;

        while (right < text.length()){
            char rightPointerChar = text.charAt(right);

            //Update Memorization DS , Here Map and counter
            if(charVsCountMap.get(rightPointerChar) != null) { //Common code is moved out of if-else clause
                int rightPointerCharCount = charVsCountMap.get(rightPointerChar);
                charVsCountMap.put(rightPointerChar, --rightPointerCharCount);
                if (rightPointerCharCount == 0) {//previously it was 1, now 0, So decrease counter
                    --counter;
                } else if (rightPointerCharCount == -1) {//previously it was 0, now -1, So increase counter
                    ++counter;
                }
            }

            if(right - left + 1 < searchWordLen) {//If Window size not yet attained
                ++right;
            } else if (right - left + 1 == searchWordLen) {
                ++right;

                if(counter == 0) { //Updated Result
                    ++resultCount;
                }

                //Update Memorization DS
                char leftPointerChar = text.charAt(left);
                if(charVsCountMap.get(leftPointerChar) != null) {//Once window size achieved
                    int leftPointerCharCount = charVsCountMap.get(leftPointerChar);
                    charVsCountMap.put(leftPointerChar, ++leftPointerCharCount);
                    if (leftPointerCharCount == 0) {//previously it was -1, now 0, So decrease counter
                        --counter;
                    } else if (leftPointerCharCount == 1) {//previously it was 0, now 1, So increase counter
                        ++counter;
                    }
                }

                ++left;
            }

        }
        return resultCount;
    }

    public static void main(String[] args) {
        System.out.println(new CountOccurrencesOfAnagrams().search("for", "forxxorfxdofro") == 4);
    }
}

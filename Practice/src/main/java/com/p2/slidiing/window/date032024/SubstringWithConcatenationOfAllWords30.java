package com.p2.slidiing.window.date032024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Multiple iterations sliding window
 *
 * Time Complexity:
 *      Iterations => wordLen, i.e. words[0].length()
 *      Each iteration sliding = n / wordLen [Jumping both pointers +wordLen]
 *
 *  o( wordLen * n / wordLen ) = o(n)
 */
public class SubstringWithConcatenationOfAllWords30 {
    public List<Integer> findSubstring(String s, String[] words) {
        //Memo
        Map<String, Integer> wordVsExpectedCount = new HashMap<>();

        for(String word : words) {
            wordVsExpectedCount.compute(word, (key, value) -> value == null ? 1 : value + 1);
        }

        //Result
        List<Integer> result = new ArrayList<>();

        int windowSize = words[0].length();

        /**
         * windowSize = 3
         * 0, 0 + 3, 0 + 3 + 3 ... each pointer jumps windowSize = 3
         * 1, 1 + 3, 1 + 3 + 3 ...
         * 2, 2 + 3, 2 + 3 + 3 ...
         */
        for(int count = 0; count < windowSize; count++) {
            Map<String, Integer> tempMap = new HashMap<>(wordVsExpectedCount);//NOTE New Memo for each iteration
            int counter = wordVsExpectedCount.size();
            int leftPointer = count;
            int rightPointer = count + windowSize - 1;

            while(rightPointer < s.length()) {
                if(rightPointer - leftPointer + 1 < windowSize * words.length) {//Not Reached
                    String incomingWindow = s.substring(rightPointer - windowSize + 1, rightPointer + 1);
                    if(tempMap.containsKey(incomingWindow)) {
                        int newCount = tempMap.get(incomingWindow) - 1;
                        tempMap.put(incomingWindow, newCount);
                        if(newCount == 0) {
                            --counter;
                        } else if(newCount == -1) {
                            ++counter;
                        }
                    }
                    rightPointer += windowSize;
                } else {
                    String incomingWindow = s.substring(rightPointer - windowSize + 1, rightPointer + 1);
                    if(tempMap.containsKey(incomingWindow)) {
                        int newCount = tempMap.get(incomingWindow) - 1;
                        tempMap.put(incomingWindow, newCount);
                        if(newCount == 0) {
                            --counter;
                        } else if(newCount == -1) {
                            ++counter;
                        }
                    }
                    rightPointer += windowSize;

                    if(counter == 0) {
                        result.add(leftPointer);
                    }

                    //Update Memo with outgoing word
                    String outgoingWindow = s.substring(leftPointer, leftPointer + windowSize);
                    if(tempMap.containsKey(outgoingWindow)) {
                        int newCount = tempMap.get(outgoingWindow) + 1;
                        tempMap.put(outgoingWindow, newCount);
                        if(newCount == 0) {
                            --counter;
                        } else if(newCount == 1) {
                            ++counter;
                        }
                    }
                    leftPointer += windowSize;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords30 solution = new SubstringWithConcatenationOfAllWords30();
        System.out.println(solution.findSubstring("ababaab", new String[]{"ab","ba","ba"}));
    }
}

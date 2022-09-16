package year2k21.common.pattern.general.string;

import java.util.*;

public class MinimumWindowSubstring76 {

    public String minWindow(String src, String target) {
        int left = 0, right = 0;

        Map<Character, Integer> charVsToBeConsumedCount = new HashMap<>();
        for(int count = 0; count < target.length(); count++){
            char c = target.charAt(count);
            int charCount = charVsToBeConsumedCount.getOrDefault(c, 0);
            charVsToBeConsumedCount.put(c, charCount + 1);
        }

        int counter = target.length();
        String minWindow = "";

        while (right < src.length()) {
            char rightIdxChar = src.charAt(right);
            if(counter != 0) {//If invalid window, Update memo & increment right pointer
                if(!charVsToBeConsumedCount.containsKey(rightIdxChar)) {//A different char
                    right++;
                } else {
                    int charCount = charVsToBeConsumedCount.getOrDefault(rightIdxChar, 0);
                    charVsToBeConsumedCount.put(rightIdxChar, --charCount);
                    if(charCount >= 0) {
                        --counter;
                    }
                    if(counter != 0) {//Keeping window valid only
                        right++;
                    }
                }
            } else {//valid window, Increment left pointer till it becomes just invalid, then increment Right pointer
                while (counter == 0) {
                    int currentWindowSize = right - left + 1;
                    minWindow = "".equals(minWindow) ? src.substring(left, right + 1) : (currentWindowSize < minWindow.length()) ? src.substring(left, right + 1): minWindow;
                    char leftIdxChar = src.charAt(left);
                    if(!charVsToBeConsumedCount.containsKey(leftIdxChar)) {//A different char
                        left++;
                    } else {
                        int charCount = charVsToBeConsumedCount.getOrDefault(leftIdxChar, 0);
                        charVsToBeConsumedCount.put(leftIdxChar, ++charCount);
                        if(charCount > 0) {
                            ++counter;
                        }
                        left++;
                    }
                }
                right++;
            }
        }

        return minWindow;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring76().minWindow("ADOBECODEBANC", "ABC"));
    }
}

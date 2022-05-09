package year2k21.common.pattern.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    private static int getLenLongestSUbStrWithoutRep(String str) {
        HashMap<Character, Integer> charVsLatestIndex = new HashMap<>();
        int length = str.length();

        int max = 0;
        int left , right;
        for(left =0, right = 0; right <= length -1 ; right++){
            char rightPointerChar = str.charAt(right);
            Integer latestIndex = charVsLatestIndex.get(rightPointerChar);
            if(latestIndex == null) {//Char Not found yet
                charVsLatestIndex.put(rightPointerChar, right);
            } else {//Char encountered earlier
                if(latestIndex >= left) {//Char is present in current window, so shift left pointer to shift window
                    max = Math.max(max, right - left);
                    left = latestIndex + 1;
                    charVsLatestIndex.put(rightPointerChar, right);
                } else {
                    charVsLatestIndex.put(rightPointerChar, right);
                }
            }

        }

        return Math.max(max, right -left);//Consider last window
    }

    private static int getLenLongestSUbStrWithoutRep_UsingQueue(String str) {
        Queue<Character> characterQueue = new LinkedList<>();
        int max = 0;
        for(int i=0; i<str.length(); i++){

            char currentChar = str.charAt(i);
            if(characterQueue.contains(currentChar)) {
                while (!characterQueue.isEmpty() && characterQueue.peek() != currentChar) {
                    characterQueue.remove();
                }
                characterQueue.remove();
            }
            characterQueue.add(currentChar);
            max = Math.max(max, characterQueue.size());
        }

        return max;
    }


    /**
     * Build Map or map array
     * 1. Use two pointers: start and end to represent a window.
     * 2. Move end to find a valid window.
     * 3. When a valid window is found, move start to find a smaller window.
     */
    private static int getLenLongestSUbStrWithoutRep_UsingTemplate(String str) {
        int strLen = str.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        for(; right < strLen; right++){
            boolean validWindow = true;
            String window = str.substring(left, right + 1);
            char currentChar = str.charAt(right);
            int charFreq = map.getOrDefault(currentChar, 0);
            map.put(currentChar, charFreq + 1);
            if(charFreq == 1) {//Already one exists, time to shift left window
                validWindow = false;
            } else {
                max = Math.max(max, window.length());
                continue;
            }

            while (!validWindow) {//Attempt to make window valid again by shifting left window
                char leftChar = str.charAt(left);
                ++left;
                if(currentChar == leftChar){
                    validWindow = true;
                    window = str.substring(left, right + 1);
                    max = Math.max(max, window.length());
                }
                map.put(leftChar, map.get(leftChar) - 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Solution3.getLenLongestSUbStrWithoutRep_UsingTemplate("pwwkew"));
    }
}

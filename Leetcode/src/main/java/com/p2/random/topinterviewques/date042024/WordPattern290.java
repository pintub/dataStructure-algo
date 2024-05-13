package com.p2.random.topinterviewques.date042024;

public class WordPattern290 {

    public boolean wordPattern(String pattern, String s) {
        String[] letterVsWordMap = new String[26];

        int patternPointer = 0;
        int sPointer = 0;
        StringBuilder tempWord = new StringBuilder();
        for(; patternPointer < pattern.length() && sPointer < s.length(); patternPointer++) {
            while(sPointer < s.length() && s.charAt(sPointer) != ' ') {
                tempWord.append(s.charAt(sPointer));
                ++sPointer;
            }

            int letterVsWordMapIdx = pattern.charAt(patternPointer) - (int)'a';
            if(letterVsWordMap[letterVsWordMapIdx] != null) {
                if(!letterVsWordMap[letterVsWordMapIdx].equals(tempWord.toString())) {
                    return false;
                }
            } else {
                letterVsWordMap[letterVsWordMapIdx] = tempWord.toString();
            }

            tempWord = new StringBuilder();

            ++sPointer;
        }

        if(patternPointer < pattern.length() || sPointer < s.length()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern290 sol = new WordPattern290();
        System.out.println(sol.wordPattern("abba", "dog dog dog dog"));
    }
}

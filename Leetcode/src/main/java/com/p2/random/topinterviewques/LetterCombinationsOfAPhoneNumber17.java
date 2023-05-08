package com.p2.random.topinterviewques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber17 {

    private static final Map<Integer, List<Character>> TELEPHONE_MAP = new HashMap<>();
    static {
        TELEPHONE_MAP.put(2, Arrays.asList('a', 'b', 'c'));
        TELEPHONE_MAP.put(3, Arrays.asList('d', 'e', 'f'));
        TELEPHONE_MAP.put(4, Arrays.asList('g', 'h', 'i'));
        TELEPHONE_MAP.put(5, Arrays.asList('j', 'k', 'l'));
        TELEPHONE_MAP.put(6, Arrays.asList('m', 'n', 'o'));
        TELEPHONE_MAP.put(7, Arrays.asList('p', 'q','r', 's'));
        TELEPHONE_MAP.put(8, Arrays.asList('t', 'u', 'v'));
        TELEPHONE_MAP.put(9, Arrays.asList('w','x', 'y', 'z'));
    }

    public List<String> letterCombinations_iterative(String digits) {
        List<String> result  = new LinkedList<>();
        if("".equals(digits))
            return result;

        result.add("");
        for(char digit : digits.toCharArray()) {
            List<Character> characters = TELEPHONE_MAP.get(Integer.parseInt(digit + ""));
            ListIterator<String> iterator = result.listIterator();
            int size = result.size();
            int count = 0;
            while (iterator.hasNext() && count <= size) {
                String temp = iterator.next();
                iterator.remove();
                for(char c : characters) {
                    iterator.add(temp + c);
                }
                ++count;
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        List<String> result  = new ArrayList<>();
        if("".equals(digits))
            return result;
        letterCombinations(0, "", result, digits);

        return result;
    }

    private void letterCombinations(int strIndex, String prefixAnswer, List<String> result, final String digits) {
        if(strIndex == digits.length()) {
            result.add(prefixAnswer);
            return;
        }

        List<Character> characters = TELEPHONE_MAP.get(Integer.parseInt(digits.charAt(strIndex) + ""));
        for(char c : characters) {
            letterCombinations(strIndex + 1, prefixAnswer + c, result, digits);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber17 sol = new LetterCombinationsOfAPhoneNumber17();
        System.out.println(sol.letterCombinations_iterative("23"));
    }
}

package com.p2.random.topinterviewques.date042024;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder127 {

    public static void main(String[] args) {
        WordLadder127 sol = new WordLadder127();
        String[] strings = {"a","b","c"};
        System.out.println(sol.ladderLength("a", "c", Arrays.stream(strings).collect(Collectors.toList())));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Map<String, Integer> wordVsDistanceFromBeginWord = new HashMap<>();
        for(String word : wordList) {
            wordVsDistanceFromBeginWord.put(word, Integer.MAX_VALUE);
        }

        while(!q.isEmpty()) {
            String currWord = q.remove();
            for(char c = 'a'; c <= 'z'; c++ ) {
                for(int idx = 0; idx < currWord.length(); idx++) {
                    String tempWord = ((idx > 0) ? currWord.substring(0, idx) : "") + c + ((idx < currWord.length() - 1) ? currWord.substring(idx + 1) : "");

                    if(wordVsDistanceFromBeginWord.containsKey(tempWord) && wordVsDistanceFromBeginWord.get(currWord) + 1 < wordVsDistanceFromBeginWord.get(tempWord)) {
                        if(tempWord.equals(endWord)) {
                            return wordVsDistanceFromBeginWord.get(currWord) + 2;
                        }
                        wordVsDistanceFromBeginWord.put(tempWord, wordVsDistanceFromBeginWord.get(currWord) + 1);
                        q.add(tempWord);
                    }
                }
            }
        }

        return 0;
    }

    private int count;
    public int ladderLengthDfs(String beginWord, String endWord, List<String> wordList) {
        count = Integer.MAX_VALUE;

        Set<String> seen = new HashSet<>();
        seen.add(beginWord);

        recursion(beginWord, endWord, new HashSet<>(wordList), seen, 0);

        return count == Integer.MAX_VALUE ? 0 : count;
    }

    private void recursion(String beginWord , final String endWord , Set<String> wordList , Set<String> seen, int prefixCount) {
        if(beginWord.equals(endWord)) {
            count = Math.min(count, prefixCount + 1);
            return;
        }

        if(wordList.isEmpty()) {
            return;
        }

        for(String word : wordList) {
            if(seen.contains(word) || !oneCharDiff(beginWord, word)) {
                continue;
            }
            Set<String> temp = new HashSet<>(wordList);
            temp.remove(word);
            seen.add(word);
            recursion(word, endWord, temp, seen, prefixCount + 1);
            seen.remove(word);
            //temp.add(word);
        }
    }

    private boolean oneCharDiff(String word1 , String word2) {
        int diff = 0;
        for(int idx = 0; idx < word1.length(); idx++) {
            if(word1.charAt(idx) != word2.charAt(idx)) {
                ++diff;
            }

            if(diff > 1) {
                return false;
            }
        }

        return diff == 1;
    }


}

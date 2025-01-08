package com.p2.random.topinterviewques.date042024;

import java.util.*;

public class WordLadderII126 {

    public static void main(String[] args) {
        WordLadderII126 wordLadderII126 = new WordLadderII126();
        System.out.println(wordLadderII126.findLadders("red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee") ));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //Shortest path from one source to one destination
        Map<String, List<List<String>>> wordVsPathsFromSource = new HashMap<>();

        for(String word : wordList) {
            wordVsPathsFromSource.put(word, null);
        }

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        List<List<String>> paths = new ArrayList<>();
        paths.add(path);
        wordVsPathsFromSource.put(beginWord, paths);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()) {
            String currWord = q.remove();
            for(int index = 0; index < currWord.length(); index++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    if(currWord.charAt(index) == c) {
                        continue;
                    }
                    String potentialNeighborWord = (currWord.length() == 1) ? c + "" :
                            (index == 0) ? c + currWord.substring(1) :
                                    (index == currWord.length() - 1) ? currWord.substring(0, currWord.length() - 1) + c :
                                            currWord.substring(0, index) + c + currWord.substring(index + 1);
                    if(wordVsPathsFromSource.containsKey(potentialNeighborWord) && !beginWord.equals(potentialNeighborWord)) {
                        if(wordVsPathsFromSource.get(potentialNeighborWord) == null ||
                                wordVsPathsFromSource.get(potentialNeighborWord).isEmpty() ||
                                wordVsPathsFromSource.get(currWord).get(0).size() + 1 < wordVsPathsFromSource.get(potentialNeighborWord).get(0).size()) {
                            q.add(potentialNeighborWord);

                            List<List<String>> currWordFromSourcePaths = wordVsPathsFromSource.get(currWord);
                            List<List<String>> newPaths = new ArrayList<>();
                            for(List<String> currWordFromSourcePath : currWordFromSourcePaths) {
                                List<String> tempNewPath =new ArrayList<>(currWordFromSourcePath);
                                tempNewPath.add(potentialNeighborWord);
                                newPaths.add(tempNewPath);
                            }
                            wordVsPathsFromSource.put(potentialNeighborWord, newPaths);
                        } else if(wordVsPathsFromSource.get(currWord).get(0).size() + 1 == wordVsPathsFromSource.get(potentialNeighborWord).get(0).size()) {
                            //q.add(potentialNeighborWord);

                            List<List<String>> existingPaths = wordVsPathsFromSource.get(potentialNeighborWord);
                            List<List<String>> currWordFromSourcePaths = wordVsPathsFromSource.get(currWord);
                            for(List<String> currWordFromSourcePath : currWordFromSourcePaths) {
                                List<String> tempNewPath =new ArrayList<>(currWordFromSourcePath);
                                tempNewPath.add(potentialNeighborWord);
                                existingPaths.add(tempNewPath);
                            }
                        }
                    }
                }
            }
        }
        return wordVsPathsFromSource.get(endWord) == null ? new ArrayList<>() : wordVsPathsFromSource.get(endWord);
    }
}

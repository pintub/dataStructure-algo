package year2k21.common.pattern.graph.date16082022;

import java.util.*;

/**
 * Premium Question : https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html
 * Build Graph & Topological sorting. Consider invalid ordering of words which are due to cycles
 *
 * Just coded Build Graph part here
 */
public class AlienDictionary269Premium {

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = buildGraph(words);
        System.out.println("DAG:" + adjList);

        return "";
    }

    //Build DAG
    //Just compare the 2 words
    private Map<Character, List<Character>> buildGraph(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        for(int count = 1; count < words.length; count++) {
            String previousWord = words[count - 1];
            String currentWord = words[count];
            int charLengthToCompare = Math.min(previousWord.length(), currentWord.length());

            for(int charPosition = 0; charPosition < charLengthToCompare; charPosition++){//Compare chars in both words, i.e. left to right
                boolean isSamePrefix = charPosition == 0 ?
                        true :
                        previousWord.substring(0, charPosition).equals(currentWord.substring(0, charPosition));

                if(!isSamePrefix){
                    break;
                }

                char previousWordChar = previousWord.charAt(charPosition);
                char currentWordChar = currentWord.charAt(charPosition);

                if(isSamePrefix && previousWordChar != currentWordChar) {
                    List<Character> neighbors = adjList.getOrDefault(previousWordChar, new ArrayList<>());
                    neighbors.add(currentWordChar);
                    adjList.put(previousWordChar, neighbors);
                }
            }
        }

        return adjList;
    }

    public static void main(String[] args) {
        System.out.println(new AlienDictionary269Premium().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }

}

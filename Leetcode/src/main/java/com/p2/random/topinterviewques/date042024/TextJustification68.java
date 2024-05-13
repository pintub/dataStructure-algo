package com.p2.random.topinterviewques.date042024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int startIndex = 0, endIndex = 0;
        int localSum = words[0].length();
        for(int idx = 1; idx < words.length; idx++) {
            if(localSum + 1 + words[idx].length() <= maxWidth) {
                localSum += 1 + words[idx].length();
                endIndex = idx;
            } else {
                result.add(formPreviousLine(startIndex, endIndex, localSum, maxWidth, words));
                startIndex = idx;
                endIndex = idx;
                localSum = words[idx].length();
            }
        }
        //TODO last line handling
        result.add(formlastLine(startIndex, endIndex, localSum, maxWidth, words));//TODO last line handling
        return result;
    }

    String formPreviousLine(int startIndex, int endIndex, int localSum, int maxWidth, String[] words) {
        if(startIndex == endIndex) {//If one word in the line
            char[] gap = new char[maxWidth - localSum];
            Arrays.fill(gap, ' ');
            return words[startIndex] + new String(gap);
        }

        int remainingGap = maxWidth - localSum;
        int inBetweenSpaces = endIndex - startIndex;
        int remainingGapDivision = remainingGap / inBetweenSpaces;//Each gap gets these many spaces
        int remainingGapPerc = remainingGap % inBetweenSpaces;//Each 1st these gets a space
        StringBuilder sb = new StringBuilder();
        for(int i = startIndex; i <= endIndex - 1; i++) {
            char[] gap = (remainingGapPerc > 0) ? new char[1 + remainingGapDivision + 1] : new char[1 + remainingGapDivision];
            --remainingGapPerc;
            Arrays.fill(gap, ' ');
            sb.append(words[i]).append(new String(gap));
        }

        return sb.append(words[endIndex]).toString();
    }

    String formlastLine(int startIndex, int endIndex, int localSum, int maxWidth, String[] words) {
        int remainingGap = maxWidth - localSum;
        char[] gap = new char[remainingGap];
        StringBuilder sb = new StringBuilder();
        Arrays.fill(gap, ' ');
        for(int i = startIndex; i <= endIndex - 1; i++) {
            sb.append(words[i]).append(" ");
        }

        return sb.append(words[endIndex]).append(gap).toString();
    }

    public static void main(String[] args) {
        TextJustification68 sol = new TextJustification68();
        sol.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
    }
}

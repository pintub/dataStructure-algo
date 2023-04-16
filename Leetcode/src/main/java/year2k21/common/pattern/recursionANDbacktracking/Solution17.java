package year2k21.common.pattern.recursionANDbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Cartesian product of 2 char[] at a time, then cart product of result with another char[]. so on
 */
public class Solution17 {

    private static final String[][] NUMBER_VS_STRING_ARRAY_MAP = new String[][]{
            {"#", "#", "#"},
            {"#", "#", "#"},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }

        List<String> output = new ArrayList<>();
        for(int count = 0; count<digits.length(); count++){
            output = combination(output, NUMBER_VS_STRING_ARRAY_MAP[Integer.parseInt(digits.substring(count, count+1))]);
        }

        return output;
    }

    public List<String> letterCombinations_Recursion(String digits) {
        List<String> output = new ArrayList<>();

        if(digits.length() == 0){
            return output;
        }

        recursion("", 0, digits, output);

        return output;
    }

    private void recursion(String prefix, int digitNum, String digits, List<String> output) {
        if(digitNum > digits.length() - 1) {
            output.add(prefix);//At child node
            return;
        }

        String num = digits.substring(digitNum, digitNum+1);
        int numInt = Integer.parseInt(num);
        String[] array = NUMBER_VS_STRING_ARRAY_MAP[numInt];
        for(String str : array) {
            recursion(prefix + str, digitNum + 1, digits, output);
        }
    }

    private List<String> combination(List<String> output, String[] arr2) {
        if(output.size() == 0) {
            return Arrays.asList(arr2);
        }

        List<String> result = new ArrayList<>();
        for(String s1 : output) {
            for(String s2 : arr2) {
                result.add(s1 + s2);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution17 solution = new Solution17();
        System.out.println(solution.letterCombinations_Recursion("2344").equals(solution.letterCombinations("2344")));
    }
}

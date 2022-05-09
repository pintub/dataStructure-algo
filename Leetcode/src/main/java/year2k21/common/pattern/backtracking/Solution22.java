package year2k21.common.pattern.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        if(n == 0) {
            return output;
        }

        recursion("(", 1, 0, output, n);

        return output;
    }

    private void recursion(String prefix, int leftBracketCount, int rightBracketCount, List<String> output, int n) {
        if(rightBracketCount == n) {
            output.add(prefix);
            return;
        }

        if(leftBracketCount == rightBracketCount) { //For sure ,take (
            recursion(prefix + "(", leftBracketCount + 1, rightBracketCount, output, n);
        } else {
            if (leftBracketCount < n) {//( allowed if ( < n
                recursion(prefix + "(", leftBracketCount + 1, rightBracketCount, output, n);
            }
            recursion(prefix + ")", leftBracketCount, rightBracketCount + 1, output, n);
        }
    }

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        System.out.println(solution.generateParenthesis(3));
    }
}

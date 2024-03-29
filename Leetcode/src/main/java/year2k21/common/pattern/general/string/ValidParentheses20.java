package year2k21.common.pattern.general.string;

import java.util.*;

public class ValidParentheses20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new ValidParentheses20().isValid("]["));
    }
}

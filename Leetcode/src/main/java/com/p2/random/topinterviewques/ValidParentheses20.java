package com.p2.random.topinterviewques;

import java.util.Stack;

public class ValidParentheses20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(!isUlta(stack.peek(), c) || stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        return stack.empty();
    }

    private boolean isUlta(char c1, char c2) {
        return c1 == '(' && c2 == ')' ||
                c1 == '{' && c2 == '}' ||
                c1 == '[' && c2 == ']' ;
    }

    public static void main(String[] args) {
        ValidParentheses20 sol = new ValidParentheses20();
        System.out.println(sol.isValid("(){}"));
    }
}

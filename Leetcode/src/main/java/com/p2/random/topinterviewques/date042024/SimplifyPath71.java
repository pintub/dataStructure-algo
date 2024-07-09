package com.p2.random.topinterviewques.date042024;

import java.util.Stack;

public class SimplifyPath71 {

    public static void main(String[] args) {
        SimplifyPath71 solution = new SimplifyPath71();
        System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures"));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        path = path + "/";
        StringBuilder lastStrSb = new StringBuilder();
        for(int count = 1; count <= path.length() - 1; count++){
            if(path.charAt(count) == '/') {
                String lastStr = lastStrSb.toString();
                if(lastStr.isEmpty() || lastStr.equals(".")) {
                    //No Ops
                } else if(lastStr.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(lastStr);
                }
                lastStrSb = new StringBuilder();//Reset
            } else {
                lastStrSb.append(path.charAt(count));
            }
        }

        if(stack.isEmpty()) {
            return "/";
        }

        System.out.println("Stack:" + stack);

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0 , "/" + stack.pop());
        }

        return result.toString();
    }
}

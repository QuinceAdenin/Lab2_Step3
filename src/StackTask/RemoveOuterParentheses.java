package StackTask;

import java.util.Stack;

public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(()()())(())";
        System.out.println(removeOuterParentheses(s));
    }
}
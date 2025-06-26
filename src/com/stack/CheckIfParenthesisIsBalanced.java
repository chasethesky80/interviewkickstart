package com.stack;

import java.util.Stack;

/**
 * CHECK IF A GIVEN SET OF PARENTHESIS IS BALANCED (USE STACK API)
 */
public class CheckIfParenthesisIsBalanced {

    public static void main(String[] args) {
        System.out.println(isBalanced("(()())"));
        System.out.println(isBalanced("({)}"));
        System.out.println(isBalanced("([{}[]]())"));
        System.out.println(isBalanced("([{}[]]()){"));
    }

    /**
     * TC = O(N) and SC = O(N) for using an extra stack
     * @param
     * @return
     */
    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if (c == ')') {
                if (stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

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
        System.out.println(isBalanced(")[]}"));
    }

    /**
     * TC = O(N) and SC = O(N) for using an extra stack
     * @param
     * @return
     */
    private static boolean isBalanced(String str) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (current == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                } else if (current == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                } else if (current == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

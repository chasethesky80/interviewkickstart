package com.stacksandqueues;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * NOTE:
 * All the operations have to be constant time operations.
 * getMin() should return -1 if the stack is empty.
 * pop() should return nothing if the stack is empty.
 * top() should return -1 if the stack is empty.
 */

/**
 * TC = O(1) for all operations and SC = O(N) for the extra minimum stack
 */
public class ImplementAMinimumStack {
    final List<Integer> input = new ArrayList<Integer>();
    final List<Integer> minimums = new ArrayList<Integer>();

    public void push(Integer x) {
        input.add(x);
        if (minimums.isEmpty() || x <= minimums.get(minimums.size() - 1)) {
            minimums.add(x);
        }
    }

    public void pop() {
        if (input.isEmpty()) {
            return;
        }
        if (input.get(input.size() - 1) == minimums.get(minimums.size() - 1)) {
            minimums.remove(minimums.size() - 1);
        }
        input.remove(input.size() - 1);
    }

    public int top() {
        return input.isEmpty() ? -1 : input.get(input.size() - 1);
    }

    public int getMin() {
        if (input.isEmpty()) {
            return -1;
        }
        return minimums.get(minimums.size() - 1);
    }
}

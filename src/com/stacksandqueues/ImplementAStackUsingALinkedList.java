package com.stacksandqueues;

import java.util.LinkedList;

public class ImplementAStackUsingALinkedList {

    private static LinkedList<Node> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        final Node first = new Node(10, null);
        final Node second = new Node(20, first);
        final Node third = new Node(30, second);
        final Node fourth = new Node(40, third);
        push(first);
        push(second);
        push(third);
        push(fourth);
        pop();
        pop();
        System.out.println("ELEMENTS "+ linkedList);
    }

    private static void push(Node element) {
        linkedList.addFirst(element);
    }

    private static void pop() {
        linkedList.removeFirst();
    }
}



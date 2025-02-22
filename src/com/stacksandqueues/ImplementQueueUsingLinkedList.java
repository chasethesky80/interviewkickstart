package com.stacksandqueues;

import java.util.LinkedList;

public class ImplementQueueUsingLinkedList {

    private static LinkedList<Node> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        final Node fourth = new Node(40, null);
        final Node third = new Node(30, fourth);
        final Node second = new Node(20, third);
        final Node first = new Node(10, second);
        enqueue(first);
        enqueue(second);
        enqueue(third);
        enqueue(fourth);
        dequeue();
        dequeue();
        System.out.println("ELEMENTS "+ linkedList);
    }

    private static void enqueue(Node element) {
        linkedList.addLast(element);
    }

    private static void dequeue() {
        linkedList.removeFirst();
    }
}

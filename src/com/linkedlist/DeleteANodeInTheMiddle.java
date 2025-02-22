package com.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * GOOGLE QUESTION: REMOVE A NODE IN THE MIDDLE OF A LINKED LIST. THE ONLY INPUTS ARE THE NODE TO BE DELETED
 * AND THE HEAD POINTER TO THE LINKED LIST IS NOT GIVEN. ALSO PLEASE NOTE THAT THE NODE TO BE DELETED IS NOT
 * THE LAST NODE IN THE LINKED LIST
 * THE TC IS O(1) AND SC IS O(1)
 */
public class DeleteANodeInTheMiddle {

    public static void main(String[] args) {
        final Node last = new Node(4, null);
        final Node third = new Node(3, last);
        final Node second = new Node(2, third);
        final Node first = new Node(1, second);
        final List<Node> input = Arrays.asList(first, second, third, last);
        System.out.println("********* BEFORE REMOVAL *********");
        for (Node element: input) {
            System.out.print(element.getData() +" ");
        }
        System.out.println();
        System.out.println("********* AFTER REMOVAL *********");
        removeNode(third);
        for (Node element: input) {
            if (element.getData() != null) {
                System.out.print(element.getData() + " ");
            }
        }
    }

    private static void removeNode(final Node node) {
        node.setData(node.getNext().getData());
        node.getNext().setData(null);
        node.setNext(node.getNext().getNext());
    }
}

class Node {
    private Integer data;
    private Node next;
    Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getData() { return data; }
    public Node getNext() { return next; }
}
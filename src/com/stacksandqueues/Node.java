package com.stacksandqueues;

public class Node {
    private Integer data;
    private Node next;

    public Integer getData() {
        return data;
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

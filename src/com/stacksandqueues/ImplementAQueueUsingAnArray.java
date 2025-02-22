package com.stacksandqueues;

public class ImplementAQueueUsingAnArray {
    private static int top = -1;
    private static int[] input = new int[100];

    public static void main(String[] args) throws Exception {
        enqueue(1);
        enqueue(4);
        enqueue(-1);
        System.out.println("CURRENT ELEMENT "+ dequeue());
        enqueue(6);
        System.out.println("CURRENT ELEMENT "+ dequeue());
        System.out.println("CURRENT ELEMENT "+ dequeue());
        System.out.println("CURRENT ELEMENT "+ dequeue());
    }

    /**
     * TC = O(1)
     * @param element
     */
    private static void enqueue(int element) {
        if (top < input.length - 1) {
            top++;
            input[top] = element;
        }
    }

    /**
     * TC = O(N) SINCE WE ARE SHIFTING ALL ELEMENTS TO FRONT OF THE QUEUE
     * @return
     * @throws Exception
     */
    private static int dequeue() throws Exception {
        if (top < 0) {
            throw new Exception("Cannot dequeue from an empty array");
        }
        int temp = input[0];
        for (int i = 0; i < top; i++) {
            input[i] = input[i+1];
        }
        top--;
        return temp;
    }
}

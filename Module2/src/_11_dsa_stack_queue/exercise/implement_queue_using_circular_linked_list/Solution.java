package _11_dsa_stack_queue.exercise.implement_queue_using_circular_linked_list;


public class Solution {
    static class Queue {
        Node front, rear;
    }

    static class Node {
        int data;
        Node link;
    }

    static void enQueue(Queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null)
            q.front = temp;
        else
            q.rear.link = temp;

        q.rear = temp;
        q.rear.link = q.front;
    }

    static int deQueue(Queue q) {
        if (q.front == null) {
            System.out.printf("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int value;
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.link;
            q.rear.link = q.front;
        }

        return value;
    }

    public static void main(String[] args) {
        Queue list = new Queue();
        enQueue(list,2);
        enQueue(list,4);
        enQueue(list,6);
        enQueue(list,7);
        System.out.println(list.front.data);
        deQueue(list);
        System.out.println(list.front.data);
    }
}

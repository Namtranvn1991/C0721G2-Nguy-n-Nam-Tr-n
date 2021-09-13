package _10_dsa_list.exercise.implement_the_methods_of_linkedlist;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes = 1;
    }


    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addLast(Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void remove(int index) {
        if (index > numNodes || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + numNodes);
        } else if (index == 0) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public void removeObject(Object o) {
        int index = indexOff(o);
        remove(index);
    }


    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(Object o){
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data == o) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOff(Object o) {
        Node temp = head;
        int index = -1;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data == o) {
                index = i;
                break;
            }
            temp = temp.next;
        }
        return index;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public MyLinkedList clone(){
        MyLinkedList newLinkedList = new MyLinkedList(head.getData());
        Node temp = head;
        for (int i = 0; temp.next != null; i++) {
            temp = temp.next;
            newLinkedList.addLast(temp.getData());
        }
        return newLinkedList;
    }

}
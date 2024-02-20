class Node {
    Node prev;
    String data;
    Node next;

    Node(String data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    public void insert(String data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void print() {
        System.out.println(tail.data);
    }
}
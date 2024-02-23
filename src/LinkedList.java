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
    static Node head;
    static Node tail;

    public static void insert(String data) {
        if (!data.equals("")) {
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
    }
    
    

    public static void print() {
        System.out.println(tail.data);
    }
    
    public static void clear() {
        head = null;
        tail = null;
    }
}
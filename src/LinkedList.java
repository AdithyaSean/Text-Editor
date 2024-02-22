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
    
    public static String undo() {
        if (tail != null) {
            Stack.push(tail.data);
            tail = tail.prev;

            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }

            return tail == null ? "" : tail.data;
        } else {
            return "";
        }
    }
    
    public static String redo() {
        return Stack.peek();
    }

    public static void print() {
        System.out.println(tail.data);
    }
}
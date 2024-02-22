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
    
    public static String undo() {
    if (head == null || head.next == null) {
        System.out.println("Cannot Undo: List is empty or has only one node");
        return ""; // Return an empty string or handle this case as appropriate
    }

    Node currentnode = head;
    Node previousnode = null;
    
    // Traverse to the last node
    while (currentnode.next != null) {
        previousnode = currentnode;
        currentnode = currentnode.next;
    }
    
    // Remove the last node
    currentnode.prev = null;
    if (previousnode != null) {
        previousnode.next = null;
    } else {
        head = null; // Update head if there's only one node in the list
    }

    // Return the data of the new last node if it exists
    if (previousnode != null) {
        return previousnode.data;
    } else {
        return ""; // Return an empty string or handle this case as appropriate
    }
}

    public static void print() {
        System.out.println(tail.data);
    }
}
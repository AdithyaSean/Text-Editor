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
class Stack{
    char [] data;
    int top;
     
    public Stack(){
        data = new char[20];
        top = -1;
    }
    public void push(char c){
        if(top==data.length){
            System.out.println("Reached undo limit");
        }
        else{
            data[++top] = c;
        }
    }

    public void pop(){
        if(top==-1){
            System.out.println("Cannot Redo further");
        }else{
            top -=1;
        }
        
    }
}

public class LinkedList {
    static Node head;
    static Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

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

    public static void print() {
        System.out.println(tail.data);
    }
}
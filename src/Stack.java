public class Stack {
    static int top = -1;
    static String[] data = new String[100];
    
    public static boolean isFull() {
        return top == 99;
    }

    public static boolean isEmpty() {
        return top == -1;
    }
    
    public static void push(String string) {
        if (!isFull()) {
            data[++top] = string;
            System.out.println("value " + string + " added to the stack");            
        } else {
            System.out.println("stack is full");
        }
    }
    
    public static void pop() {
        if (!isEmpty()) {
            System.out.println("value " + data[top--] + " removed from the stack");
        } else {
            System.out.println("stack is empty");
        }
    }
    
    public static String peek() {
        return data[top];
    }
    
    public static void clear() {
        top = -1;
    }
}
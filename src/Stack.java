public class Stack {
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
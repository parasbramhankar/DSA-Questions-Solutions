package Stack.Easy.ImplementStackUsingQueue225;

import java.util.ArrayDeque;
import java.util.Queue;
public class Stack {
    Queue<Integer>queue;
    Stack(){
        queue=new ArrayDeque<>();
    }
    void push(int val){
        int size= queue.size();
        queue.add(val);
        while(size>0) {
            queue.add(queue.peek());
            queue.remove();
            size--;
        }
    }

    int pop(){
        if(queue.isEmpty()){
            return -1;
        }

        return queue.remove();
    }
    int top(){
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }

    boolean isEmpty(){
        return queue.isEmpty();
    }
    void display(){
        System.out.println(queue.toString());
    }
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("stack display: ");
        stack.display();
        System.out.println("\nTop Element: "+stack.top());

        stack.pop();
        stack.pop();

        System.out.println("\nAfter pop operation stack display: ");
        stack.display();

        System.out.println("\nTop Element: "+stack.top());

        System.out.println("\nIsEmpty: "+stack.isEmpty());
    }
}

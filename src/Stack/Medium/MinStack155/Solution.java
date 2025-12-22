package Stack.Medium.MinStack155;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(5);
        System.out.println("Pushed 5");

        minStack.push(3);
        System.out.println("Pushed 3");

        minStack.push(7);
        System.out.println("Pushed 7");

        System.out.println("Top element: " + minStack.top());      // 7
        System.out.println("Minimum element: " + minStack.getMin()); // 3

        minStack.pop();
        System.out.println("Popped top");

        System.out.println("Top element: " + minStack.top());      // 3
        System.out.println("Minimum element: " + minStack.getMin()); // 3

        minStack.pop();
        System.out.println("Popped top");

        System.out.println("Top element: " + minStack.top());      // 5
        System.out.println("Minimum element: " + minStack.getMin()); // 5
    }
}


class MinStack {
    Stack<Integer> stack;
    Stack<Integer>minStack;

    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.add(val);
        }
    }

    public void pop() {

        if(stack.isEmpty()){
            return ;
        }

        int ele=stack.pop();

        if(!minStack.isEmpty() && ele==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {

        if(stack.isEmpty()){
            return -1;
        }

        return stack.peek();
    }

    public int getMin() {

        if(stack.isEmpty()){
            return -1;
        }

        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
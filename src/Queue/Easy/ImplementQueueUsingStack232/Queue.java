package Queue.Easy.ImplementQueueUsingStack232;

import java.util.Stack;


/*
 In this case we are considering the push is too much frequent operation
 &
 pop and top are too rare operations
 */

public class Queue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: push into stack1
    void enqueue(int val) {
        stack1.push(val);
    }

    // Dequeue operation: if stack2 empty, transfer from stack1, then pop
    int deque() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1; // Queue empty condition
        }
        return stack2.pop();
    }

    // Top operation: if stack2 empty, transfer from stack1, then peek
    int top() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1; // Queue empty condition
        }
        return stack2.peek();
    }

    // Check if both stacks are empty
    boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Display queue elements (front to rear)
    void display() {
        // Display stack2 (top to bottom) followed by stack1 (bottom to top)
        System.out.print("Queue elements: ");
        Stack<Integer> tempStack = new Stack<>();

        // Print stack2 from top to bottom (front of queue to middle)
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }

        // For stack1, to print in order (bottom to top), push to tempStack and then print
        for (Integer integer : stack1) {
            tempStack.push(integer);
        }
        while (!tempStack.isEmpty()) {
            System.out.print(tempStack.pop() + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("Enqueue Operations: ");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display(); // display current queue

        System.out.println("Deque operation: ");
        System.out.println(queue.deque()); // should remove 10
        System.out.println(queue.deque()); // should remove 20

        queue.display(); // display after dequeue

        System.out.println("Top Element: " + queue.top()); // should show 30

        queue.deque();

        System.out.println("Top Element: " + queue.top()); // should show 40

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}


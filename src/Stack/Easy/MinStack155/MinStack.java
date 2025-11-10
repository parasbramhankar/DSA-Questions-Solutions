package Stack.Easy.MinStack155;

import java.util.Stack;

class MinStack {
    /*
     * Problem: LeetCode 155 — Min Stack
     * ----------------------------------
     * Design a stack that supports the following operations in O(1) time:
     *   1. push(int val)   → Pushes element onto the stack.
     *   2. pop()           → Removes the element on top of the stack.
     *   3. top()           → Gets the top element of the stack.
     *   4. getMin()        → Retrieves the minimum element in the stack.
     *
     * -------------------------------------------------------------------------
     * APPROACH / ALGORITHM (Using Two Stacks)
     * -------------------------------------------------------------------------
     * We use:
     *   → 'stack'     : to store all pushed elements normally.
     *   → 'minStack'  : to store the minimum element at each state.
     *
     * The key idea is that `minStack.peek()` always represents the current
     * minimum element of the entire stack at that moment.
     *
     * -------------------------------------------------------------------------
     * STEP-BY-STEP LOGIC:
     * -------------------------------------------------------------------------
     * 1️⃣ push(int val)
     *    - Push 'val' onto 'stack'.
     *    - If 'minStack' is empty or 'val' <= minStack.peek(),
     *      also push 'val' into 'minStack'.
     *    - This ensures the top of 'minStack' always has the smallest value so far.
     *
     * 2️⃣ pop()
     *    - Pop the top element from 'stack'.
     *    - If the popped element equals 'minStack.peek()', pop from 'minStack' too.
     *      (This keeps both stacks in sync for the current minimum.)
     *
     * 3️⃣ top()
     *    - Return the top element of 'stack'.
     *    - If stack is empty, return -1 as a safe fallback.
     *
     * 4️⃣ getMin()
     *    - Return the top element of 'minStack' (current minimum).
     *    - If minStack is empty, return -1 as a safe fallback.
     *
     * -------------------------------------------------------------------------
     * EXAMPLE TRACE:
     * -------------------------------------------------------------------------
     * Push sequence: [2, 0, 3, 0]
     *
     * After pushing each element:
     *   stack    → [2]
     *   minStack → [2]
     *
     *   stack    → [2, 0]
     *   minStack → [2, 0]
     *
     *   stack    → [2, 0, 3]
     *   minStack → [2, 0]
     *
     *   stack    → [2, 0, 3, 0]
     *   minStack → [2, 0, 0]
     *
     * Popping:
     *   pop() → removes 0 → also pop from minStack
     *   getMin() → 0
     *
     *   pop() → removes 3 → minStack unchanged
     *   getMin() → 0
     *
     *   pop() → removes 0 → also pop from minStack
     *   getMin() → 2
     *
     * -------------------------------------------------------------------------
     * TIME COMPLEXITY:
     *   - push()   → O(1)
     *   - pop()    → O(1)
     *   - top()    → O(1)
     *   - getMin() → O(1)
     *
     * SPACE COMPLEXITY:
     *   - O(n) → due to storing elements in both stacks.
     * -------------------------------------------------------------------------
     */

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (!minStack.isEmpty() && top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Push elements
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        // Print current minimum
        System.out.println("Current Min: " + minStack.getMin()); // 0

        // Pop top element and check min
        minStack.pop();
        System.out.println("After 1 pop → Min: " + minStack.getMin()); // 0

        // Pop another and check min
        minStack.pop();
        System.out.println("After 2 pops → Min: " + minStack.getMin()); // 0

        // Pop another and check min
        minStack.pop();
        System.out.println("After 3 pops → Min: " + minStack.getMin()); // 2

        // Check top element
        System.out.println("Top element: " + minStack.top()); // 2

        // Push another and verify
        minStack.push(1);
        System.out.println("Pushed 1 → New Min: " + minStack.getMin()); // 1
    }
}


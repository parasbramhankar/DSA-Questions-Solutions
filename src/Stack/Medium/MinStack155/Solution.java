package Stack.Medium.MinStack155;

import java.util.Stack;
/*
================================================================================
Problem: Min Stack (LeetCode 155)
================================================================================

Problem Statement:
------------------
Design a stack that supports the following operations in O(1) time:

1. push(val)  → Push element val onto the stack
2. pop()      → Remove the element on the top of the stack
3. top()      → Get the top element of the stack
4. getMin()   → Retrieve the minimum element in the stack

IMPORTANT:
----------
All operations must run in CONSTANT TIME → O(1)

================================================================================
WHY A NORMAL STACK IS NOT ENOUGH?
================================================================================

If we use only ONE stack:
- push()  → O(1)
- pop()   → O(1)
- top()   → O(1)
- getMin()→ O(n)  ❌ (need to scan entire stack)

So, normal stack FAILS the requirement.

================================================================================
OPTIMAL APPROACH: TWO STACKS
================================================================================

We use:
---------
1. stack     → stores ALL elements
2. minStack  → stores ONLY minimum elements till that point

Idea:
-----
At any moment:
- top of `stack`    → actual top element
- top of `minStack`→ minimum element so far

================================================================================
DATA STRUCTURE DESIGN
================================================================================

stack:
------
Stores all pushed elements in normal order.

minStack:
---------
Stores minimum elements in such a way that:
- Top of minStack always contains the CURRENT MINIMUM

================================================================================
STEP-BY-STEP LOGIC
================================================================================

-------------------
push(val):
-------------------
1. Push val into `stack`
2. If minStack is empty OR val <= minStack.peek():
      push val into minStack
Reason:
- New value might become the new minimum

-------------------
pop():
-------------------
1. Pop element from `stack`
2. If popped element == minStack.peek():
      pop from minStack as well
Reason:
- We are removing the current minimum

-------------------
top():
-------------------
Return stack.peek()

-------------------
getMin():
-------------------
Return minStack.peek()

================================================================================
DRY RUN (DETAILED)
================================================================================

Operations Sequence:
--------------------
push(5)
push(3)
push(7)
top()
getMin()
pop()
top()
getMin()
pop()
top()
getMin()

------------------------------------------------
Initial State:
stack     = []
minStack  = []

------------------------------------------------
push(5)
stack.push(5)
minStack is empty → push 5

stack     = [5]
minStack  = [5]

------------------------------------------------
push(3)
stack.push(3)
3 <= minStack.peek(5) → push 3 into minStack

stack     = [5, 3]
minStack  = [5, 3]

------------------------------------------------
push(7)
stack.push(7)
7 > minStack.peek(3) → DO NOT push into minStack

stack     = [5, 3, 7]
minStack  = [5, 3]

------------------------------------------------
top()
Return stack.peek() → 7

------------------------------------------------
getMin()
Return minStack.peek() → 3

------------------------------------------------
pop()
Pop from stack → 7
7 != minStack.peek(3) → do nothing

stack     = [5, 3]
minStack  = [5, 3]

------------------------------------------------
top()
Return 3

------------------------------------------------
getMin()
Return 3

------------------------------------------------
pop()
Pop from stack → 3
3 == minStack.peek(3) → pop from minStack

stack     = [5]
minStack  = [5]

------------------------------------------------
top()
Return 5

------------------------------------------------
getMin()
Return 5

================================================================================
TIME & SPACE COMPLEXITY
================================================================================

Time Complexity:
----------------
push()   → O(1)
pop()    → O(1)
top()    → O(1)
getMin() → O(1)

Space Complexity:
-----------------
O(n)
Extra stack (minStack) used

================================================================================
KEY INTERVIEW TAKEAWAYS
================================================================================
✔ Use TWO STACKS
✔ minStack tracks minimums only
✔ Use <= while pushing to handle duplicate minimums
✔ All operations in O(1)
✔ Clean and optimal solution

================================================================================
*/

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
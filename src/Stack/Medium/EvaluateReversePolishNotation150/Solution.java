package Stack.Medium.EvaluateReversePolishNotation150;

import java.util.Stack;
/*
================================================================================
Problem: Evaluate Reverse Polish Notation (LeetCode 150)
================================================================================

Problem Statement:
------------------
You are given an array of strings `tokens` that represents an arithmetic
expression in Reverse Polish Notation (RPN).

Evaluate the expression and return the result.

Rules:
------
1. Valid operators are: "+", "-", "*", "/"
2. Each operand is an integer.
3. Division between two integers should truncate toward zero.
4. The input expression is always valid.

Example 1:
----------
Input : ["2","1","+","3","*"]
Output: 9

Explanation:
((2 + 1) * 3) = 9

Example 2:
----------
Input : ["4","13","5","/","+"]
Output: 6

Explanation:
(4 + (13 / 5)) = 6   → 13 / 5 = 2 (integer division)

================================================================================
WHY STACK?
================================================================================

Reverse Polish Notation evaluates expressions from LEFT to RIGHT.

Key observations:
-----------------
1. Operands come BEFORE operators
2. When an operator appears, it always applies to the LAST TWO operands
3. Stack is ideal for LIFO (Last In, First Out) behavior

So:
----
✔ Push operands onto stack
✔ On operator → pop two elements → apply operator → push result back

================================================================================
APPROACH
================================================================================

1. Create an empty stack of integers.
2. Traverse the `tokens` array one by one.
3. For each token:
   - If token is an OPERATOR:
        a) Pop the top two elements from stack
        b) Apply the operation
        c) Push the result back to stack
   - Else (operand):
        a) Convert string to integer
        b) Push into stack
4. At the end, stack will contain only ONE element → final result

================================================================================
IMPORTANT ORDER NOTE (VERY IMPORTANT FOR INTERVIEWS)
================================================================================

For operators "-" and "/":

Order matters!

If stack contains:
-----------------
[top]   first
        second

Then:
------
Subtraction → second - first
Division    → second / first

This is why code uses:
---------------------
int first = stack.pop();
int second = stack.pop();

================================================================================
STEP-BY-STEP DRY RUN
================================================================================

-------------------------
Example 1:
-------------------------
tokens = ["2","1","+","3","*"]

Initialize:
stack = []

------------------------------------------------
Token = "2" → operand
Push 2
stack = [2]

------------------------------------------------
Token = "1" → operand
Push 1
stack = [2, 1]

------------------------------------------------
Token = "+"
Pop 1 and 2
Compute: 2 + 1 = 3
Push result
stack = [3]

------------------------------------------------
Token = "3" → operand
Push 3
stack = [3, 3]

------------------------------------------------
Token = "*"
Pop 3 and 3
Compute: 3 * 3 = 9
Push result
stack = [9]

------------------------------------------------
END

Final Answer = stack.peek() = 9

================================================================================
SECOND DRY RUN
================================================================================

-------------------------
Example 2:
-------------------------
tokens = ["4","13","5","/","+"]

Initialize:
stack = []

------------------------------------------------
Token = "4"
Push 4
stack = [4]

------------------------------------------------
Token = "13"
Push 13
stack = [4, 13]

------------------------------------------------
Token = "5"
Push 5
stack = [4, 13, 5]

------------------------------------------------
Token = "/"
Pop first = 5
Pop second = 13
Compute: 13 / 5 = 2 (integer division)
Push result
stack = [4, 2]

------------------------------------------------
Token = "+"
Pop 2 and 4
Compute: 4 + 2 = 6
Push result
stack = [6]

------------------------------------------------
END

Final Answer = stack.peek() = 6

================================================================================
TIME & SPACE COMPLEXITY
================================================================================

Time Complexity:
----------------
O(n)
Each token is processed exactly once.

Space Complexity:
-----------------
O(n)
Stack may store up to n elements in worst case.

================================================================================
KEY INTERVIEW TAKEAWAYS
================================================================================
✔ Classic STACK problem
✔ Always pop TWO elements for operator
✔ Order matters for "-" and "/"
✔ Clean one-pass solution
✔ No need to build expression tree

================================================================================
*/

public class Solution {

    public static int evaluateExpression(String[] tokens){
        Stack<Integer>str=new Stack<>();

        for(String s:tokens){
            if(s.equals("+")){
                str.push(str.pop()+str.pop());
            } else if (s.equals("-")) {
                int first=str.pop();
                int sec=str.pop();
                str.push(sec-first);
            } else if (s.equals("/")) {
                int first=str.pop();
                int sec=str.pop();

                str.push(sec/first);
            } else if (s.equals("*")) {
                str.push(str.pop()*str.pop());
            }else{
                str.push(Integer.parseInt(s));
            }
        }

        return str.peek();
    }
    public static void main(String[] args) {

        String []str1=new String[]{"2","1","+","3","*"};
        String []str2=new String[]{"4","13","5","/","+"};

        int ans=evaluateExpression(str1);
        int ans1=evaluateExpression(str2);

        System.out.println("Final ans: "+ans);
        System.out.println("Final ans: "+ans1);

    }
}

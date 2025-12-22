package Stack.Medium.DailyTemperatures739;

import java.util.Arrays;
import java.util.Stack;
/*
================================================================================
Problem: Daily Temperatures (LeetCode 739)
================================================================================

Problem Statement:
------------------
Given an array `temp[]` where temp[i] represents the temperature on day i,
return an array `ans[]` such that:
ans[i] = number of days you have to wait after day i to get a warmer temperature.
If there is no future day for which this is possible, ans[i] = 0.

Example:
---------
Input :  [73, 74, 75, 71, 69, 72, 76, 73]
Output:  [1,  1,  4,  2,  1,  1,  0,  0]

================================================================================
APPROACH: MONOTONIC DECREASING STACK
================================================================================

Key Idea:
---------
We want to find the NEXT GREATER ELEMENT (temperature) to the right
for each day.

Instead of checking all future days (O(n^2)),
we use a STACK to store indices of temperatures.

The stack maintains a MONOTONIC DECREASING ORDER of temperatures:
- The temperatures at indices in the stack are always decreasing.
- Stack stores INDICES, not values (so we can calculate day difference).

================================================================================
WHY STACK OF INDICES?
================================================================================
1. We need to calculate: (currentDay - previousDay)
2. Using indices allows direct access to both:
   - temperature value: temp[index]
   - distance calculation

================================================================================
STEP-BY-STEP LOGIC
================================================================================

1. Create an empty stack that stores indices.
2. Create an answer array `ans[]` initialized with 0.
3. Traverse the temperature array from LEFT to RIGHT.
4. For each day `i`:
   - While stack is NOT empty AND
     current temperature > temperature at stack's top index:
        - This means we found a warmer day for stack.peek()
        - Calculate days difference:
              ans[stack.peek()] = i - stack.peek()
        - Pop the index from stack (its answer is finalized)
   - Push current index `i` into the stack
5. After loop ends:
   - Any index left in stack has no warmer future day
   - Their answer remains 0 (default value)

================================================================================
DRY RUN (DETAILED)
================================================================================

Input:
temp = [73, 74, 75, 71, 69, 72, 76, 73]
Index:   0   1   2   3   4   5   6   7

Initialize:
stack = []
ans   = [0,0,0,0,0,0,0,0]

------------------------------------------------
i = 0, temp[i] = 73
stack is empty → push index 0
stack = [0]

------------------------------------------------
i = 1, temp[i] = 74
74 > temp[0] = 73 → pop 0
ans[0] = 1 - 0 = 1
push index 1
stack = [1]

ans = [1,0,0,0,0,0,0,0]

------------------------------------------------
i = 2, temp[i] = 75
75 > temp[1] = 74 → pop 1
ans[1] = 2 - 1 = 1
push index 2
stack = [2]

ans = [1,1,0,0,0,0,0,0]

------------------------------------------------
i = 3, temp[i] = 71
71 < temp[2] = 75 → no pop
push index 3
stack = [2,3]

------------------------------------------------
i = 4, temp[i] = 69
69 < temp[3] = 71 → no pop
push index 4
stack = [2,3,4]

------------------------------------------------
i = 5, temp[i] = 72
72 > temp[4] = 69 → pop 4
ans[4] = 5 - 4 = 1

72 > temp[3] = 71 → pop 3
ans[3] = 5 - 3 = 2

72 < temp[2] = 75 → stop popping
push index 5
stack = [2,5]

ans = [1,1,0,2,1,0,0,0]

------------------------------------------------
i = 6, temp[i] = 76
76 > temp[5] = 72 → pop 5
ans[5] = 6 - 5 = 1

76 > temp[2] = 75 → pop 2
ans[2] = 6 - 2 = 4

push index 6
stack = [6]

ans = [1,1,4,2,1,1,0,0]

------------------------------------------------
i = 7, temp[i] = 73
73 < temp[6] = 76 → no pop
push index 7
stack = [6,7]

------------------------------------------------
END OF LOOP

Remaining indices in stack (6,7) have no warmer future days
Their values remain 0

FINAL ANSWER:
[1, 1, 4, 2, 1, 1, 0, 0]

================================================================================
TIME & SPACE COMPLEXITY
================================================================================

Time Complexity:
----------------
O(n)
Each index is pushed and popped at most once.

Space Complexity:
-----------------
O(n)
Stack can hold at most n indices.

================================================================================
KEY INTERVIEW TAKEAWAYS
================================================================================
✔ This is a classic "Next Greater Element" problem
✔ Stack is MONOTONIC DECREASING
✔ Use indices, not values
✔ One-pass solution → optimal

================================================================================
*/

public class Solution {

    static int[] function(int[]temp){

        Stack<Integer>stack=new Stack<>();
        int[]ans=new int[temp.length];

        for(int i=0;i<temp.length;i++){

            while(!stack.isEmpty() && temp[i]>temp[stack.peek()]){
                ans[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[]temp=new int[]{73,74,75,71,69,72,76,73};

        int []ans=function(temp);

        System.out.println("Answer: "+ Arrays.toString(ans));
    }
}

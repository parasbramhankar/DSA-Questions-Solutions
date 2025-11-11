package Stack.Easy.ValidParentheses20;

import java.util.Stack;

public class Solution {

    /*
     * Problem: LeetCode 20 — Valid Parentheses
     * ----------------------------------------
     * Given a string 's' consisting of characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     *
     * A string is considered valid if:
     *  1. Open brackets are closed by the same type of brackets.
     *  2. Open brackets are closed in the correct order.
     *  3. Every closing bracket has a corresponding opening bracket before it.
     *
     * ---------------------------------------------------------------------------
     * APPROACH / ALGORITHM (Using Stack Data Structure)
     * ---------------------------------------------------------------------------
     *
     * 1. Use a Stack<Character> to keep track of the opening brackets.
     *    - Stack works on the LIFO principle (Last-In, First-Out),
     *      which perfectly matches the nested structure of parentheses.
     *
     * 2. Traverse each character 'c' in the string 's':
     *
     *    a) If 'c' is an opening bracket — '(' or '{' or '[':
     *       -> Push it into the stack.
     *
     *    b) Else (if 'c' is a closing bracket — ')' or '}' or ']'):
     *       -> First check if the stack is empty:
     *          - If YES → There’s no opening bracket to match this closing one,
     *            so the string is invalid → return false.
     *
     *       -> Otherwise, pop the top character from the stack (let's call it 'ch').
     *          Then, check if 'ch' and 'c' form a valid pair:
     *             '(' matches ')'
     *             '{' matches '}'
     *             '[' matches ']'
     *
     *          - If the popped character 'ch' does NOT match the current
     *            closing bracket 'c', then the string is invalid → return false.
     *
     * 3. After processing all characters:
     *    - If the stack is empty → All opening brackets were properly matched
     *      and closed → return true (valid string).
     *    - If the stack is not empty → Some opening brackets didn’t find matches
     *      → return false (invalid string).
     *
     * ---------------------------------------------------------------------------
     * EXAMPLES:
     *
     * Example 1:
     * Input: s = "([])"
     * Step-by-step:
     *   '(' → push '('
     *   '[' → push '['
     *   ']' → pop '[' (matches, OK)
     *   ')' → pop '(' (matches, OK)
     * Stack empty → Valid → return true
     *
     * Example 2:
     * Input: s = "([)]"
     * Step-by-step:
     *   '(' → push '('
     *   '[' → push '['
     *   ')' → pop '[' (doesn't match ')') → return false
     *
     * Example 3:
     * Input: s = "("
     * Step-by-step:
     *   '(' → push '('
     * End → stack not empty → return false
     *
     * ---------------------------------------------------------------------------
     * TIME COMPLEXITY:  O(n) — We process each character once.
     * SPACE COMPLEXITY: O(n) — In the worst case, all characters are opening brackets.
     * ---------------------------------------------------------------------------
     */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Step 1: Push opening brackets into the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // Step 2: If closing bracket found but stack is empty → invalid
                if (stack.isEmpty()) {
                    return false;
                }

                // Step 3: Pop the top element from the stack
                char ch = stack.pop();

                // Step 4: Check if popped element matches the closing bracket
                if ((c == ')' && ch != '(') ||
                        (c == ']' && ch != '[') ||
                        (c == '}' && ch != '{')) {
                    return false;
                }
            }
        }

        // Step 5: If stack still has elements → not all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String[] testCases = {
                "()",        // valid
                "()[]{}",    // valid
                "(]",        // invalid
                "([)]",      // invalid
                "{[]}",      // valid
                "(",         // invalid
                "]"          // invalid
        };

        // Print results for each test case
        for (String test : testCases) {
            boolean result = solution.isValid(test);
            System.out.println("Input: " + test + " → isValid = " + result);
        }
    }
}
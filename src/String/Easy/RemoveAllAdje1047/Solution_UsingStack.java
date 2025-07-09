package String.Easy.RemoveAllAdje1047;

import java.util.Stack;

public class Solution_UsingStack {
        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();  // Remove duplicate
                } else {
                    stack.push(ch);  // Add character to stack
                }
            }

            // Build the final string from stack
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }

            return result.toString();
        }



}

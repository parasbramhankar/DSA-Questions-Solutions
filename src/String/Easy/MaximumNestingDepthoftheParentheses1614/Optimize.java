package String.Easy.MaximumNestingDepthoftheParentheses1614;

import java.util.Scanner;
/*
🧠 Problem: 1614. Maximum Nesting Depth of the Parentheses

🎯 Goal: Find the maximum depth of nested parentheses in a valid string.

📌 Approach:
1. Initialize two variables:
   - `depth` = current level of open parentheses.
   - `maxDepth` = maximum value of depth during the scan.

2. Traverse the string:
   - If character is '(', increase depth.
   - If character is ')', update maxDepth (if current depth is greater),
     then decrease depth.

3. Return maxDepth as the final result.

📌 Time Complexity: O(n)
📌 Space Complexity: O(1)
*/


public class Optimize {

    // Function to find the maximum nesting depth of parentheses
    public static int function(String s){
        int n = s.length();       // Length of the input string
        int maxDepth = 0;         // Stores the maximum depth found
        int depth = 0;            // Tracks the current depth while traversing

        // Traverse each character in the string
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                // Opening bracket increases the current depth
                depth++;
            }
            else if(s.charAt(i) == ')'){
                // Before decreasing depth, update maxDepth
                maxDepth = Math.max(maxDepth, depth);
                // Closing bracket decreases the current depth
                depth--;
            }
        }

        // Return the maximum depth of nested parentheses
        return maxDepth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input string from user
        System.out.print("Enter a valid parentheses string: ");
        String str = scanner.next();

        // Call the function to get max depth
        int result = function(str);

        // Print the result
        System.out.println("Maximum depth of the parenthesis: " + result);
    }
}


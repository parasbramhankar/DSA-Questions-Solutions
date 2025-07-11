package String.Easy.MaximumNestingDepthoftheParentheses1614;
/*
🧠 Brute Force Logic:

1. Iterate through the string and for every closing bracket `)` at position `j`,
   check how many unmatched opening brackets `(` are present before it (from 0 to j).

2. Count how many opening brackets `(` are not closed yet while moving from left to right.

3. At every closing bracket `)`, the current count of open brackets = current depth.

4. Keep updating the max depth at each step.

📌 Time Complexity: O(n^2) → because at every `)` you might scan all characters before it.
📌 Space Complexity: O(1)
*/


import java.util.Scanner;

public class BruteForce {

    // Brute force method to find maximum depth of nested parentheses
    public static int function(String s) {
        int maxDepth = 0;

        // Loop through each character of the string
        for (int i = 0; i < s.length(); i++) {
            // Only act when we encounter a closing bracket ')'
            if (s.charAt(i) == ')') {
                int depth = 0;

                // Look back from i to 0 to count unmatched '('
                for (int j = i; j >= 0; j--) {
                    if (s.charAt(j) == ')') {
                        depth--;
                    } else if (s.charAt(j) == '(') {
                        depth++;
                    }

                    // When depth becomes 0, the pair is balanced — break out
                    if (depth == 0) {
                        break;
                    }
                }

                // Update maxDepth with depth counted so far
                maxDepth = Math.max(maxDepth, countOpenBrackets(s, i));
            }
        }

        return maxDepth;
    }

    // Helper function to count open brackets before index i
    private static int countOpenBrackets(String s, int endIndex) {
        int count = 0;
        for (int i = 0; i <= endIndex; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a valid parentheses string: ");
        String str = scanner.next();

        int result = function(str);

        System.out.println("Maximum depth (brute force): " + result);
    }
}


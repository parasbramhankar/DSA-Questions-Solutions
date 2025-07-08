package String.Easy.ConsecutiveCharacters1446;


/*
 ✅ Problem Statement (LeetCode 1446 - Consecutive Characters):

 You are given a string `s`, and you need to find the maximum power of the string.
 The Power of a string is defined as the maximum length of a substring that contains
 only one unique character and occurs consecutively.

 🧠 Approach and Logic:

 1. Initialize Variables:
    - max: To keep track of the maximum length of consecutive characters found.
    - count: To count the length of the current streak of identical characters.
    - n: Length of the string.

 2. Traverse the string:
    - If current character == previous character: increase the count.
    - Else: update max and reset count to 0.

 3. Final Return:
    - Return Math.max(max, count) + 1. We use +1 because the initial count was 0
      but each streak includes the starting character.

 ✅ Time Complexity: O(n)
 ✅ Space Complexity: O(1)

 🔍 Example:
 For input "abbcccddddeeeeedcba", max streak = "eeeee" → Output: 5
*/


public class Optimize {

    /**
     * This method returns the maximum length of a substring with consecutive repeating characters.
     */
    public int maxPower(String str) {
        int max = 0;              // Stores the maximum length found so far
        int count = 0;            // Current streak count
        int n = str.length();     // Length of the string

        // Traverse the string character by character
        for (int i = 0; i < n; i++) {
            // If current character is same as the previous one
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                count++; // Continue the current streak
            } else {
                // Streak broke, update max and reset count
                max = Math.max(max, count);
                count = 0; // Reset for new character
            }
        }

        // Final comparison in case the longest streak is at the end of the string
        return Math.max(max, count) + 1;
    }

    public static void main(String[] args) {
        Optimize obj = new Optimize();

        // Sample test cases
        String input1 = "leetcode";
        String input2 = "abbcccddddeeeeedcba";
        String input3 = "triplepillooooow";

        // Display results
        System.out.println("Max Power of \"" + input1 + "\": " + obj.maxPower(input1));       // Output: 2
        System.out.println("Max Power of \"" + input2 + "\": " + obj.maxPower(input2));       // Output: 5
        System.out.println("Max Power of \"" + input3 + "\": " + obj.maxPower(input3));       // Output: 5
    }
}


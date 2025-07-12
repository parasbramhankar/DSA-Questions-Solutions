package String.Medium.LongestPalindromicSubstring5;
/**
 * 🔰 LeetCode 5: Longest Palindromic Substring
 *
 * ✅ Problem:
 * Given a string `s`, return the longest palindromic substring in `s`.
 *
 * ✅ Approach: Brute Force
 * 1. Generate all substrings of the input string using two loops.
 * 2. For each substring, check if it is a palindrome.
 * 3. Track the longest one found.
 *
 * ✅ Time Complexity: O(n³)
 * ✅ Space Complexity: O(1)
 *
 * ✅ Dry Run for "babad":
 * All substrings: "b", "ba", "bab", "baba", "babad", "a", "ab", "aba", ...
 * Palindromes found: "b", "bab", "aba", "a", "d"
 * Longest = "bab" or "aba"
 */

public class BruteForce {
    /**
     * 🔍 Helper method to check if a given string is a palindrome.
     *
     * @param str the input string to check
     * @return true if str is a palindrome, false otherwise
     */
    public static boolean checkPalindrome(String str) {
        int low = 0;                      // Start index
        int high = str.length() - 1;     // End index

        // Compare characters from both ends toward the center
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false; // Not a palindrome
            }
            low++;
            high--;
        }

        return true; // All characters matched
    }

    /**
     * ✅ Main method to find the longest palindromic substring.
     *
     * @param s the input string
     * @return the longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        int n = s.length();             // Length of the input string
        int maxLength = 0;              // Stores the length of the longest palindrome found
        String finalString = "";        // Stores the longest palindromic substring

        // Loop to fix the starting point of the substring
        for (int i = 0; i < n; i++) {
            // Loop to fix the ending point of the substring
            for (int j = i; j <= n; j++) {
                // Extract substring from index i to j-1
                String str = s.substring(i, j);

                // Check if the substring is a palindrome
                if (checkPalindrome(str)) {
                    int len = str.length();

                    // Update longest palindrome if this one is longer
                    if (len > maxLength) {
                        maxLength = len;
                        finalString = str;
                    }
                }
            }
        }

        return finalString; // Return the longest palindromic substring
    }

    /**
     * 🧪 Main method to test the logic
     */
    public static void main(String[] args) {

        String s = "babad";  // You can change this test case
        String result = longestPalindrome(s);

        System.out.println("Longest Palindromic Substring: " + result);
    }

}

package String.Medium.ReverseWordsInString151;

/**
 * 🔰 LeetCode 151: Reverse Words in a String
 *
 * ✅ Problem:
 * Given an input string `s`, reverse the order of words.
 * A word is defined as a sequence of non-space characters.
 * Return a string with:
 * - Words in reversed order
 * - Only single spaces between words
 * - No leading or trailing spaces
 *
 * --------------------------------------------------------------------------------
 *
 * ✅ Optimized Approach (Simulated In-Place using StringBuilder):
 *
 * 🔹 Step 1: Remove extra spaces
 *   - Trim the string to remove leading/trailing spaces
 *   - Convert the string to a new StringBuilder that removes:
 *     - Multiple spaces between words
 *     - Leading/trailing spaces
 *
 * 🔹 Step 2: Reverse the entire string
 *   - For example: "the sky" becomes "yks eht"
 *
 * 🔹 Step 3: Reverse each individual word inside the reversed string
 *   - "yks eht" → "sky the"
 *
 * 🔹 Why this works:
 *   - First reverse gives correct **word order**
 *   - Second reversal fixes each word's **character order**
 *
 * --------------------------------------------------------------------------------
 *
 * ✅ Example:
 * Input : "  hello   world  "
 * Step 1 (trim & remove extra): "hello world"
 * Step 2 (reverse entire): "dlrow olleh"
 * Step 3 (reverse each word): "world hello"
 * Output: "world hello"
 *
 * --------------------------------------------------------------------------------
 *
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(n) (because Java String is immutable, we use StringBuilder)
 *
 */



public class Optimize {
        // Main function to reverse words in a string
        public static String reverseWords(String s) {
            // Step 1: Trim the input and remove extra spaces between words
            s = s.trim(); // remove leading and trailing spaces
            StringBuilder sb = removeExtraSpaces(s);

            // Step 2: Reverse the entire string (all characters)
            reverse(sb, 0, sb.length() - 1);

            // Step 3: Reverse each individual word to restore proper word characters
            reverseEachWord(sb);

            return sb.toString(); // Return final reversed sentence
        }

        //  Step 1: Remove extra spaces between words
        private static StringBuilder removeExtraSpaces(String s) {
            StringBuilder sb = new StringBuilder();
            boolean spaceFound = false;

            for (char ch : s.toCharArray()) {
                if (ch != ' ') {
                    sb.append(ch);       // Add valid characters
                    spaceFound = false; // Reset flag
                } else if (!spaceFound) {
                    sb.append(' ');      // Add only a single space
                    spaceFound = true;   // Block further spaces until a character appears
                }
            }

            return sb; // Cleaned string without extra spaces
        }

        //  Step 2: Reverse characters from index `left` to `right`
        private static void reverse(StringBuilder sb, int left, int right) {
            while (left < right) {
                // Swap characters at left and right
                char temp = sb.charAt(left);
                sb.setCharAt(left++, sb.charAt(right));
                sb.setCharAt(right--, temp);
            }
        }

        //  Step 3: Reverse each word in the reversed string
        private static void reverseEachWord(StringBuilder sb) {
            int n = sb.length();
            int start = 0;

            for (int end = 0; end <= n; end++) {
                // When we reach the end of a word or the end of the string
                if (end == n || sb.charAt(end) == ' ') {
                    reverse(sb, start, end - 1); // Reverse the word
                    start = end + 1;             // Move to next word
                }
            }
        }

        // Test the function
        public static void main(String[] args) {
            String input = "  the   sky  is blue  ";
            String result = reverseWords(input);
            System.out.println("🔁 Reversed Words: " + result); // Output: "blue is sky the"
        }


}

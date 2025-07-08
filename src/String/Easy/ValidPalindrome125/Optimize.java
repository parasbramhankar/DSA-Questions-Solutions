package String.Easy.ValidPalindrome125;


/**
 * This method checks if a given string is a valid palindrome.
 * It ignores non-alphanumeric characters and is case-insensitive.
 * <p>
 * ✅ Logic:
 * 1. Use two pointers (start and end) to scan the string from both sides.
 * 2. Skip characters that are not letters or digits using Character.isLetterOrDigit().
 * 3. Compare the characters at the start and end after converting them to lowercase.
 * 4. If at any point the characters don't match, return false.
 * 5. If the entire string is checked without mismatches, return true.
 */


public class Optimize {

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            // Move start forward if current character is not alphanumeric
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            // Move end backward if current character is not alphanumeric
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            // Compare characters at start and end (in lowercase)
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false; // Mismatch found
            }

            // Move both pointers inward
            start++;
            end--;
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        //String str = "race a car"

        if (isPalindrome(str)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }
}

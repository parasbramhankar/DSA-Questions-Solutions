package String.Medium.StringToInter_Atoi8;
/**
  This class implements the solution for the LeetCode Problem 8: String to Integer (atoi).

  Approach:
  1. Trim leading and trailing spaces using s.trim().
  2. If the string is empty, return 0.
  3. Check if the first character is a sign (+ or -). Record the sign and move the pointer.
  4. Now, scan through digits one by one to build the integer number.
  5. While adding digits, check for potential overflow:
     - If num > Integer.MAX_VALUE / 10 OR
       (num == Integer.MAX_VALUE / 10 AND currentDigit > 7), return Integer.MAX_VALUE.
     - If num > Integer.MAX_VALUE / 10 OR
       (num == Integer.MAX_VALUE / 10 AND currentDigit > 8), return Integer.MIN_VALUE (for negative).
  6. Finally, return sign * num.

 Key point: We check overflow *before* multiplying and adding to avoid arithmetic overflow.
 */
public class Solution {

    public int myAtoi(String s) {
        s = s.trim();  // Step 1: remove leading and trailing spaces
        if (s.isEmpty()) return 0; // Step 2: return 0 for empty input

        int i = 0;
        int n = s.length();
        int sign = 1;
        int num = 0;

        // Step 3: handle sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 4: process digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 5: check overflow before multiplying
            if (num > Integer.MAX_VALUE / 10
                    || (num == Integer.MAX_VALUE / 10 && digit > (sign == 1 ? 7 : 8))) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        // Step 6: return result
        return sign * num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("  -123"));          // Output: -123
        System.out.println(solution.myAtoi("4193 with words")); // Output: 4193
        System.out.println(solution.myAtoi("words 987"));       // Output: 0
        System.out.println(solution.myAtoi("21474836460"));     // Output: 2147483647
        System.out.println(solution.myAtoi("-91283472332"));    // Output: -2147483648
    }
}



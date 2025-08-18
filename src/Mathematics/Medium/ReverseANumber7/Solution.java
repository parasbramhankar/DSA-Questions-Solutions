package Mathematics.Medium.ReverseANumber7;
import java.util.Scanner;


// Problem: Reverse an integer number (e.g., 123 → 321, -123 → -321)
// This is a classic problem, often asked in coding interviews (e.g., LeetCode 7).

public class Solution {

    public static int reverse(int n) {
        // 'c' will hold the reversed number as we build it step by step
        int c = 0;

        // Keep looping until n becomes 0
        // At every step, we take the last digit from 'n' and add it to 'c'
        while (n != 0) {
            // Extract the last digit (could be negative if n is negative)
            int b = n % 10;

        /*
           Check for overflow/underflow before multiplying 'c' by 10.
           Why? Because if 'c' is already too large, multiplying by 10
           and adding another digit will exceed the 32-bit integer limit.
           Integer.MAX_VALUE =  2147483647
           Integer.MIN_VALUE = -2147483648
        */
            if (c > Integer.MAX_VALUE / 10 || c < Integer.MIN_VALUE / 10) {
                return 0; // Overflow/Underflow → return 0 as per problem statement
            }

            // Build the reversed number
            c = (c * 10) + b;

            // Remove the last digit from n (Java automatically rounds towards 0)
            n = n / 10;
        }

        // Return the reversed number (negative stays negative automatically)
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();

        int reverse=reverse(n);

        System.out.println("The reverse number is:  "+reverse);
    }
}

/*
-----------------------------------
🔎 Dry Run Example: n = -123
-----------------------------------
Step 1: n = -123, b = -123 % 10 = -3, c = (0 * 10) + (-3) = -3, n = -12
Step 2: n = -12,  b = -12 % 10  = -2, c = (-3 * 10) + (-2) = -32, n = -1
Step 3: n = -1,   b = -1 % 10   = -1, c = (-32 * 10) + (-1) = -321, n = 0
Loop ends → return -321 ✅

-----------------------------------
🔎 Dry Run Example: n = 123
-----------------------------------
Step 1: n = 123, b = 123 % 10 = 3, c = (0 * 10) + 3 = 3, n = 12
Step 2: n = 12,  b = 12 % 10  = 2, c = (3 * 10) + 2 = 32, n = 1
Step 3: n = 1,   b = 1 % 10   = 1, c = (32 * 10) + 1 = 321, n = 0
Loop ends → return 321 ✅

-----------------------------------
✅ Key Points:
1. No need to "fix" the sign at the end — Java’s % and / handle negatives correctly.
2. Always check for overflow/underflow before updating 'c'.
3. Time Complexity = O(log10(n)) → proportional to the number of digits.
4. Space Complexity = O(1) → only constant extra variables used.
-----------------------------------
*/
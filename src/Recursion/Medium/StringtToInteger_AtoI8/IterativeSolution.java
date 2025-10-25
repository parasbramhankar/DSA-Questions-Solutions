package Recursion.Medium.StringtToInteger_AtoI8;

import java.util.Scanner;

/**
------------------------------------------------------------
  PROGRAM NAME: Iterative String to Integer (AtoI)
  TOPIC: String Parsing – Iterative Approach
  FILE: IterativeSolution.java
------------------------------------------------------------

PROBLEM STATEMENT:
Convert a string containing a numeric value (with optional leading spaces, '+' or '-' sign)
to its integer representation iteratively. This mimics the behavior of the C/C++ atoi() function.

------------------------------------------------------------
LOGIC AND APPROACH:

1. **Trim Spaces**
   - Remove leading and trailing spaces using s.trim().
   - If the string is empty after trimming, return 0.

2. **Initialize Variables**
   - `sign` to 1 by default.
   - `index` to 0 to start scanning characters.
   - `num` to 0 — this will accumulate the integer value.

3. **Sign Detection**
   - Check if the first character at `index` is '+' or '-'.
      - If '-', set sign = -1.
      - If '+', keep sign = 1.
   - Increment `index` if sign character found to move to the digit part.

4. **Iterate Through Characters**
   - Loop from current `index` until the end of the string.
   - For each character:
       - If it is NOT a digit, stop processing.
       - Convert the character to digit: `digit = s.charAt(index) - '0'`
       - Check for overflow before updating `num`:
         - If `num > (Integer.MAX_VALUE - digit) / 10`, means overflow would happen on multiplication/addition.
         - Return Integer.MAX_VALUE if sign = 1, else Integer.MIN_VALUE if sign = -1.
       - Update `num = num * 10 + digit`
       - Increment `index`.

5. **Return the final number**
   - Multiply `num` with `sign` to apply converted sign.
   - Return the result.

------------------------------------------------------------
DRY RUN EXAMPLE 1:
Input: "   -42"

Step 1: Trim spaces → "-42"
Step 2: index = 0, sign = 1, num = 0
Step 3: s.charAt(0) = '-', so sign = -1, index = 1
Step 4: Loop starts at index = 1
    - s.charAt(1) = '4' → digit = 4 → num = 0*10 + 4 = 4
    - s.charAt(2) = '2' → digit = 2 → num = 4*10 + 2 = 42
    - s.charAt(3) = end of string → loop stops
Step 5: return sign * num = -1 * 42 = -42

Output: -42

------------------------------------------------------------
DRY RUN EXAMPLE 2:
Input: "4193 with words"

Step 1: Trim spaces → "4193 with words"
Step 2: index = 0, sign = 1, num = 0
Step 3: s.charAt(0) = '4' (not sign), so sign = 1, index = 0
Step 4: Loop starts at index = 0
    - '4' → digit = 4 → num = 4
    - '1' → digit = 1 → num = 41
    - '9' → digit = 9 → num = 419
    - '3' → digit = 3 → num = 4193
    - ' ' (space) is NOT a digit → stop loop
Step 5: return sign * num = 1 * 4193 = 4193

Output: 4193

------------------------------------------------------------
EDGE CASES HANDLED:
- Whitespaces at start/end
- '+' and '-' signs at start
- Non-digit characters after digits (stop parsing there)
- Integer overflow (return max/min int)
- Empty or invalid string returns 0

------------------------------------------------------------
OVERALL FLOW SUMMARY:
Trim → Detect Sign → Iteration for digits and overflow check → Return final number

*/


public class IterativeSolution {

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int i = 0;
        int n = s.length();
        int sign = 1;
        int num = 0;

        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        int number = myAtoi(string);

        System.out.println("The number: " + number);
    }
}

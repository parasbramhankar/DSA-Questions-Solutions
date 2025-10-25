package Recursion.Medium.StringtToInteger_AtoI8;

import java.util.Scanner;



/**
------------------------------------------------------------
  PROGRAM NAME: Recursive String to Integer (AtoI)
  TOPIC: Recursion – Medium Level
  FILE: RecursiveSolution.java
------------------------------------------------------------

PROBLEM STATEMENT:
We need to implement a recursive version of the "String to Integer (AtoI)" function.
This function converts a numeric string (with optional '+' or '-' sign and spaces)
into an integer, behaving like the function `atoi()` in C/C++.

------------------------------------------------------------
LOGIC AND APPROACH:

1. **Trimming the Input**
   - The string may contain leading or trailing spaces.
   - We use `s.trim()` to remove them.

   Example:
   Input: "   -42"
   After trim: "-42"

2. **Handling Empty Strings**
   - If the string becomes empty after trimming, return 0 because
     there is no valid number to convert.

3. **Sign Detection**
   - Check the first character:
       - If it is '+', sign = 1
       - If it is '-', sign = -1
       - Otherwise, sign = +1 (default)
   - Move the index forward if sign character is detected.

4. **Start Recursion**
   - Call a helper function `recursionFunction()` that processes
     the string one character at a time recursively.

   Parameters passed:
   - s → input string
   - i → current index in the string
   - n → last index (for reference, though not used directly)
   - sign → either 1 or -1
   - num → current numeric value built so far

5. **Recursive Logic (recursionFunction)**
   Base case:
   - If `i` reaches the end OR current character is not a digit,
     return `sign * num`.

   Recursive case:
   - Convert current character to a digit:
        `digit = s.charAt(i) - '0'`
   - Check for integer overflow before updating:
        if (num > (Integer.MAX_VALUE - digit) / 10)
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

   - Update number:
        num = num * 10 + digit
   - Recursive call:
        recursionFunction(s, i + 1, n, sign, num)

6. **Final Result**
   - The recursion unwinds and returns the fully constructed integer
     with correct sign applied.

------------------------------------------------------------
DRY RUN EXAMPLE 1:
Input: "   -42"

Step 1: After trimming → "-42"
Step 2: sign = -1 (because of '-')
Step 3: Start recursion at index 1 (character '4')

Recursion steps:
  i = 1 → '4' → digit = 4 → num = 0*10 + 4 = 4
  i = 2 → '2' → digit = 2 → num = 4*10 + 2 = 42
  i = 3 → end of string → return sign * num = -1 * 42 = -42

Output: -42

------------------------------------------------------------
DRY RUN EXAMPLE 2:
Input: "4193 with words"

Step 1: After trimming → "4193 with words"
Step 2: sign = +1 (no sign symbol)
Step 3: recursion starts at index 0

Recursion steps:
  i = 0 → '4' → digit = 4 → num = 4
  i = 1 → '1' → digit = 1 → num = 41
  i = 2 → '9' → digit = 9 → num = 419
  i = 3 → '3' → digit = 3 → num = 4193
  i = 4 → ' ' (not a digit) → stop recursion
Return: +1 * 4193 = 4193

Output: 4193

------------------------------------------------------------
EDGE CASES HANDLED:
1. Leading and trailing spaces → handled by trim()
2. '+' or '-' sign → handled explicitly
3. Non-digit characters after number → stop recursion
4. Integer overflow → capped to Integer.MAX_VALUE or Integer.MIN_VALUE
5. Empty string → returns 0

------------------------------------------------------------
OVERALL RECURSION FLOW SUMMARY:
Input → Trim → Find sign → Recursive Digit Extraction → Overflow Check → Return Integer

FUNCTION CALL FLOW (for example "-42"):
MyAtoI("-42")
   ↓
recursionFunction("-42", 1, 2, -1, 0)
   → reads '4', updates num=4
   ↓
recursionFunction("-42", 2, 2, -1, 4)
   → reads '2', updates num=42
   ↓
recursionFunction("-42", 3, 2, -1, 42) → returns (-1 * 42)
------------------------------------------------------------
*/

public class RecursiveSolution {

    public static int MyAtoI(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int i = 0;
        int sign = 1;
        int n = s.length() - 1;
        int num = 0;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        return recursionFunction(s, i, n, sign, num);
    }

    static int recursionFunction(String s, int i, int n, int sign, int num) {
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return sign * num;
        }

        int digit = s.charAt(i) - '0';
        if (num > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return recursionFunction(s, i + 1, n, sign, ((num * 10) + digit));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        int number = MyAtoI(string);

        System.out.println("The number: " + number);
    }
}

package BitManipulation.Easy.FindXorOfLtoR;

import java.util.Scanner;
/*
XOR of Numbers from L to R — Detailed Logic and Example Dry Runs

1. Understanding the Problem:
   Find the XOR of all integers between L and R. Instead of looping from L to R, we use a mathematical trick for efficiency.

2. Key Insight — XOR Pattern:
   The XOR from 0 to N follows a repeating pattern every 4:
      If N % 4 == 0 --> N
      If N % 4 == 1 --> 1
      If N % 4 == 2 --> N + 1
      If N % 4 == 3 --> 0

3. Applying to [L, R]:
   XOR(L, R) = XOR(0, R) ^ XOR(0, L-1)
   (This works because all numbers below L cancel out!)

4. Implementation:
   - Use 'xorTillN(n)' to quickly get XOR from 0 to n.
   - Final answer is 'xorTillN(r) ^ xorTillN(l-1)'.

5. Correction:
   Be sure to use the XOR operator (^) and NOT the addition operator (+) in your code.

6. Dry Run Example 1: L = 4, R = 8
   xorTillN(8):  8 % 4 == 0 --> 8
   xorTillN(3):  3 % 4 == 3 --> 0
   Result: 8 ^ 0 = 8

7. Dry Run Example 2: L = 2, R = 5
   xorTillN(5): 5 % 4 == 1 --> 1
   xorTillN(1): 1 % 4 == 1 --> 1
   Result: 1 ^ 1 = 0

8. Notes:
   This algorithm is extremely fast and works for any input range.
   Paste this entire block at the top of your java file for reference.
*/


public class Optimize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Lower element: ");
        int l = scanner.nextInt();

        System.out.println("Enter Upper element: ");
        int r = scanner.nextInt();

        // Compute XOR from l to r using efficient formula
        int xorFromLtoR = findXORRange(l, r);

        System.out.println("The xor from " + l + " to " + r + " : " + xorFromLtoR);
    }

    // Finds XOR for numbers in the range [l, r] using prefix trick
    static int findXORRange(int l, int r) {
        // XOR from l to r is XOR(0, r) ^ XOR(0, l-1)
        return xorTillN(r) ^ xorTillN(l - 1);
    }

    // Calculates XOR of all numbers from 0 to n in O(1) time
    static int xorTillN(int n) {
        // Logic:
        // Pattern repeats every 4: check n%4 and return corresponding value
        if (n % 4 == 0) return n;       // Example: n=8 => 8
        if (n % 4 == 1) return 1;       // Example: n=9 => 1
        if (n % 4 == 2) return n + 1;   // Example: n=10 => 11
        // n % 4 == 3
        return 0;                       // Example: n=11 => 0
    }
}


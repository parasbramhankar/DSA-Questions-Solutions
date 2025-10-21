package BitManipulation.Basic.Settherightmostunsetbit;

import java.util.Scanner;

/**
 *  The function 'setBit(int n)' sets the **rightmost unset bit (0)** in the binary
 *  representation of a given integer 'n' to 1. If all bits are already set, it will set
 *  the next higher bit to 1. Let's understand the approach and logic step by step.
 *
 *  --- Approach ---
 *  1. We start with an integer 'n' whose binary representation may contain 0's and 1's.
 *     Our goal is to find the *first unset bit* (0) from the **right side** and change it to 1.
 *
 *  2. We initialize two variables:
 *     - 'ele' = 1 → used as a base mask for shifting bits.
 *     - 'ind' = 0 → keeps track of how many positions we’ve checked from the right.
 *
 *  3. The 'while(true)' loop runs indefinitely until it finds the first unset bit.
 *     Inside the loop:
 *        a. The expression `(n & (ele << ind))` checks whether the bit at position 'ind' is set or unset.
 *           - `(ele << ind)` creates a binary number with only the bit at position 'ind' as 1.
 *             For example: if ind = 2, `(1 << 2)` = 00000100 (which is 4 in decimal).
 *           - Performing bitwise AND `n & (1 << ind)` checks whether that specific bit in 'n' is set (1) or unset (0).
 *             → If result is 0, that means bit at position 'ind' is **unset**.
 *
 *        b. If the bit is unset → the condition `(n & (ele << ind)) == 0` becomes true, and the loop breaks.
 *        c. If the bit is set → increment ind and check the next bit to the left in the next iteration.
 *
 *  4. After finding the index of the rightmost unset bit, the following operation sets it:
 *        `return n | (1 << ind);`
 *     - `(1 << ind)` generates a number with a single bit 1 at the required position.
 *     - Bitwise OR (|) operation sets that bit to 1 while leaving all others unchanged.
 *
 *  --- Example Dry Run ---
 *  Suppose n = 21 → binary: 10101
 *  Bits (from right): positions → 0 1 2 3 4 (rightmost = position 0)
 *  Binary positions:
 *      4   3   2   1   0
 *      1   0   1   0   1
 *
 *  Step 1: ind = 0 → (1 << 0) = 1, (21 & 1) = 1 (bit 0 is set), continue.
 *  Step 2: ind = 1 → (1 << 1) = 2, (21 & 2) = 0 → found the first unset bit!
 *  Step 3: Set this bit: n | (1 << 1) = 21 | 2 = 23.
 *  Result: Binary(23) = 10111.
 *
 *  --- Output Explanation ---
 *  Input: 21
 *  Output: 23
 *  Because the second bit (from the right) was 0 in 21 (binary 10101).
 *  After setting it, the result becomes 10111 (which is 23).
 *
 *  --- Why This Works ---
 *  The approach systematically checks every bit from right to left. As soon as it encounters a 0,
 *  it sets that bit to 1 using the OR operation. This avoids unnecessary calculations and runs efficiently.
 *
 *  --- Time Complexity --- O(k), where k is the position of the rightmost unset bit (in worst case, up to bit-length of n).
 *  --- Space Complexity --- O(1), since no extra memory is used.
  */
public class Solution {
    static int setBit(int n) {
        int ele = 1;  // base mask for checking bits
        int ind = 0;  // index counter starts from 0 (rightmost bit)

        // Loop until we find the first unset bit
        while (true) {
            if ((n & (ele << ind)) == 0) {
                // if bit is unset (0), stop here
                break;
            }
            ind++; // move to next bit position
        }

        // Set the found unset bit to 1 and return the new number
        return (n | (1 << ind));
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int number=setBit(n);
        System.out.println("After:set the right-most unset bit: "+number);
        scanner.close();
    }
}

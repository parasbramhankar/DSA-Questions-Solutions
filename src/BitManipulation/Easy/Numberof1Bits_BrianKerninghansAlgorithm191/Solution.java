package BitManipulation.Easy.Numberof1Bits_BrianKerninghansAlgorithm191;

/**
 * Approach: Brian Kernighan’s Algorithm for Counting Set Bits (Hamming Weight)
 *  ----------------------------------------------------------------------------
 *  1️⃣ Problem Statement:
 *  The goal is to count the number of 1's (set bits) in the binary representation of a number 'n'.
 *  This count is also called the Hamming Weight or Population Count.
 *
 *  2️⃣ Algorithm Logic:
 *  The key observation is that the expression (n & (n - 1)) removes the rightmost set bit (1) in 'n'.
 *     - Example: Let's take n = 12 (binary 1100)
 *         Step 1: n - 1 = 11 (binary 1011)
 *         Step 2: n & (n - 1) = 1100 & 1011 = 1000
 *     -> One 1 is removed.
 *  Each time you perform n = n & (n - 1), one bit with value 1 is cleared.
 *  So, if you repeat this process and count the operations, you get the number of 1s.
 *
 *  3️⃣ Why it is Efficient:
 *  This runs in O(k), where k is the number of set bits in 'n', not total bits.
 *  For sparse bit representations, this is much faster than checking every bit.
 *  It also takes only O(1) extra space.
 *
 *  4️⃣ Summary:
 *  This method is known as **Brian Kernighan’s Algorithm** for counting set bits.
 *
 *  ----------------------------------------------------------------------------
 *  Dry Run Example:
 *  n = 13 (binary 1101)
 *  Step 1 → count = 0, n = 1101
 *          n & (n - 1) = 1101 & 1100 = 1100 → count = 1
 *  Step 2 → n = 1100, n & (n - 1) = 1100 & 1011 = 1000 → count = 2
 *  Step 3 → n = 1000, n & (n - 1) = 1000 & 0111 = 0000 → count = 3
 *  n becomes 0 → stop.
 *  Result = 3 (because 13 has 3 set bits).
 *  ----------------------------------------------------------------------------
*/

import java.util.Scanner;

class Solution {
    public static int hammingWeight(int n) {
        int count = 0;  // Initialize counter for set bits

        // Loop runs until all set bits are removed (n becomes 0)
        while (n > 0) {
            count++;           // Increment for each set bit found
            n = n & (n - 1);   // Removes the rightmost set bit
        }

        return count;  // Returns the total number of 1 bits in 'n'
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num=scanner.nextInt();

        System.out.println("The number of set bits : "+hammingWeight(num));

        scanner.close();
    }
}


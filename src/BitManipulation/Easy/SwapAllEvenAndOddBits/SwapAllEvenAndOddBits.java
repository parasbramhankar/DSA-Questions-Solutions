package BitManipulation.Easy.SwapAllEvenAndOddBits;

import java.util.Scanner;

/**
 * Swap Odd and Even Bits - Logic and Approach
 *
 * This code swaps every even-positioned bit with the adjacent odd-positioned bit in a 32-bit integer.
 *
 * Step-by-step explanation:
 *
 * 1. Bit Masks:
 *    - 0xAAAAAAAA (hex) has binary 1010...1010, setting bits at all even positions (starting from bit 31 as even).
 *    - 0x55555555 (hex) has binary 0101...0101, setting bits at all odd positions.
 *
 * 2. Extract Even Bits:
 *    - The expression (n & 0xAAAAAAAA) extracts bits at even positions.
 *    - These bits are then right-shifted by 1 to move them to adjacent odd positions.
 *
 * 3. Extract Odd Bits:
 *    - The expression (n & 0x55555555) extracts bits at odd positions.
 *    - These bits are then left-shifted by 1 to move them to adjacent even positions.
 *
 * 4. Combine:
 *    - OR (|) the shifted bits together to form the number with swapped bits.
 *
 * Example:
 * Input: n = 23 (binary 0001 0111)
 * - Even bits masked and shifted: moves bits at positions 30, 28, ...
 * - Odd bits masked and shifted: moves bits at positions 31, 29, ...
 * - The combined OR gives the number after swapping adjacent bits.
 *
 * Time Complexity: O(1) — constant time operations.
 * Space Complexity: O(1).
 *
 * This is a classic bit manipulation trick useful in low-level programming and interview problems.
 *
 * Current date: Thursday, October 23, 2025, 6 AM IST
 */

public class SwapAllEvenAndOddBits {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        int num=((n&0xAAAAAAAA)>>1 | (n&0x55555555)<<1);

        System.out.println("The number after Swaping even and odd bits : "+num);

    }
}

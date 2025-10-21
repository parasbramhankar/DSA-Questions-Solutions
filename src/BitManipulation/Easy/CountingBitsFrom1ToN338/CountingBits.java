package BitManipulation.Easy.CountingBitsFrom1ToN338;

import java.util.Arrays;
import java.util.Scanner;


/**
 * The function 'countBits' calculates the number of 1 bits (also known as set bits)
 *  for every integer from 0 up to n, and returns an array where each index 'i'
 *  contains the count of set bits in the binary representation of 'i'.
 *
 *  --- Approach ---
 *  1. We create an integer array 'arr' of size n + 1 to store the count of set bits for each number.
 *  2. For each number 'i' from 0 to n:
 *      a. Initialize 'count' to 0 and 'num' to i.
 *      b. Use Brian Kernighan’s algorithm to count set bits:
 *          - The expression (num & (num - 1)) removes the lowest set bit (rightmost 1) from 'num'.
 *          - Each time we perform this operation, we increment 'count' by 1.
 *          - Loop continues until 'num' becomes 0.
 *      c. Store the count in arr[i].
 *  3. Finally, return the array.
 *
 *  --- Key Idea ---
 *  The (num & (num-1)) trick works because it clears the rightmost bit set to 1.
 *  Therefore, it runs exactly as many times as there are set bits in the number.
 *
 *  --- Example Dry Run ---
 *  Suppose n = 4.
 *  We need counts for numbers 0, 1, 2, 3, 4.
 *
 *  i = 0 → binary: 0000 → set bits = 0 → arr[0] = 0
 *  i = 1 → binary: 0001 → set bits = 1 → arr[1] = 1
 *  i = 2 → binary: 0010 → set bits = 1 → arr[2] = 1
 *  i = 3 → binary: 0011 → set bits = 2 → arr[3] = 2
 *  i = 4 → binary: 0100 → set bits = 1 → arr[4] = 1
 *  Result → [0, 1, 1, 2, 1]
 *
 *  --- Output Example ---
 *  Input: n = 4
 *  Output: The number of bits in each number from 0 to 4 are [0, 1, 1, 2, 1]
 */
public class CountingBits {
    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;

            while (num > 0) {
                count++;
                num = (num & (num - 1)); // removes the rightmost 1 bit
            }

            arr[i] = count; // store the count for number i
        }

        return arr; // return array of counts
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num= scanner.nextInt();

        int []pos=countBits(num);

        System.out.println("The number of bits in each number from 0 to " +num+" are " +Arrays.toString(pos));
    }

}

package Recursion.Easy.Unique3DigitNumber3483;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Approach and Logic for totalNumbers():
 *
 * This function calculates the total number of unique 3-digit numbers
 * that can be formed using the given array of digits, with specific constraints:
 *   1. No digit is repeated within a single number; each number uses three distinct digits.
 *   2. The hundreds place (first digit) cannot be zero, so numbers like 023 are not allowed.
 *   3. The units (ones) place (last digit) must be occupied by an even digit.
 *
 * Core Steps:
 * - Uses three nested loops to choose three different digits for hundreds, tens, and units positions.
 * - Skips any combination where the hundreds digit is zero.
 * - Ensures the units digit is even for each combination.
 * - Avoids using the same digit at multiple positions by checking for unique indices.
 * - For every valid combination, forms the 3-digit number and adds it to a HashSet,
 *   which keeps only unique numbers even if input digits are repeated.
 *
 * Example:
 * - Input: digits = {2, 4, 0, 6}
 * - Valid numbers: Only those where the first digit is non-zero and the last digit is even (2, 4, 6)
 * - HashSet automatically removes duplicates if the same number can be formed in multiple ways.
 *
 * Time Complexity: O(n^3), where n is the number of input digits.
 * Space Complexity: Up to 900 unique numbers (since valid 3-digit numbers range from 100 to 999).
 */


public class IterativeSolution {

    /**
     * Computes the total count of unique 3-digit numbers that can be formed from the input array.
     *
     * @param digits input array of single-digit numbers (0-9).
     * @return total number of unique valid 3-digit numbers.
     */
    public static int totalNumbers(int[] digits) {
        // A HashSet is used to store unique 3-digit numbers and avoid duplicates.
        Set<Integer> set = new HashSet<>();
        int n = digits.length; // Number of input digits

        // Iterate through all possible choices for the hundreds place (first digit)
        for (int i = 0; i < n; i++) {
            // Skip if the current digit is zero since hundreds place can't be zero
            if (digits[i] == 0) continue;

            // Iterate through all possible choices for the tens place (second digit)
            for (int j = 0; j < n; j++) {
                // Can't use the same digit twice
                if (i == j) continue;

                // Iterate through all possible choices for the units place (third digit)
                for (int k = 0; k < n; k++) {
                    // Each digit must be unique in the number
                    if (i == k || j == k) continue;

                    // Units place must be even; skip odd digits for k
                    if (digits[k] % 2 != 0) continue;

                    // Form the number using the selected digits
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];

                    // Add the number to the set (duplicates will be ignored automatically)
                    set.add(num);
                }
            }
        }
        // The result is simply the number of unique 3-digit numbers formed
        return set.size();
    }

    /**
     * Main method to interactively take input and display result.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for number of digits
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Read n digits into the array from user input
        System.out.println("Enter " + n + " digits (0-9): ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calculate the count of unique 3-digit numbers
        int count = totalNumbers(arr);

        // Display the result
        System.out.println("Total number of unique 3-digit number: " + count);
    }
}

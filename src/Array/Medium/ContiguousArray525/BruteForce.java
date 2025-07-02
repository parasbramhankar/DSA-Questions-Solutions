package Array.Medium.ContiguousArray525;

import java.util.Arrays;

/**
 * Problem: Find the maximum length of a contiguous subarray with equal number of 0s and 1s.
 *
 * Approach: Brute Force
 * -------------------------------------
 * 1. Iterate through all possible subarrays using two nested loops.
 * 2. For each subarray, count the number of 0s and 1s.
 * 3. If counts are equal, calculate the length of the subarray and update maxLength if it's greater.
 * 4. Finally, return the maximum length found.
 *
 * Time Complexity: O(n^3)
 * - Two loops for generating subarrays (O(n^2))
 * - One inner loop for counting 0s and 1s in each subarray (O(n))
 * - So, overall complexity = O(n^3)
 *
 * Space Complexity: O(n) for temporary subarray (due to Arrays.copyOfRange)
 */

public class BruteForce {

    public static int function(int[] arr) {

        int maxLength = 0;      // To store the maximum length of a valid subarray
        int n = arr.length;

        // Iterate through all possible subarrays
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                // Optional: Create a subarray copy (not used here but was in original code)
                // int[] a = Arrays.copyOfRange(arr, i, j);

                int count0 = 0;  // Counter for 0s
                int count1 = 0;  // Counter for 1s

                // Count 0s and 1s in the current subarray
                for (int k = i; k <= j; k++) {
                    if (arr[k] == 0) {
                        count0++;
                    } else {
                        count1++;
                    }
                }

                // If equal number of 0s and 1s, update maxLength
                if (count1 == count0) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test input array
//        int[] arr = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        int[] arr = {0, 1, 0};

        // Call function and print result
        int maxLength = function(arr);
        System.out.println("Maximum length: " + maxLength);
    }
}

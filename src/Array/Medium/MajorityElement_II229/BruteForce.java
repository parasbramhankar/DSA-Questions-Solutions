/*
 * ✅ Majority Element II (LeetCode 229)
 *
 * 🔸 Problem Statement:
 * Given an integer array of size n, find **all elements** that appear more than ⌊n/3⌋ times.
 *
 * ❗ Note: There can be **at most two** elements that appear more than ⌊n/3⌋ times.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * ----------------------------------------------------------------
 *
 * ✅ Brute Force Approach:
 *
 * 1. For every element in the array:
 *    - Count its occurrences using a nested loop.
 * 2. If the count is ≥ n/3, return that element.
 *
 * 🔸 In this current implementation, the function returns **only one** majority element
 *     (the first one found that satisfies the condition).
 *
 * ----------------------------------------------------------------
 *
 * ✅ Time Complexity: O(n^2)
 *   - Outer loop runs n times
 *   - Inner loop runs n times
 *   - Total = O(n^2)
 *
 * ✅ Space Complexity: O(1)
 *   - No extra space is used
 *
 * ⚠️ Limitation:
 * - This implementation doesn't handle multiple majority elements.
 *   The correct problem requires returning **all** such elements (as a list or array).
 *
 * ----------------------------------------------------------------
 *
 * 🧠 Dry Run:
 * Input: [1, 2, 3, 1, 1]
 * n = 5
 * n / 3 = 1.66 → floor = 1
 *
 * i=0 → arr[0]=1 → compare with all → count = 3 → 3 ≥ 5/3 → return 1
 * ✅ Output: 1
 *
 * ----------------------------------------------------------------
 *
 * ✅ Fully Commented Code:
 */

package Array.Medium.MajorityElement_II229;

import java.util.Scanner;

public class BruteForce {

    // Function to return the first element that appears more than n/3 times
    static int function(int[] arr) {
        int n = arr.length;

        // Outer loop to fix each element
        for (int i = 0; i < n; i++) {
            int count = 0;

            // Inner loop to count occurrences of arr[i]
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }

                // If count reaches or exceeds n/3, return the element
                if (count >= n / 3) {
                    return arr[i];
                }
            }
        }

        // If no majority element found
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read size of array
        int n = scanner.nextInt();

        // Read array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the function and print result
        int element = function(arr);
        System.out.println("The majority element: " + element);
    }
}

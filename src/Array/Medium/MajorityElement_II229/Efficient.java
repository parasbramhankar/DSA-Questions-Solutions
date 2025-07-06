/*
 * ✅ Majority Element II (LeetCode 229)
 *
 * 🔸 Problem Statement:
 * Given an integer array of size `n`, find all elements that appear more than ⌊n/3⌋ times.
 *
 * Example 1:
 * Input: [3, 2, 3]
 * Output: [3]
 *
 * Example 2:
 * Input: [1, 1, 1, 3, 3, 2, 2, 2]
 * Output: [1, 2]
 *
 * 🔹 Note:
 * There can be **at most two** elements in the result because:
 * ⌊n/3⌋ condition means that no more than 2 elements can satisfy it in a valid array.
 *
 * ----------------------------------------------------------------
 *
 * ✅ Approach: HashMap Frequency Count
 *
 * 1. Use a HashMap to count the frequency of each element.
 * 2. Loop through the map to check which elements appear more than n/3 times.
 * 3. Return the first such element found (as per current code logic).
 *
 * 🔸 This implementation returns only one such element (the first found).
 *
 * ----------------------------------------------------------------
 *
 * ✅ Time Complexity: O(n)
 * - First loop to count frequencies: O(n)
 * - Second loop to find eligible element(s): O(n) in worst case (unique elements)
 *
 * ✅ Space Complexity: O(n)
 * - HashMap stores up to `n` keys in worst case (if all elements are unique)
 *
 * ----------------------------------------------------------------
 *
 * 🧠 Dry Run:
 * Input: [1, 1, 1, 3, 3, 2, 2, 2]
 * n = 8 → n/3 = 2.66 → floor = 2
 *
 * Frequency map:
 * 1 → 3
 * 3 → 2
 * 2 → 3
 *
 * Check map entries:
 * - 1 has count 3 → 3 > 2 → return 1 ✅
 *
 * ----------------------------------------------------------------
 *
 * ⚠️ Limitation:
 * - This implementation returns only one majority element.
 * - The correct version of the problem requires returning **all** elements that appear more than n/3 times.
 *
 * ----------------------------------------------------------------
 *
 * ✅ Fully Commented Code:
 */

package Array.Medium.MajorityElement_II229;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Efficient {

    // Function to return the first element that appears more than n/3 times
    static int function(int[] arr) {
        int n = arr.length;

        // Step 1: Count frequencies using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Step 2: Traverse the map and check which element appears > n/3 times
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > n / 3) {
                return e.getKey(); // Return the first element found
            }
        }

        // Step 3: If no such element found
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the function
        int element = function(arr);

        // Output the result
        System.out.println("The majority element: " + element);
    }
}

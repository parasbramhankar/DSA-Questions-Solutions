package Array.Medium.LongestConsecutiveSequence128;

/*
 * ✅ Longest Consecutive Sequence (LeetCode 128)
 *
 * 🔸 Problem Statement:
 * Given an unsorted array of integers, return the length of the longest sequence of consecutive elements.
 *
 * Example:
 * Input:  [100, 4, 200, 1, 3, 2]
 * Output: 4  // Because the longest consecutive sequence is [1, 2, 3, 4]
 *
 * ---------------------------------------------------------------
 *
 * ✅ Intuition & Optimized Approach (Using HashSet):
 *
 * 1. Add all elements into a HashSet to enable O(1) lookups.
 * 2. Loop through each element in the set.
 *    - If the current number is the start of a sequence (i.e., number - 1 is not in the set),
 *      then we start counting the sequence length from there.
 * 3. For each such sequence, count how many consecutive elements exist.
 * 4. Keep updating the max length found.
 *
 * 🔸 Why check (num - 1)?
 *    → It ensures we only start counting when we are at the beginning of a sequence.
 *      For example, we only start from 1 (not 2, 3, or 4) in [1, 2, 3, 4].
 *
 * ---------------------------------------------------------------
 *
 * ✅ Time Complexity: O(n)
 *    - Adding all elements to the set: O(n)
 *    - For each element, we only traverse the consecutive sequence once (not repeatedly).
 *
 * ✅ Space Complexity: O(n)
 *    - Due to usage of HashSet to store elements.
 *
 * ---------------------------------------------------------------
 *
 * 🧠 Dry Run Example:
 *
 * Input: [100, 4, 50, 1, 3, 2]
 *
 * Step 1: Convert to Set → {1, 2, 3, 4, 50, 100}
 *
 * Iterating through each element:
 * - 1 → start of a sequence → 2 → 3 → 4 → sequence length = 4
 * - 2, 3, 4 → skipped (because 1 is already the start)
 * - 50 → no 49 → start of a new sequence → length = 1
 * - 100 → no 99 → start of a new sequence → length = 1
 *
 * ✅ Maximum length = 4
 *
 * ---------------------------------------------------------------
 *
 * ✅ Fully Commented Code:
 */


import java.util.HashSet;
import java.util.Set;

public class Optimize {

    // Function to find the length of the longest consecutive sequence
    static int function(int[] arr) {

        int n = arr.length;

        // Step 1: Add all elements into a HashSet for O(1) access
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int total = 0; // Will store the length of the longest consecutive sequence

        // Step 2: Loop through each element in the set
        for (int it : set) {

            // Step 3: Only start counting if 'it' is the beginning of a sequence
            // i.e., if 'it - 1' is not in the set, then 'it' is the start
            if (!set.contains(it - 1)) {
                int x = it;      // Current number to explore the sequence
                int count = 1;   // Minimum sequence length is 1 (current number)

                // Step 4: Check for next consecutive numbers (x+1, x+2, ...)
                while (set.contains(x + 1)) {
                    count++;
                    x = x + 1; // Move to the next consecutive number
                }

                // Step 5: Update the maximum sequence length found so far
                total = Math.max(total, count);
            }
        }

        // Return the result: the length of the longest consecutive sequence
        return total;
    }

    public static void main(String[] args) {
        // Example input array
        int[] arr = new int[]{100, 4, 50, 1, 3, 2};

        // Call the function and print the result
        int count = function(arr);
        System.out.println("Total number of consecutive numbers: " + count);
    }
}

package Array.Medium.ContiguousArray525;

import java.util.HashMap;

/**
 * ✅ Optimized Approach (Prefix Sum + HashMap):
 * - Convert 0s to -1s to simplify the problem.
 * - Use prefix sum to track the net difference between 1s and 0s.
 * - Store the first index where a sum occurs in a HashMap.
 * - If the same sum appears again, the subarray in between has equal 0s and 1s.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * 🔍 Dry Run Example:
 * Input: [0, 1, 0]
 * Converted: [-1, 1, -1]
 * Prefix sums: -1, 0, -1
 * HashMap: {0:-1, -1:0}
 * Output: 2 (subarray from index 0 to 1)
 */

public class Optimize {

    // Method to find the maximum length of a contiguous subarray with equal 0s and 1s
    public int findMaxLength(int[] arr) {
        int maxLength = 0; // Stores max length of valid subarray
        int sum = 0;       // Running sum (treat 0s as -1s)

        // HashMap to store the first occurrence of a given sum
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize with sum 0 at index -1 to handle cases from beginning
        map.put(0, -1);

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {

            // Convert 0 to -1, keep 1 as 1
            sum += (arr[i] == 0) ? -1 : 1;

            // If this sum has occurred before
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                int currentLength = i - prevIndex;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Store the first time this sum occurs
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    // Main method to run and test the function
    public static void main(String[] args) {

        Optimize optimize=new Optimize();


        // Test Case 1
        int[] arr1 = {0, 1, 0};
        System.out.println("Max Length (arr1): " + optimize.findMaxLength(arr1)); // Expected: 2

        // Test Case 2
        int[] arr2 = {0, 1, 1, 0, 1, 1, 1, 0};
        System.out.println("Max Length (arr2): " + optimize.findMaxLength(arr2)); // Expected: 4

        // Test Case 3
        int[] arr3 = {0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println("Max Length (arr3): " + optimize.findMaxLength(arr3)); // Expected: 6

        // Test Case 4 - All 0s or 1s
        int[] arr4 = {1, 1, 1, 1};
        System.out.println("Max Length (arr4): " + optimize.findMaxLength(arr4)); // Expected: 0
    }
}



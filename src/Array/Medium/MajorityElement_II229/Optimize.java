package Array.Medium.MajorityElement_II229;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ✅ Problem: Majority Element II (LeetCode 229)
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * You may return the answer in any order.
 *
 * 💡 Example:
 * Input: nums = [3,2,3]
 * Output: [3]
 *
 * 🔍 Observation:
 * - There can be at most two elements that appear more than n/3 times.
 * - Reason: If there are three such elements, their minimum total frequency would be > n (impossible).
 *
 * 💡 Approach (Moore's Voting Algorithm Extended for n/3):
 * Step 1️⃣: Use two counters and two candidate variables (because max 2 elements are possible).
 * Step 2️⃣: First pass – find candidates.
 * Step 3️⃣: Second pass – verify their actual frequencies.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding an output list)
 */

public class Optimize {

    /**
     * This function finds all elements that appear more than n/3 times in the given array.
     *
     * @param nums Input integer array
     * @return List of elements appearing more than n/3 times
     */
    static List<Integer> function(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // Step 1: Initialize candidates and their counters
        int count1 = 0, cand1 = 0;
        int count2 = 0, cand2 = 0;
        int n = nums.length;

        // Step 2: First pass - Find potential candidates using modified Moore's Voting
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != cand2) {
                count1 = 1;
                cand1 = nums[i];
            } else if (count2 == 0 && nums[i] != cand1) {
                count2 = 1;
                cand2 = nums[i];
            } else if (nums[i] == cand1) {
                count1++;
            } else if (nums[i] == cand2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 3: Second pass - Validate actual count of the candidates
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == cand1) {
                count1++;
            } else if (nums[i] == cand2) {
                count2++;
            }
        }

        // Step 4: Check if candidates appear more than n/3 times
        if (count1 > n / 3) {
            list.add(cand1);
        }
        if (count2 > n / 3) {
            list.add(cand2);
        }

        return list;
    }

    /**
     * 🔁 Sample Dry Run:
     * Input: [3, 2, 3]
     * n = 3, so n / 3 = 1
     * First pass:
     *   - cand1 = 3, count1 = 2
     *   - cand2 = 2, count2 = 1
     * Second pass:
     *   - count1 = 2 → > 1 ✅
     *   - count2 = 1 → not > 1 ❌
     * Output: [3]
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 👉 Input array size
        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // 👉 Input array elements
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 👉 Output result
        List<Integer> result = function(arr);
        System.out.println("The majority element(s) appearing more than n/3 times: " + result);

        scanner.close();
    }
}

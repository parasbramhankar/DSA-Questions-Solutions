package Array.Medium.Four4Sum18;

/**
 🔍 Logic & Approach (Step-by-Step)

1️⃣ Goal

Find all unique quadruplets (four numbers) in the array that add up exactly to the `target`.

This is a natural extension of the 2 Sum (hashing / two pointer), and 3 Sum (two pointer inside a loop) problem.

For 4 Sum, we use two nested loops to fix the first two numbers, and then solve a 2 Sum problem on the remaining part of the array.

2️⃣ Sorting the array

We first `Arrays.sort(nums)`.
  * Sorting helps in two key ways:
  * It allows us to use the two pointer technique effectively for the remaining two numbers.
  * It makes it easy to skip duplicates, ensuring unique quadruplets.
---

3️⃣ Loop for first two numbers

We loop:
  * `i` from `0` to `n-3` (first number)
  * `j` from `i+1` to `n-2` (second number)

For each `(i, j)` pair, we look for two more numbers whose sum is `target - (nums[i] + nums[j])`.
---
4️⃣ Two pointer approach for remaining two numbers

   * Initialize two pointers:

   * `left = j + 1`
   * `right = n - 1`

We move `left` and `right` inward based on their sum until `left < right`.

---

5️⃣ Handling duplicates

   * After fixing `i`, we skip duplicates:
      `if (i > 0 && nums[i] == nums[i-1]) continue;`
   * Similarly for `j`:
      `if (j > i+1 && nums[j] == nums[j-1]) continue;`
   * Also after finding a quadruplet, skip duplicates for `left` and `right`:

     * `while (left < right && nums[left] == nums[left+1]) left++;`
     * `while (left < right && nums[right] == nums[right-1]) right--;`
---

6️⃣ Avoid integer overflow

    * The sum could exceed `Integer.MAX_VALUE`, so we use:

 long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
  ```
 ✅ Time Complexity

    * Outer loops: O(n²)
    * Inner while loop: O(n) for each (i, j) pair.
So roughly O(n³) overall.


 */

import java.util.*;

public class Optimize {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);  // Sort to use two pointers and easily skip duplicates
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // First loop to fix the first number
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Second loop to fix the second number
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate elements for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Now use two pointers to find the remaining two numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Use long to prevent overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++; // Need a bigger sum
                    } else if (sum > target) {
                        right--; // Need a smaller sum
                    } else {
                        // Found a quadruplet
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for left pointer
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for right pointer
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // Move both pointers inward to look for new pairs
                        left++;
                        right--;
                    }
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;  // this value can be anything

        List<List<Integer>> result =fourSum(nums, target);

        System.out.println("Quadruplets that sum to " + target + ":");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }
}




/*
✅ Short summary:

    ==========================================================
    🚀 Problem:
    Given an array nums and a target, find all unique quadruplets (4 numbers)
    that sum up to the target.

    ==========================================================
    ✅ Approach:
    1. Sort the array.
    2. Use two nested loops to fix the first two numbers (i, j).
    3. Then use two pointers (left, right) to find the remaining two numbers
       such that the total sum equals the target.

    4. Skip duplicates at every stage to ensure unique quadruplets.

    ==========================================================
    🔍 Example Dry Run
    Input: nums = [1, 0, -1, 0, -2, 2], target = 0

    After sorting:
    nums = [-2, -1, 0, 0, 1, 2]

    Loop i=0 (nums[i]=-2)
      Loop j=1 (nums[j]=-1)
        left=2, right=5
          sum=-2-1+0+2=-1 <0 → left++
        left=3
          sum=-2-1+0+2=-1 <0 → left++
        left=4
          sum=-2-1+1+2=0 ✅ Add [-2,-1,1,2]
        left=5, right=4 (done)

      Loop j=2 (nums[j]=0)
        left=3, right=5
          sum=-2+0+0+2=0 ✅ Add [-2,0,0,2]
        left=4, right=4 (done)

    Loop i=1 (nums[i]=-1)
      Loop j=2 (nums[j]=0)
        left=3, right=5
          sum=-1+0+0+2=1 >0 → right--
        right=4
          sum=-1+0+0+1=0 ✅ Add [-1,0,0,1]
        left=4, right=3 (done)

    ✅ Final result:
    [[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]

    ==========================================================
    🎯 Pointer movement diagram

    Case i=0, j=1
    [-2, -1, 0, 0, 1, 2]
          i   j  l      r

    ➔ left moves right, right moves left based on sum
    ➔ collect quadruplets when sum == target
    ➔ skip duplicates

    ==========================================================

*/



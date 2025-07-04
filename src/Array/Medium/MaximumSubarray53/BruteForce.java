package Array.Medium.MaximumSubarray53;
/*
=====================================================================================
Explanation of Logic and Approach
=====================================================================================

Problem:
---------
Given an integer array 'nums', find the contiguous subarray with the largest sum
and return its sum.

This approach uses a **brute-force nested loop**, optimized slightly by an early
break when the sum becomes negative.

Logic & Approach:
-----------------
1. Outer loop picks the starting index 'i' of subarray.
2. Inner loop extends the subarray to index 'j', adding nums[j] to 'sum'.
3. After each addition:
   - If 'sum' > 'maxSum', update 'maxSum'.
   - If 'sum' becomes negative, we break early from the inner loop,
     because extending it further will only decrease the sum.

This avoids some unnecessary checks compared to checking all (i, j) pairs blindly.

Time Complexity: O(n^2) — due to the nested loops.
Space Complexity: O(1) — uses only fixed extra variables.

=====================================================================================
*/


public class BruteForce {
    /**
     * Finds the maximum sum of a contiguous subarray using a brute-force approach.
     *
     * @param nums the input array of integers
     * @return the largest sum of any contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Initialize to lowest integer
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];         // Extend subarray to index j

                if (sum > maxSum) {
                    maxSum = sum;       // Update maxSum if needed
                }

                if (sum < 0) {
                    break;              // Early exit: no benefit extending further if sum is negative
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = bruteForce.maxSubArray(nums);

        System.out.println("Maximum subarray sum (Brute Force) is: " + maxSum);
    }


}

/*
=====================================================================================
Step-by-Step Dry Run
=====================================================================================

Example Input:
--------------
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Tracking:
---------
- maxSum : stores maximum sum found
- sum    : current sum for subarray starting at i

Loop by i (start index):

------------------------------------------------
i = 0
  j=0: sum = -2 -> maxSum=-2 -> sum<0 => break

------------------------------------------------
i = 1
  j=1: sum = 1  -> maxSum=1
  j=2: sum = -2 -> sum<0 => break

------------------------------------------------
i = 2
  j=2: sum = -3 -> sum<0 => break

------------------------------------------------
i = 3
  j=3: sum = 4  -> maxSum=4
  j=4: sum = 3
  j=5: sum = 5  -> maxSum=5
  j=6: sum = 6  -> maxSum=6
  j=7: sum = 1
  j=8: sum = 5

------------------------------------------------
i = 4
  j=4: sum = -1 -> sum<0 => break

------------------------------------------------
i = 5
  j=5: sum = 2
  j=6: sum = 3
  j=7: sum = -2 -> sum<0 => break

------------------------------------------------
i = 6
  j=6: sum = 1
  j=7: sum = -4 -> sum<0 => break

------------------------------------------------
i = 7
  j=7: sum = -5 -> sum<0 => break

------------------------------------------------
i = 8
  j=8: sum = 4

Result:
-------
Maximum subarray sum = 6 (from subarray [4, -1, 2, 1])

=====================================================================================
*/



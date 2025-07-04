package Array.Medium.MaximumSubarray53;

/*
=====================================================================================
Explanation of Logic and Approach
=====================================================================================

Problem:
---------
Given an integer array 'nums', we want to find the contiguous subarray
(with at least one number) which has the largest sum and return its sum.

This is a classic problem solved efficiently using Kadane’s Algorithm.

Logic & Approach:
-----------------
1. We initialize two variables:
   - 'maxSum' : stores the maximum sum found so far.
   - 'sum'    : stores the current subarray sum as we iterate.

2. As we traverse the array from left to right:
   a) We add the current element 'nums[i]' to 'sum'.
   b) If 'sum' is greater than 'maxSum', we update 'maxSum'.
   c) If 'sum' becomes negative, we reset 'sum' to 0.
      Why? Because any future subarray starting from here would be better off
      starting fresh, as adding a negative 'sum' would only decrease total.

3. Finally, 'maxSum' contains the largest subarray sum.

Time Complexity: O(n) — single pass through array.
Space Complexity: O(1) — uses only fixed extra variables.

=====================================================================================
*/


public class Optimize {
    /**
     * Finds the maximum sum of a contiguous subarray using Kadane's Algorithm.
     *
     * @param nums the input array of integers
     * @return the largest sum of any contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Initialize to the lowest possible integer
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];             // Add current element to the running sum

            if (sum > maxSum) {
                maxSum = sum;           // Update maxSum if current sum is greater
            }

            if (sum < 0) {
                sum = 0;                // Reset sum if it becomes negative
            }
        }

        return maxSum;
    }


    public static void main(String[] args) {
        Optimize solution = new Optimize();

        // Example input array
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Call the maxSubArray method and print the result
        int maxSum = solution.maxSubArray(nums);

        System.out.println("Maximum subarray sum is: " + maxSum);
    }


}


/*
=====================================================================================
Step-by-Step Dry Run
=====================================================================================

Example Input:
--------------
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

We track two variables:
 - sum   : current subarray sum
 - maxSum: maximum subarray sum found so far

-------------------------------------------------------------------------------------
| i | nums[i] | sum before | sum after | maxSum before | maxSum after | Action     |
-------------------------------------------------------------------------------------
| 0 |   -2    |     0      |    -2     |   -2147483648 |     -2       | update max |
|   |         |            |           |               |              | sum < 0 => reset sum to 0 |
-------------------------------------------------------------------------------------
| 1 |    1    |     0      |     1     |      -2       |      1       | update max |
-------------------------------------------------------------------------------------
| 2 |   -3    |     1      |    -2     |       1       |      1       | sum < 0 => reset sum to 0 |
-------------------------------------------------------------------------------------
| 3 |    4    |     0      |     4     |       1       |      4       | update max |
-------------------------------------------------------------------------------------
| 4 |   -1    |     4      |     3     |       4       |      4       |           |
-------------------------------------------------------------------------------------
| 5 |    2    |     3      |     5     |       4       |      5       | update max |
-------------------------------------------------------------------------------------
| 6 |    1    |     5      |     6     |       5       |      6       | update max |
-------------------------------------------------------------------------------------
| 7 |   -5    |     6      |     1     |       6       |      6       |           |
-------------------------------------------------------------------------------------
| 8 |    4    |     1      |     5     |       6       |      6       |           |
-------------------------------------------------------------------------------------

Result:
-------
Maximum subarray sum = 6
(which comes from subarray [4, -1, 2, 1])

=====================================================================================
*/


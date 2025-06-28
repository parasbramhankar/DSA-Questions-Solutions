package Array.Medium.Three3Sum15;
/*

✅ Optimized Approach: Two Pointers + Sorting

🔸Step-by-Step Logic:

1. Sort the array – to make it easy to avoid duplicates and apply two-pointer.
2. Loop through each element `nums[i]`:
    a. If it's the same as the previous number, skip it to avoid duplicates.
3. For each `i`, use two pointers:
   a. `j = i + 1` (start)
   b. `k = n - 1` (end)
4. While `j < k`:
   a. Calculate the sum: `nums[i] + nums[j] + nums[k]`
   b If the sum is `0`, store the triplet.
     a.a. Then skip duplicate elements on both sides (`j`, `k`)
   c. If sum is `< 0`, move `j` right.
   d. If sum is `> 0`, move `k` left.

✅ Example Walkthrough:

Input:

nums = [-1, 0, 1, 2, -1, -4]


Step 1: Sort the array
[-4, -1, -1, 0, 1, 2]


Step 2: Start looping

A. `i = 0`: `nums[i] = -4`, `j = 1`, `k = 5`
  * `sum = -4 + (-1) + 2 = -3` → move `j` to right
  * `sum = -4 + 0 + 2 = -2` → move `j`
  * ... (no triplet found)

B. `i = 1`: `nums[i] = -1`, `j = 2`, `k = 5`
  * `sum = -1 + -1 + 2 = 0` → ✅ triplet `[-1, -1, 2]`
  * Skip duplicates, move `j = 3`, `k = 4`
  * `sum = -1 + 0 + 1 = 0` → ✅ triplet `[-1, 0, 1]`

C. `i = 2`: skip duplicate `-1`

D. `i = 3`: `nums[i] = 0`, `j = 4`, `k = 5`

  * `sum = 0 + 1 + 2 = 3` → too big, move `k`

Final triplets:
[[-1, -1, 2], [-1, 0, 1]]
---

 ✅ Time & Space Complexity:

| Operation          | Complexity                                |
| ------------------ | ----------------------------------------- |
| Sorting            | O(n log n)                                |
| Two-pointers per i | O(n)                                      |
| Overall            | O(n²)                                     |
| Space (output)     | O(k) → where k = number of valid triplets |
 */
import java.util.*;

public class Optimize {

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        // Step 1: Sort the array to help with skipping duplicates and two-pointer logic
        Arrays.sort(nums);

        // This will hold the result triplets
        List<List<Integer>> triplets = new ArrayList<>();

        // Step 2: Loop through each element (as the first element of the triplet)
        for (int i = 0; i < n - 2; i++) {

            // Step 2a: Skip duplicates for i (e.g., avoid checking [-1,0,1] and [-1,0,1] again)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // move to next i
            }

            // Step 3: Set up two pointers
            int j = i + 1;
            int k = n - 1;

            // Step 4: Use two pointers to find two numbers that sum to -nums[i]
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    // We need a smaller number → move right pointer left
                    k--;
                } else if (sum < 0) {
                    // We need a larger number → move a left pointer right
                    j++;
                } else {
                    // Found a valid triplet
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Move both pointers
                    j++;
                    k--;

                    // Step 5: Skip duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // Step 6: Skip duplicates for k
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        // Step 7: Return the list of triplets
        return triplets;
    }


    public static void main(String[] args) {
        int[]arr=new int[]{-1,0,1,2,-1,-4};
//        int[]arr=new int[]{0,1,1};
//        int[] arr = new int[]{0, 0, 0};

        System.out.println("Triplets: " + threeSum(arr));
    }

}

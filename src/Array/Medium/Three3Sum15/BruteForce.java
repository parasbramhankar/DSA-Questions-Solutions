package Array.Medium.Three3Sum15;
/*
✅ Brute Force Approach:

Logic:

1. We use 3 nested loops to pick every possible combination of 3 elements.
2. For each combination, check if their sum is zero.
3. To avoid duplicate triplets:
   * Sort each triplet before adding to a set.
   * Use a `Set<List<Integer>>` to automatically remove duplicates.
4. At the end, convert the set to a list and return.

🧠 Example:

For input:
nums = [-1, 0, 1, 2, -1, -4]

Output:
[[-1, -1, 2], [-1, 0, 1]]

---
⏱ Time & Space Complexity:

| Aspect | Value                                                                                 |
| ------ | ------------------------------------------------------------------------------------- |
| Time   | O(n³) → 3 nested loops                                                                |
| Space  | O(k) → for storing unique triplets in the set (where `k` is number of valid triplets) |

*/

import java.util.*;

public class BruteForce {

    public static List<List<Integer>> threeSum(int[] nums) {

        // Using a set to store unique triplets
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        // Loop 1: pick first number
        for (int i = 0; i < n - 2; i++) {

            // Loop 2: pick second number
            for (int j = i + 1; j < n - 1; j++) {

                // Loop 3: pick third number
                for (int k = j + 1; k < n; k++) {

                    // Check if the sum of the triplet is zero
                    if (nums[i] + nums[j] + nums[k] == 0) {

                        // Create a triplet
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);

                        // Sort to handle duplicate values like [-1,0,1] and [0,-1,1]
                        Collections.sort(triplet);

                        // Add to set (only unique combinations will be added)
                        set.add(triplet);
                    }
                }
            }
        }

        // Convert the set to a list and return
        return new ArrayList<>(set);
    }


    public static void main(String[] args) {
//        int[]arr=new int[]{-1,0,1,2,-1,-4};
//        int[]arr=new int[]{0,1,1};
        int[] arr = new int[]{0, 0, 0};

        System.out.println("Triplets: " + threeSum(arr));
    }


}

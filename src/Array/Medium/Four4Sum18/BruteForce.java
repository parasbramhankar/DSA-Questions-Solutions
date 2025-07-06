package Array.Medium.Four4Sum18;

import java.util.*;

public class BruteForce {

    /*
    ==============================================================
    🚀 Brute Force Solution for Four Sum
    ==============================================================
    Idea:
    - Try every combination of 4 indices (i, j, k, l) using four nested loops.
    - If nums[i] + nums[j] + nums[k] + nums[l] == target, add to result.
    - Use a HashSet to automatically handle duplicates.

    Time Complexity:
    - O(n^4) since we have four nested loops.

    ==============================================================
    */

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        // Sort first to help with duplicate quadruplets
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                        if (sum == target) {
                            // Put in sorted order due to sorted nums, automatically unique
                            set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        // Convert set to list
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result = fourSum(nums, target);

        System.out.println("Quadruplets that sum to " + target + ":");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }
}

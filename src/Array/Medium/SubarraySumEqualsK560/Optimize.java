package Array.Medium.SubarraySumEqualsK560;

import java.util.HashMap;
import java.util.Scanner;

public class Optimize {

    /*
        Problem: Subarray Sum Equals K
        -----------------------------------
        Given an array of integers (nums[]) and an integer k,
        we need to count how many subarrays have a sum equal to k.

        Example:
        nums = [1, 2, 3], k = 3
        Subarrays with sum = 3 are:
            [1,2], [3]
        Answer = 2
     */

    public static int subarraySum(int[] nums, int k) {
        // 'sum' will store the running prefix sum
        int sum = 0;

        // 'ans' stores how many subarrays we found
        int ans = 0;

        // HashMap to store prefixSum and its frequency
        // Key = prefix sum, Value = how many times it has appeared
        HashMap<Integer, Integer> map = new HashMap<>();

        // Important: put (0,1) because before starting,
        // we assume prefix sum = 0 has appeared once.
        // This helps when subarray itself equals k.
        map.put(0, 1);

        // Step 1: Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // Keep adding current element to prefix sum
            sum += nums[i];

            // Step 2: Check if (sum - k) exists in map
            // Why? Because if sum - k was seen before,
            // then a subarray from that index+1 to current index has sum = k
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k); // Add how many times it was seen
            }

            // Step 3: Store current sum in map (increase its frequency)
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans; // Total subarrays with sum = k
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.println("Enter size of array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input k
        System.out.println("Enter the value of k: ");
        int k = scanner.nextInt();

        // Function call
        int ans = subarraySum(arr, k);

        // Print result
        System.out.println("The total number of subarrays whose sum equals k: " + ans);

        scanner.close();
    }
}

/*
    Step-by-Step Approach (Beginner Friendly):

    1. Prefix Sum Concept
       - Instead of checking every subarray (which is slow), we use prefix sums.
       - Prefix sum at index i = sum of elements from 0 to i.

    2. Use a HashMap
       - Map stores: prefixSum -> frequency.
       - Helps us quickly find if we’ve seen (sum - k) before.

    3. Logic
       - While going through array, keep track of running sum.
       - If (sum - k) exists in map, then a subarray ending here has sum = k.
       - Add that frequency to answer.
       - Update the map with current sum.

    4. Initial Case (map.put(0,1))
       - Needed so that subarray starting from index 0 is also counted.


    Dry Run Example:

    Input:
    nums = [1, 2, 3], k = 3

    Start: sum = 0, map = {0=1}, ans = 0

    i=0 → sum=1
    sum-k = -2 (not in map)
    map = {0=1, 1=1}

    i=1 → sum=3
    sum-k = 0 → found! map[0]=1 → ans=1
    map = {0=1, 1=1, 3=1}

    i=2 → sum=6
    sum-k = 3 → found! map[3]=1 → ans=2
    map = {0=1, 1=1, 3=1, 6=1}

    Final Answer = 2
*/

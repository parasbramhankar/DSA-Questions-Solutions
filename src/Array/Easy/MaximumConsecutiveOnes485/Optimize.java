package Array.Easy.MaximumConsecutiveOnes485;
/*
✅ Approach – Maximum Consecutive 1s (Optimized)

The goal of this function is to find the maximum number of consecutive 1s in
a binary array (i.e., an array that contains only `0`s and `1`s).

Core Idea:

1. As we traverse the array, we track how many 1s are occurring consecutively.
2. When we encounter a `0`, we:
  * Check if the current streak (`count`) is the longest so far.
  * Reset `count` to `0` because the sequence of `1s` has been interrupted.
3 At the end, we ensure that if the array ends with a streak of `1s`, it's also considered for the maximum.

🔹Step-by-Step Logic:

1. Initialize two variables:
   * `count` → Keeps track of the current number of consecutive 1s.
   * `maxCount` → Stores the maximum number of consecutive 1s found so far.
2. Iterate through each element of the array:
   a. If the element is `1`, increment `count`.
   B. If the element is `0`, it means the streak is broken:
     * Compare `count` with `maxCount` and update `maxCount` if needed.
     * Reset `count` to `0`.
3. After the loop ends:
   * The array may end with `1s`, and we haven’t updated `maxCount` after the last streak.
   * So, we take `Math.max(maxCount, count)` to return the final answer.
----------

Time and Space Complexity:

Time Complexity: `O(n)` — we traverse the array once.
Space Complexity: `O(1)` — only two integer variables are used.
----------

🔹 Example:

Input: `[1, 1, 0, 1, 1, 1]`
Output: `3`
Explanation:

* First streak: `1, 1` → length = 2
* Break at `0`
* Second streak: `1, 1, 1` → length = 3 (max)

-------
# ✅ Use Case Summary:

| Element | Action      | `count` | `maxCount` |
| ------- | ----------- | ------- | ---------- |
| `1`     | `+1`        | 1       | 0          |
| `1`     | `+1`        | 2       | 0          |
| `0`     | reset       | 0       | 2          |
| `1`     | `+1`        | 1       | 2          |
| `1`     | `+1`        | 2       | 2          |
| `1`     | `+1`        | 3       | 2          |
| (end)   | final check | -       | 3          |

 */

import java.util.Scanner;

public class Optimize {

    // Function to find the maximum number of consecutive 1s in a binary array (Optimized approach)
    static int maxCountOnes(int[] arr) {
        int maxCount = 0;  // This variable stores the maximum streak of 1s found so far
        int count = 0;     // This variable counts the current streak of 1s

        int n = arr.length;

        // Traverse the array from beginning to end
        for (int i = 0; i < n; i++) {

            if (arr[i] == 1) {
                // If the current element is 1, increase the current streak count
                count++;
            } else {
                // If a 0 is found, update maxCount with the longest streak so far
                maxCount = Math.max(maxCount, count);

                // Reset current streak count to 0
                count = 0;
            }
        }

        // After the loop, we do one final comparison in case the array ended with 1s
        // This ensures we don't miss the last streak if it was the longest
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int count=new Optimize().maxCountOnes(arr);

        System.out.println("Maximum count of 1's: "+count);
    }
}

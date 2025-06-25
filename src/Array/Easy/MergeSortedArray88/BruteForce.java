package Array.Easy.MergeSortedArray88;
/*
 ✅💡 Logic & Approach (Brute Force)

Step-by-step explanation:
1. Copy all elements of `nums2` into the empty positions
   at the end of `nums1` (i.e., from index `m` to `m + n - 1`).
2. Now `nums1` contains all the values from both arrays (but unsorted).

3. Simply sort `nums1` using `Arrays.sort(nums1)` to get the final sorted array.

🧠 Dry Run

Let's dry run this input:

📍 Step 1: Copy `nums2` into `nums1` from index `m`

Start with:

nums1 = [1, 2, 3, 0, 0, 0]

After copying elements from `nums2`:

nums1[3] = 2
nums1[4] = 5
nums1[5] = 6

Now `nums1 = [1, 2, 3, 2, 5, 6]`

📍Step 2: Sort the array
Arrays.sort(nums1)

Sorted array becomes:
[1, 2, 2, 3, 5, 6]

✅Time and Space Complexity

| Operation     |         Time           |               Space                 |
| ------------- | ---------------------- | ----------------------------------- |
| Copy elements | O(n)                   | O(1)                                |
| Sort array    | O((m + n) log (m + n)) | O(1) (in-place sort for primitives) |

 */


import java.util.Arrays;

public class BruteForce {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Copy elements of nums2 into the extra space of nums1
        for (int num : nums2) {
            nums1[m++] = num;
        }

        // Now sort the whole nums1 array
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        // Call merge function
        merge(nums1, m, nums2, n);

        // Print result
        System.out.print("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}

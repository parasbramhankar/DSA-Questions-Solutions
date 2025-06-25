package Array.Easy.MergeSortedArray88;
/*
✅ Approach & Intuition

Problem occurs: If we merge from the start, we risk overwriting values in nums1 before using them.

➡️ So instead, we merge from the end (right to left):

1. Use 3 pointers:
       * `i = m - 1` → Last meaningful element in `nums1`
       * `j = n - 1` → Last element in `nums2`
       * `k = m + n - 1` → Last index in `nums1`

👉 At each step:
       * Compare `nums1[i]` and `nums2[j]`
       * Place the larger one at index `k`, then move pointers accordingly.
       * Maintain the pointers k--,j--,i-- accordingly

📌 Once `nums1` is exhausted, just copy the remaining elements of `nums2` into `nums1`.


✅ 4. Dry Run on Example

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Initial:
```
i = 2 (points to 3)<--(pointer of nums1)
j = 2 (points to 6)<--(pointer of nums2)
k = 5 (points to last index in nums1)
```
Step-by-step:
|   i   |    j      |   k   |   nums1 (during merge)  |             Action                 |
|-------|-----------|-------|-------------------------| ---------------------------------- |
|   2   |    2      |   5   |   [1,2,3,0,0,*6*]       | 6 > 3 → copy nums2[2] to nums1[5]  |
|   2   |    1      |   4   |   [1,2,3,0,*5*,6]       | 5 > 3 → copy nums2[1] to nums1[4]  |
|   2   |    0      |   3   |   [1,2,3,*3*,5,6]       | 3 >= 2 → copy nums1[2] to nums1[3] |
|   1   |    0      |   2   |   [1,2,*2*,3,5,6]       | 2 == 2 → copy nums2[0] to nums1[2] |
|   1   |   -1      |   1   |   [1,*2*,2,3,5,6]       | j < 0, done                        |

Final Output:
[1, 2, 2, 3, 5, 6]

As expected!
---
✅ Time and Space Complexity

Time: `O(m + n)` — Every element is visited once.
Space: `O(1)` — No extra space used, in-place merge.

 */
public class Optimize {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;            // pointer for nums1 (end of valid elements)
            int j = n - 1;            // pointer for nums2 (end of elements)
            int k = m + n - 1;        // pointer for placement in nums1

            // Start merging from the end
            while (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            }

            // Copy remaining elements of nums2 if any
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
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

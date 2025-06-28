package Array.Medium.FindMinimuminRotatedSortedArray153;

import java.util.Arrays;

/*
✅ Approach: Binary Search (Optimized)

### 🔍 Logic

* A rotated sorted array always has two sorted subarrays.
    * The minimum element is the only element which is smaller than its previous element (or the rotation point).
    * Instead of scanning the whole array, use binary search to find that minimum efficiently.

✅ Time and Space Complexity

| Type             | Complexity                   |
| ---------------- | ---------------------------- |
| Time Complexity  | O(log n) – Binary search |
| Space Complexity | O(1) – No extra space    |
---

✅ How This Works (Quick Trace)

Given: `[4, 5, 6, 7, 0, 1, 2]`
* `left = 0, right = 6`
* mid = 3 → `arr[3] = 7`, which is > arr\[6] = 2` ⇒ minimum is on right side → left = 4
* `left = 4, right = 6`
* mid = 5 → `arr[5] = 1` which is <= arr\[6] = 2` ⇒ right = 5
* mid = 4 → `arr[4] = 0` which is <= `arr[5] = 1` ⇒ right = 4
* Now `left == right == 4` → `arr[4] = 0` is the minimum

---

✅ Summary

| Approach    | Time     | Space | Notes                             |
| ----------- | -------- | ----- | --------------------------------  |
| Brute-force | O(n)     | O(1)  | Scans all elements                |
| Optimized   | O(log n) | O(1)  | Uses binary search — preferred ✅ |

*/



public class Optimize {

    // Function to find the minimum element using binary search
    static int minimumElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Continue while the search space is greater than 1 element
        while (left < right) {
            int mid = left + (right - left) / 2;  // Avoids integer overflow

            // If mid element is less than or equal to right element,
            // then the minimum must be at mid or to the left
            if (arr[mid] <= arr[right]) {
                right = mid;
            }
            // If mid element is greater than right element,
            // then the minimum must be to the right of mid
            else {
                left = mid + 1;
            }
        }

        // After loop ends, left == right, which points to the minimum element
        return arr[left];
    }

    public static void main(String[] args) {
        // Example rotated sorted array
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};

        // Call the function and print the result
        System.out.println("Minimum element: " + minimumElement(arr));
    }
}


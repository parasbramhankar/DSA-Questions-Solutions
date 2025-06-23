package Array.Easy.ReplaceElementsWithGreatestElementatRight1299;
/*
Approach:
1. Traverse the array from right to left.
2. Keep a variable maxRight to store the maximum seen so far.
3 .For each element, replace it with maxRight, then update maxRight
to be the maximum of current element and maxRight.

Time Complexity: O(n)
Space Complexity: O(1)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Optimize {
   static public int[] replaceElementsOptimized(int[] arr) {
        int n = arr.length;
        int maxRight = -1; // No element to the right of the last one

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];    // Store current element temporarily
            arr[i] = maxRight;       // Replace it with the max from the right
            maxRight = Math.max(maxRight, current); // Update maxRight
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = replaceElementsOptimized(arr);

        System.out.println("Result using Optimized Approach: " + Arrays.toString(result));
    }


}

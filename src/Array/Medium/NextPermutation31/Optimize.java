package Array.Medium.NextPermutation31;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Beginner-friendly explanation of Next Permutation.
 * --------------------------------------------------
 * Goal: Rearrange the array into the next lexicographic (dictionary order) permutation.
 * If no such arrangement exists (array is the last permutation), rearrange it to the first (ascending order).
 *
 * Steps (easy language):
 *
 * Step 1: Find the break-point
 *   - Start from the right side of the array.
 *   - Find the first index i where arr[i] < arr[i+1].
 *   - This index is the "break-point".
 *   Example: [2, 1, 5, 4, 3, 0, 0]
 *   Break-point is index 1 because arr[1] = 1 < arr[2] = 5.
 *
 *   If no such index is found → array is descending (like [5,4,3,2,1]).
 *   In that case, reverse the whole array to make it ascending → [1,2,3,4,5].
 *
 * Step 2: Find the next bigger number (successor)
 *   - If we found a break-point:
 *   - From the right side, find the first number greater than arr[i].
 *   - Swap it with arr[i].
 *   Example: [2, 1, 5, 4, 3, 0, 0]
 *   Break-point arr[1] = 1, the first bigger number from right is 3.
 *   Swap → [2, 3, 5, 4, 1, 0, 0].
 *
 * Step 3: Reverse the right side
 *   - After swapping, reverse the part of the array after the break-point.
 *   - This makes the sequence the smallest possible after the pivot.
 *   Example: [2, 3, 5, 4, 1, 0, 0]
 *   Reverse from index 2 onwards → [2, 3, 0, 0, 1, 4, 5].
 *
 * Final: That is the next permutation.
 */
public class Optimize {

    public static void function(int[] arr) {
        int n = arr.length;
        int pivot = -1;

        // Step 1: find the break-point from right side
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no break-point → array is descending → reverse whole array
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: find the successor (smallest number bigger than arr[pivot])
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                // swap pivot and successor
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }

        // Step 3: reverse the part after pivot
        reverse(arr, pivot + 1, n - 1);
    }

    // Helper function to reverse a part of the array
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Example run:
     * Input: n = 5, arr = [1, 2, 4, 3, 5]
     * Step 1: Break-point at index 3 (3 < 5)
     * Step 2: Swap 3 with 5 → [1, 2, 4, 5, 3]
     * Step 3: Reverse after index 3 → [1, 2, 4, 5, 3] (same since only one element)
     * Output: [1, 2, 4, 5, 3]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n followed by n integers:");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        function(arr);

        System.out.println("Next Permutation: ");
        System.out.print(Arrays.toString(arr));

        scanner.close();
    }
}

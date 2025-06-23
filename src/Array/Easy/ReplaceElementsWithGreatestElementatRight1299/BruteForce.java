package Array.Easy.ReplaceElementsWithGreatestElementatRight1299;

import java.util.Arrays;
import java.util.Scanner;

/*
Approach:
1. For every element in the array (except the last), find the maximum element to its right using another loop.
2. Replace the current element with that maximum.
3. For the last element, set it to -1.

Time Complexity: O(n²) due to the nested loop
Space Complexity: O(1)
 */
public class BruteForce {

    static public int[] replaceElementsBruteForce(int[] arr) {
        int n = arr.length;
        // Loop through each element except the last
        for (int i = 0; i < n - 1; i++) {
            int max = Integer.MIN_VALUE;
            // Find the maximum element to the right of i
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            // Replace the current element with the max on its right
            arr[i] = max;
        }
        // The Last element is always -1
        arr[n - 1] = -1;

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


            int[] result = replaceElementsBruteForce(arr);

            System.out.println("Result using Brute Force: " + Arrays.toString(result));
        }



}

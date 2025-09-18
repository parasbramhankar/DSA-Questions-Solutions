package Array.Easy.ImplementTheLowerBound;

import java.util.Arrays;
import java.util.Scanner;

public class BruteForce {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("Enter the target: ");
            int target = scanner.nextInt();

            // Step 1: Sort the array
            Arrays.sort(arr);

            // Step 2: Brute force linear search
            int lowerBound = n; // default = n (target > all elements)
            for (int i = 0; i < n; i++) {
                if (arr[i] >= target) {
                    lowerBound = i;
                    break;
                }
            }

            System.out.println("The lower bound: " + lowerBound);
        }
}

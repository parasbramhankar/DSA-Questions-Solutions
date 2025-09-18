package Array.Medium.CountSubarraysWithGivenXOR;

import java.util.Scanner;

public class BruteForce {

    public long subarrayXor(int arr[], int k) {
        // code here
        int count = 0;
        int n = arr.length;


        for (int i = 0; i < n; i++) {
            int xor = 0;

            for (int j = i; j < n; j++) {
                xor ^= arr[j];

                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the xor: ");
        int xor = scanner.nextInt();

        long count = new BruteForce().subarrayXor(arr, xor);

        System.out.println("The number of count of subarray with given xor: " + count);
        scanner.close();
    }

}

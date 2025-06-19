package Array.Easy.RemoveDuplicatesFromSortedArray;

import java.util.Scanner;

public class Optimize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (n <= 1) {
            System.out.println(n);
            return;
        }

        int l = 0;
        int r = 1;

        while (r < n) {
            if (arr[l] != arr[r]) {
                l++;
                arr[l] = arr[r];
            }
            r++;
        }

        // Print the array without duplicates

        for(int i=0;i<=l;i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println(); // clean line

        // Print the number of unique elements
        System.out.println(l + 1);
    }
}

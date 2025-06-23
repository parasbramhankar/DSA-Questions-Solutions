package Array.Easy.MajorityElement169;

/*

Approach: Using the nested for-loop

This brute-force method is used to find the majority element in an array.
A majority element is defined as the element that appears more than n/2 times in the array,
where n is the size of the array.

Steps:
1. Iterate through each element of the array using index i.

2. For each element at i, count how many times it appears in the array by
   comparing it with every other element using another loop with index j.

3. If the count of the current element exceeds n/2, return that element as
   the majority.

4. If no such element is found after checking all elements, return -1.

This approach has O(n²) time complexity due to the nested loops, which makes
it inefficient for large arrays.


 */


import java.util.Scanner;

public class BruteForce {

    public int function(int[] arr) {
        int n = arr.length; // Get the length of the array

        // Outer loop to pick each element one by one
        for (int i = 0; i < n; i++) {
            int count = 0; // Initialize count of the current element

            // Inner loop to count occurrences of arr[i]
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++; // Increment count if elements match
                }
            }

            // If count is more than n/2, return the majority element
            if (count > n / 2) {
                return arr[i];
            }
        }

        // If no majority element found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int majorityElement = new BruteForce().function(arr);

        System.out.println("The majority element that appears more than n/2 time: " + majorityElement);
    }

}

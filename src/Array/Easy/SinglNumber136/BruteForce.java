package Array.Easy.SinglNumber136;


/*
Given a non-empty array of integers nums,
every element appears twice except for one.Find that single one.
You must implement a solution with a linear runtime complexity and
use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

 */


/*
✅ Approach (Plain Steps):
 * Get the length of the array
 * Loop through each element in the array
 * For each element, initialize a counter
 * Loop through the entire array again to count how many times the current element appears
 * If the count is exactly one, return that element as the first non-repeating value
 * If no such element is found, return -1
 */

import java.util.Scanner;

public class BruteForce {

    int function(int[] arr) {
        // Using nested loops to find the first non-repeating element
        int n = arr.length;

        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            int count = 0;

            // Count how many times arr[i] appears in the array
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            // If this element appears only once, return it
            if (count == 1) {
                return arr[i];
            }
        }

        // If no unique element is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int singleNumber=new BruteForce().function(arr);

        System.out.println("Number: "+singleNumber);
    }
}

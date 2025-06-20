package Array.Easy.TwoSum_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.
 */


public class BruteForce {

    static List<Integer> function(int[] arr, int target) {
        // Create a list to store the result (indices)
        List<Integer> list = new ArrayList<>();
        int n = arr.length;

        // Loop through each element of the array
        for (int i = 0; i < n; i++) {
            // Loop through the elements that come after the current element
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j]; // Calculate the sum of the two elements

                // If the sum matches the target
                if (sum == target) {
                    list.add(i); // Add the first index
                    list.add(j); // Add the second index
                    return list; // Return the result immediately
                }
            }
        }

        // Return empty list if no such pair is found
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }
        System.out.println("Enter the target: ");
        int target= scanner.nextInt();

        List<Integer>l=function(arr,target);

        System.out.println("Indices: "+l);

    }
}

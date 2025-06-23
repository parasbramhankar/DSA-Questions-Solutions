package Array.Easy.MajorityElement169;
/*
Approach Explanation: Using a HashMap,

This method finds the majority element (the element that appears more than n/2 times)
using a HashMap.

Steps:
1. Create a HashMap to store each number and its frequency.
2. Loop through the array and update the frequency of each element in the map.
3. Once the map is populated, iterate over its entries.
4. If any value (frequency) is greater than n/2, return the corresponding key (element).
5. If no such element is found, return -1.

This approach reduces the time complexity to O(n) due to the single-pass counting and map lookup.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Efficient {

    int function(int[] arr) {
        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array and count the occurrences of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1); // Increment count or initialize to 1
        }

        int n = arr.length; // Length of the array

        // Iterate through the map entries to find the majority element
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > n / 2) { // Check if frequency > n/2
                return e.getKey(); // Return the majority element
            }
        }
        // If no majority element is found, return -1
        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int majorityElement = new Efficient().function(arr);

        System.out.println("The majority element that appears more than n/2 time: " + majorityElement);
    }
}

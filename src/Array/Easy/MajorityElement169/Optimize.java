/*
✅Approach Explanation (Moore’s Voting Algorithm):

This algorithm efficiently finds a candidate for the majority element in O(n) time and O(1) space.

Steps:

1. Initialize two variables:
   * `ele`: stores the current candidate for the majority element.
   * `count`: keep track of how strongly we believe the candidate is the majority.

2. Iterate through the array:
   * If `count == 0`, assume the current number is the new candidate and set `count = 1`.
   * If the current number equals the candidate (`ele`), increment `count`.
   * If not, decrement `count`.

3. Validate that the founded number is majority or not by counting the appearance of the given number
   if the current element matches the element then increment count,

4. if count>n/2 Return the candidate stored in `ele`.
   (Note: If it's required to confirm that this is indeed a majority, a second pass can be added.)

This algorithm works only if it's guaranteed that a majority element exists.
 */


package Array.Easy.MajorityElement169;

import java.util.Scanner;

public class Optimize {

    static int function(int[] arr) {
        int ele = 0;   // Potential majority element
        int count = 0; // Counter to track frequency balance
        // Phase 1: Find the candidate using Moore's Voting Algorithm
        for (int num : arr) {
            if (count == 0) {
                ele = num;   // Assume current element as majority
                count = 1;
            } else {
                count += (num == ele) ? 1 : -1;
            }
        }
        // Phase 2: Verify if the candidate is actually the majority
        count = 0;
        for (int num : arr) {
            if (num == ele) {
                count++;
            }
        }
        // Return the candidate only if it occurs more than n/2 times
        return (count > arr.length / 2) ? ele : -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int majorityElement = function(arr);

        System.out.println("The majority element that appears more than n/2 time: " + majorityElement);
    }
}



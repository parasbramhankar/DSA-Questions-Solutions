package Array.Easy.MoveZeroesToEnd283;

/*
Approach (Plain Steps):

* Initialize two pointers: left to track the position to place the next non-zero, and right to scan the array
* Traverse the array using the right pointer
* If the current element is non-zero, copy it to the left index and increment left
* Continue this until all non-zero elements have been moved to the front
* After the loop, fill the remaining positions from left to end of array with zeroes
 */

import java.util.Arrays;

public class Optimize {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;

        // Initialize two pointers
        int left = 0;  // Points to the next position to fill with a non-zero value
        int right = 0; // Scans through the array

        // Move non-zero elements to the front
        while (right < n) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        // Fill remaining positions with zeroes
        while (left < n) {
            nums[left] = 0;
            left++;
        }
    }

    public static void main(String[] args) {
        int[]arr={0,1,0,3,12};

        System.out.println("Before: "+ Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("After: "+Arrays.toString(arr));
    }


}

package Array.Easy.CheckIfArrayIsSortedAndRotated1752;

/*
Approach:

* Initialize a counter to zero
* Get the length of the array
* If the first element is less than the last element, assume it is in ascending order and increment the counter by one
* Loop through the array from index 0 to n - 2
* For every pair of adjacent elements, if the current element is greater than the next one, increment the counter
* If the counter becomes greater than 1, return false, meaning the array is not sorted and rotated
* If the loop completes and count is not greater than 1, return true, meaning the array is sorted and rotated at most once


-------------------------------------------

✅ Approach Explanation

This function is designed to check whether an array is sorted and rotated.

🧠 Problem it solves:
We want to check if an array is:
    * Sorted in increasing order, and
    * Possibly rotated (shifted circularly)

🔍 What it does:

* An array is sorted and rotated if it was originally sorted in increasing order,
  but then rotated some number of times (could be 0).

* For example,
  `[1, 2, 3, 4, 5]` → Sorted (not rotated)
  `[3, 4, 5, 1, 2]` → Sorted and rotated
  `[2, 1, 3, 4, 5]` → Not sorted and rotated

✅ Steps Explained:

1. Initialize a counter `count` to 0.
2. Check if the array violates the sorted order by finding any descending pair (`arr[i] > arr[i+1]`).
   Increment `count` each time this is found.
3. Special case: If the first element is less than the last,
   it means the array was not rotated but out of order,
   so increment `count` (this handles cases like `[3, 4, 1, 2]` being valid, but `[2, 1, 3]` not).
4. If there’s more than one violation in sorted order, return `false`.
   Otherwise, return `true`.
 */
import java.util.Scanner;

public class Optimize {


    static boolean check(int[] arr) {
        int count = 0;           // Count the number of descending points
        int n = arr.length;

        // Special case: If the first element is less than the last,
        // and an array has been rotated, then this indicates a possible disorder
        if (arr[0] < arr[n - 1]) {
            count++;
        }
        // Loop to find how many times the order is violated (i.e., arr[i] > arr[i+1])
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count++; // This means array is not fully sorted
            }
        }
        // If the number of descending transitions is more than one,
        // it cannot be a sorted and rotated array
        if (count > 1) {
            return false;
        }
        // Valid sorted and rotated array
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        if(check(arr)){
            System.out.println("This array is sorted and Rotated");
        }
        else{
            System.out.println("This array is not sorted and Rotated");
        }

    }
}

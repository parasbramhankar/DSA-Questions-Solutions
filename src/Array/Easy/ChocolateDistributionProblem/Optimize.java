package Array.Easy.ChocolateDistributionProblem;
/*
✅ Step-by-step Logic

1. Sort the array:
   Sorting helps bring closer elements together. After sorting, the difference between max and min of any subarray of size `m` is simply the difference between the first and last elements of that subarray.

2. Slide a window of size `m` over the sorted array:
   For every window (from `i` to `i+m-1`), calculate the difference between the max and min of that group: `arr[i+m-1] - arr[i]`.

3. Track the minimum of these differences:
   This gives us the most “fair” group (i.e., the one with the smallest difference between the largest and smallest values).
---

🔍 Example
int[] arr = {10, 20, 30, 100, 40, 60, 70};
int m = 3;

// Sorted array = {10, 20, 30, 40, 60, 70, 100}

// Windows of size 3:
// {10,20,30} → diff = 20
// {20,30,40} → diff = 20
// {30,40,60} → diff = 30
// {40,60,70} → diff = 30
// {60,70,100} → diff = 40
// Min of these = 20 → returned



Time Complexity: O(n*log n)
 */
import java.util.Arrays;

public class Optimize {

    // Function to find the minimum difference between max and min elements
    // of any group of sizes 'm' from the array
    public static int function(int[] arr, int m) {
        // Sort the array so that elements close in value come together
        Arrays.sort(arr);

        int n = arr.length;
        // Initialize the minimum difference to the highest possible value
        int minDiff = Integer.MAX_VALUE;

        // Slide a window of size 'm' through the sorted array
        for (int i = 0; i <= n - m; i++) {
            // Find the difference between the largest and smallest elements
            // in this window (arr[i+m-1] is the max, arr[i] is the min)
            int currentDiff = arr[i + m - 1] - arr[i];

            // Update the minimum difference if the current one is smaller
            minDiff = Math.min(minDiff, currentDiff);
        }

        // Return the smallest difference found among all possible windows
        return minDiff;
    }


    public static void main(String[] args) {
        int[]arr=new int[]{3, 4, 1, 9, 56, 7, 9, 12};
        int m=5;

//        int[]arr=new int[]{7, 3, 2, 4, 9, 12, 56};
//        int m=3;

//        int[]arr=new int[]{3, 4, 1, 9, 56};
//        int m=5;


        System.out.println(function(arr,m));
    }
}

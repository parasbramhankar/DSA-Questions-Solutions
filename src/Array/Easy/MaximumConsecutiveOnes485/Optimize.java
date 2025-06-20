package Array.Easy.MaximumConsecutiveOnes485;

import java.util.Scanner;

public class Optimize {

    // Function to find the maximum number of consecutive 1s in a binary array (Optimized approach)
    static int maxCountOnes(int[] arr) {
        int maxCount = 0;  // This variable stores the maximum streak of 1s found so far
        int count = 0;     // This variable counts the current streak of 1s

        int n = arr.length;

        // Traverse the array from beginning to end
        for (int i = 0; i < n; i++) {

            if (arr[i] == 1) {
                // If the current element is 1, increase the current streak count
                count++;
            } else {
                // If a 0 is found, update maxCount with the longest streak so far
                maxCount = Math.max(maxCount, count);

                // Reset current streak count to 0
                count = 0;
            }
        }

        // After the loop, we do one final comparison in case the array ended with 1s
        // This ensures we don't miss the last streak if it was the longest
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int count=new Optimize().maxCountOnes(arr);

        System.out.println("Maximum count of 1's: "+count);
    }
}

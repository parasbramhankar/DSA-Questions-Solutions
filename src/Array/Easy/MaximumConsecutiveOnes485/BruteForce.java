package Array.Easy.MaximumConsecutiveOnes485;


//For large input it shows the TLE error
/*
Approach:

* Initialize a variable to keep track of the maximum number of consecutive ones
* Loop through each element of the array as a starting point
* For each starting point, initialize a count and check how many consecutive ones follow
* If a zero is encountered, break the inner loop
* After the inner loop, if the current count is greater than the maximum, update the maximum
* Return the maximum count after all iterations

 */
import java.util.Scanner;

public class BruteForce {

    static int maxCountOnes(int[] arr) {
        int maxCount = 0; // To store the maximum number of consecutive 1s found

        int n = arr.length;

        // Loop through each index of the array
        for (int i = 0; i < n; i++) {
            int count = 0; // Count consecutive 1s starting from index i

            // Start another loop from index i to the end of the array
            for (int j = i; j < n; j++) {

                // If current element is 1, increment count
                if (arr[j] == 1) {
                    count++;
                } else {
                    // If a 0 is found, break the inner loop as the streak is broken
                    break;
                }
            }

            // Update maxCount if the current streak is the largest so far
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // Return the maximum number of consecutive 1s found
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int count=new BruteForce().maxCountOnes(arr);

        System.out.println("Maximum count of 1's: "+count);
    }

}

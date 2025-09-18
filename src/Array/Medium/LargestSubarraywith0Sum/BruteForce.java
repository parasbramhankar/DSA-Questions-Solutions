package Array.Medium.LargestSubarraywith0Sum;
/*
Intuition:
We are required to find the longest subarray that sums to zero. So our initial approach
could be to consider all possible subarrays of the given array and check for the subarrays
that sum to zero.
Among these valid subarrays (a sum equal to zero) we’ll return the length of the largest
subarray by maintaining a variable, say max.

Approach :
Initialize a variable max = 0, which stores the length of the longest subarray with a sum of 0.
Traverse the array from the start and initialize a variable sum = 0 which stores the sum of the subarray starting with the current index
Traverse from the next element of current_index up to the end of the array, each time add the element to the sum and check if it is equal to 0.
If sum = 0, check if the length of the subarray so far is > max and if yes update max
Now keep adding elements and repeat step 3 a.
After the outer loop traverses all elements return max
 */
public class BruteForce {
        static int solve(int[] a){
            int  max = 0;
            for(int i = 0; i < a.length; ++i){
                int sum = 0;
                for(int j = i; j < a.length; ++j){
                    sum += a[j];
                    if(sum == 0){
                        max = Math.max(max, j-i+1);
                    }
                }
            }
            return max;
        }

        public static void main(String []args)
        {
            int []a = {9, -3, 3, -1, 6, -5};
            System.out.println(solve(a));
        }

}

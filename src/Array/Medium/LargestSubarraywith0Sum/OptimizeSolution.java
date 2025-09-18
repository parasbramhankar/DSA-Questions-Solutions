package Array.Medium.LargestSubarraywith0Sum;


import java.util.HashMap;
import java.util.Scanner;

/***
 * Intuition:
 * Now let’s say we know that the sum of subarray(i, j) = S, and we also know that the sum of subarray(i, x) = S where i < x < j. We can conclude that the sum of subarray(x+1, j) = 0.
 *
 * Let us understand the above statement clearly,
 *
 * So in this problem, we’ll store the prefix sum of every element,
 * and if we observe that 2 elements have the same prefix sum,
 * we can conclude that the 2nd part of this subarray sums to zero
 *
 * Now let’s understand the approach
 *
 * Approach:
 * First, let us initialize a variable say sum = 0 which stores the sum of elements traversed so far and
 * another variable says max = 0 which stores the length of the longest subarray with sum zero.
 *
 * Declare a HashMap<Integer, Integer> which stores the prefix sum of every element as a
 * key and its index as a value.
 *
 * Now traverse the array, and add the array element to our sum.
 *  (i)  If sum = 0, then we can say that the subarray until the current index has a sum = 0,
 *       so we update max with the maximum value of (max, current_index+1)
 *
 * (ii)  If the sum is not equal to zero then we check the hashmap if we’ve seen a
 *       subarray with this sum before
 *
 * if HashMap contains sum -> this is where the above-discussed case occurs (subarray with equal sum),
 * so we update our max
 *
 * else -> Insert (sum, current_index) into hashmap to store prefix sum until the current index
 *
 * After traversing the entire array our max variable has the length of the longest substring having a sum equal to zero, so return max.
 * NOTE: we do not update the index of a sum if it’s seen again because we require the length of the longest subarray
 *---------------------------------------------------------------------------------------------------------------------------------------
 * Dry Run: Let us dry-run the algorithm for a better understanding
 *
 * Input : N = 5, array[] = {1, 2, -2, 4, -4}
 * Output : 5
 *
 * Initially sum = 0, max = 0
 * HashMap<Integer, Integer> h = [ ];
 * i=0 -> sum=1, sum!=0 so check in the hashmap if we’ve seen a subarray with this sum before,
 *        in our case hashmap does not contain sum (1), so we add (sum, i) to the hashmap.
 * h = [[1,0]]
 * i=1 -> sum=3, sum!=0 so check in the hashmap if we’ve seen a subarray with this sum before,
 *        in our case hashmap does not contain sum (3), so we add (sum, i) to the hashmap.
 * h=[[1,0], [3,1]]
 * i=2 -> sum=1, sum!=0 so check in hashmap if it contains sum, in our case hashmap contains sum (1)
 *
 * Here we can observe that our current sum is seen before which concludes that it’s a zero subarray.
 * So we now update our max as maximum(max, 2-0) => max = 2
 * h=[[1,0], [3,1]]
 *
 * i=3 -> sum=5, sum!=0 so check in hashmap if it contains sum, in our case hashmap does not contain sum (5),
 *        so we add (sum, i) to hashmap.
 * h=[[1,0], [3,1], [5,3]]
 *
 * i=4 -> sum=1, sum!=0 so check in hashmap if it contains sum, in our case hashmap contains sum (1).
 *        Here we can again observe our above-discussed case, So we now update our max as maximum(max, 4-0) => max = maximum(2, 4) = 4
 * h=[[1,0], [3,1], [5,3]]
 * Now that we have traversed our whole array, our answer is max = 4, Subarray = {2, -2, 4, -4}
 */
public class OptimizeSolution {

        int maxLength(int arr[]) {
            // code here
            HashMap<Integer,Integer> hs=new HashMap<>();
            int sum=0;
            int maxLength=0;

            for(int i=0;i<arr.length;i++){

                sum=sum+arr[i];

                if(sum==0){
                    maxLength=Math.max(maxLength,i+1);
                }

                int rem=0-sum;

                if(hs.containsKey(sum)){
                    maxLength=Math.max(maxLength,i-hs.get(sum));
                }

                if(!hs.containsKey(sum)){
                    hs.put(sum,i);
                }
            }

            return maxLength;
        }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int length=new OptimizeSolution().maxLength(arr);

        System.out.println("The Maximum length of the array having the sum 0 : "+length);

        scanner.close();

    }



}

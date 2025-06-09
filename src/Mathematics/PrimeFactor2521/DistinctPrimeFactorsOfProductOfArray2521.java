package Mathematics.PrimeFactor2521;

/*
Given an array of positive integers nums, return the number of distinct prime factors in the product of the elements of nums.

Note that
A number greater than 1 is called prime if it is divisible by only 1 and itself.
An integer val1 is a factor of another integer val2 if val2 / val1 is an integer.


Example 1:
Input: nums = [2,4,3,7,10,6]
Output: 4
Explanation:
The product of all the elements in nums is: 2 * 4 * 3 * 7 * 10 * 6 = 10080 = 25 * 32 * 5 * 7.
There are 4 distinct prime factors, so we return 4.

Example 2:
Input: nums = [2,4,8,16]
Output: 1
Explanation:
The product of all the elements in nums is: 2 * 4 * 8 * 16 = 1024 = 210.
There is 1 distinct prime factor, so we return 1.
 */


/// Logic is written on the copy

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimeFactorsOfProductOfArray2521 {



        static void addPrimeFactors(int n, Set<Integer> set) {
            while (n % 2 == 0) {
                set.add(2);
                n /= 2;
            }
            while (n % 3 == 0) {
                set.add(3);
                n /= 3;
            }

            for (int i = 5; i <= Math.sqrt(n); i += 6) {
                while (n % i == 0) {
                    set.add(i);
                    n /= i;
                }
                while (n % (i + 2) == 0) {
                    set.add(i + 2);
                    n /= (i + 2);
                }
            }

            if (n > 3) {
                set.add(n);
            }
        }

        static public int distinctPrimeFactors(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                addPrimeFactors(num, set);
            }

            return set.size();
        }

    public static void main(String[] args) {
          int []nums={10,20,30,10,2,4,2,4};
        System.out.println("Number of Distinct Prime number "+distinctPrimeFactors(nums));
    }
}

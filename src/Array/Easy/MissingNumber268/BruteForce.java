package Array.Easy.MissingNumber268;

/*
Here is the approach and pseudocode for the given Java function
that finds the missing number in an array containing numbers from `0` to `n` with one number missing:
---
Approach:

 1. The array `nums` contains `n` distinct numbers in the range `0` to `n`.
 2. The goal is to find the single missing number.
 3. For each number `i` from `0` to `n`:
   a. Check if `i` exists in the array using a nested loop.
   b. If `i` is not found, it is the missing number.
 4. Return that number.

 Time complexity is O(n²) due to nested loops.
---
Pseudocode:
Function missingNumber(nums):
    n ← length of nums
    num ← 0
    For i from 0 to n:
        c ← 0
        For j from 0 to n - 1:
            If i == nums[j]:
                c ← 1
                Break
        If c == 0:
            num ← i
    Return num
```
 */


public class BruteForce {

        public static int missingNumber(int[] nums) {
            int n=nums.length;
            int num=0;

            for(int i=0;i<=n;i++){
                int c=0;
                for(int j=0;j<n;j++){
                    if(i==nums[j]){
                        c=1;
                        break;
                    }
                }
                if(c==0){
                    num=i;
                }
            }
            return num;
        }

    public static void main(String[] args) {
        int[]arr={3,0,1};

        System.out.println("Missing Number: "+missingNumber(arr));
    }
    
    
}

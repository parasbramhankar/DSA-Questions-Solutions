package Array.Easy.MissingNumber268;
/*
Approach:

* Calculate the expected sum of numbers from 0 to n using the formula n times n plus 1 divided by 2
* Loop through the array and subtract each element from the expected sum
* After the loop ends; the remaining value in a sum will be the missing number
* Return the remaining value as the result

 */
public class Optimize {
        public static int missingNumber(int[] nums) {
            int n=nums.length;

            int sum=n*(n+1)/2;

            for(int i=0;i<n;i++){
                sum-=nums[i];
            }

            return sum;
        }

    public static void main(String[] args){
        int[]arr={3,0,1};

        System.out.println("Missing Number: "+missingNumber(arr));
    }
}

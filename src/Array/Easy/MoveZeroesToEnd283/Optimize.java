package Array.Easy.MoveZeroesToEnd283;

import java.util.Arrays;

public class Optimize {
    public static void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;

        while(right<n){
            if(nums[right]!=0){
                nums[left]=nums[right];
                left++;
            }
            right++;
        }

        while(left<n){
            nums[left]=0;
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

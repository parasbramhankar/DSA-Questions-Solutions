package Array.Easy.MoveZeroesToEnd283;

import java.util.Arrays;

public class BruteForce {

    public static void moveZeroes(int[] nums) {

        int n=nums.length;
        int []temp=new int[n];
        int ind=0;

        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                temp[ind]=nums[i];
                ind++;
            }
        }

        while(ind<n){
            temp[ind]=0;
            ind++;
        }

        for(int i=0;i<n;i++){
            nums[i]=temp[i];
        }
    }

    public static void main(String[] args) {
        int[]arr={0,1,0,3,12};

        System.out.println("Before: "+ Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println("After: "+Arrays.toString(arr));
    }
}

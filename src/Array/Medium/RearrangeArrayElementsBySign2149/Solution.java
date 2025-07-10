package Array.Medium.RearrangeArrayElementsBySign2149;

import java.util.Arrays;

class Solution {
    public static int[] rearrangeArray(int[] nums) {
        int pos=0;
        int neg=1;
        int n=nums.length;

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr[pos]=nums[i];
                pos+=2;
            }
            else{

                arr[neg]=nums[i];
                neg+=2;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[]arr={10,-2,-4,-6,2,9};

        int[]result=rearrangeArray(arr);

        System.out.println(Arrays.toString(result));
    }


}

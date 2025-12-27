package BinarySearch.Medium.FindMinimuminRotatedSortedArray153;

import java.util.Scanner;

public class Solution   {

        public static int findMin(int[] nums) {

            int low=0;
            int high=nums.length-1;

            while(low<high){

                int mid=low+(high-low)/2;

                if(nums[mid]<nums[high]){
                    high=mid;
                }else{
                    low=mid+1;
                }
            }

            return nums[low];

        }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int minElement=findMin(arr);

        System.out.println("Minimum element: "+minElement);
    }
}




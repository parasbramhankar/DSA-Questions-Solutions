package BinarySearch.Medium.SearchInRotateSortedArray33;

import java.util.Scanner;

public class Solution {

    static int searchElement(int[]arr,int target){
        int low=0;
        int high=arr.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                return mid;
            }

            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && arr[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target<arr[mid] && target<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("Enter the element: ");
        int k= scanner.nextInt();

        int ind=searchElement(arr,k);

        System.out.println("Element found at index "+ind);
    }
}

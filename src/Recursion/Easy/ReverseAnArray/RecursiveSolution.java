package Recursion.Easy.ReverseAnArray;

import java.util.Arrays;

public class RecursiveSolution {
    public static void reverseAnArray(int[]arr){

        reverse(arr,0,arr.length-1);
    }
    public static void reverse(int[]arr,int start,int end){
        if(start>=end){
            return;
        }
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;

        reverse(arr,start+1,end-1);
    }

    public static void main(String[] args) {
        int []arr=new int[]{10,20,30,40,50,60};
        System.out.println("Array before reverse: "+ Arrays.toString(arr));
        reverseAnArray(arr);

        System.out.println();
        System.out.println("Array After reverse: "+ Arrays.toString(arr));
    }
}

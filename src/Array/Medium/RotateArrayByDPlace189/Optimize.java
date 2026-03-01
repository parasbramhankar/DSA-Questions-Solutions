package Array.Medium.RotateArrayByDPlace189;
/*
Question 74: Given an integer array nums, rotate the array to the right by k steps,
          where k is non-negative.

* The function rotates the array to the right by k positions using the reversal algorithm
* First, it handles cases where k is larger than the array size by taking k modulo n
* Then, it reverses the first part of the array from index 0 to n-k-1
* Next, it reverses the second part of the array from index n-k to n-1
* Finally, it reverses the entire array from index 0 to n-1
* This sequence of reversals results in the array being rotated to the right by k positions in-place
* Time complexity is O(n) and space complexity is O(1)
*/


import java.util.Arrays;
import java.util.Scanner;

public class Optimize {

    static void reverseArray(int[]arr,int start,int end){

        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    static void rotateArray(int[]arr,int k){
        int n=arr.length;
        k=k%n;  // if the size of the array is less than k i.e number times wants to rotate array

        reverseArray(arr,0,n-k-1);
        reverseArray(arr,n-k,n-1);
        reverseArray(arr,0,n-1);

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        System.out.println("Enter the value of K");
        int k= scanner.nextInt();

        rotateArray(arr,k);

        System.out.println(Arrays.toString(arr));

    }
}

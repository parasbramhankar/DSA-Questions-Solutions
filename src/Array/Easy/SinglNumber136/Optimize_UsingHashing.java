/*
Given a non-empty array of integers nums,
every element appears twice except for one.Find that single one.
You must implement a solution with a linear runtime complexity and
use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

 */

package Array.Easy.SinglNumber136;

import java.util.Scanner;

public class Optimize_UsingHashing {

    int function(int []arr){
        int xor=0;
        int n=arr.length;

        for(int i=0;i<n;i++){
          xor^=arr[i];
        }

        return xor;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int singleNumber=new Optimize_UsingHashing().function(arr);

        System.out.println("Number: "+singleNumber);


    }

}

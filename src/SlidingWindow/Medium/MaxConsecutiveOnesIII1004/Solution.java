package SlidingWindow.Medium.MaxConsecutiveOnesIII1004;

import java.util.Scanner;

public class Solution {

    static int function(int[]arr,int k){
        int maxLen=0;
        int countZero=0;
        int left=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                countZero++;
            }
            while(countZero>k){
                if(arr[left]==0){
                    countZero--;
                }
                left++;
            }
            maxLen=Math.max(maxLen,i-left+1);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n= scanner.nextInt();
        int[]arr=new int[n];

        System.out.println("Enter the binary array: ");
        for (int i = 0; i < n; i++) {
            arr[i]= scanner.nextInt();
        }
        System.out.println("Enter the number of 0's wants to flip");
        int k= scanner.nextInt();

        int maxConsecutiveOnes=function(arr,k);

        System.out.println("the maximum number of consecutive 1's in the array if you can flip at most k 0's :"+maxConsecutiveOnes);

    }
}

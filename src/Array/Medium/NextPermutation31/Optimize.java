package Array.Medium.NextPermutation31;

import java.util.Arrays;
import java.util.Scanner;

public class Optimize {

    public  static void function(int[]arr){
        int ind=-1;
        int n=arr.length;

        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(arr,0,n-1);
        }

        for(int i=n-1;i>=0;i--){
            if(arr[i]>arr[ind]){
                int temp=arr[i];
                arr[i]=arr[ind];
                arr[ind]=temp;
                break;
            }
        }

        reverse(arr,ind+1,n-1);
    }

    public static void reverse(int[]arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        function(arr);
        System.out.println("Next Permutation: ");
        System.out.print(Arrays.toString(arr));
    }
}

package Array.Easy.CheckIfArrayIsSortedAndRotated1752;

import java.util.Scanner;

public class Optimize {


    static boolean check(int[]arr){
        int count=0;
        int n= arr.length;

        if(arr[0]<arr[n-1]){
            count=1;
        }

        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                count++;
            }
        }

        if(count>1){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        if(check(arr)){
            System.out.println("This array is sorted and Rotated");
        }
        else{
            System.out.println("This array is not sorted and Rotated");
        }

    }
}

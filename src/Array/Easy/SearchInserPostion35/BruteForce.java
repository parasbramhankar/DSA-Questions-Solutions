package Array.Easy.SearchInserPostion35;

import java.util.Scanner;

public class BruteForce {
    static int checkLocation(int []arr, int num){
        
        int pos=arr.length;
        
        for(int i=0;i<arr.length;i++){
           if(arr[i]>=num){
               return i;
           }
        }
        return pos;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        System.out.println("Enter the Element you what to be search: ");
        int num= scanner.nextInt();

        int pos=checkLocation(arr,num);
        System.out.println("The Position : "+(pos+1));
    }
}

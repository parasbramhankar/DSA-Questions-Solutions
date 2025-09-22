package Array.Easy.SearchInserPostion35;

import java.util.Scanner;

public class OptimizeSolution {

    static int checkLocation(int []arr, int num){
        int low=0;
        int high=arr.length-1;
        int pos=arr.length;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>=num){
                pos=mid;
                high=mid-1;
            }else{
                low=mid+1;
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

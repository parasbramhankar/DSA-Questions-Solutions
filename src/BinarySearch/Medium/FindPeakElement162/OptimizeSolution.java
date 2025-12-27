package BinarySearch.Medium.FindPeakElement162;

import java.util.Scanner;

public class OptimizeSolution {

    static int function(int[]arr){
        int low=0;
        int high=arr.length-1;

        while(low<high){
            int mid=low+(high-low)/2;

            if(arr[mid]>arr[mid+1]){
                high=mid;
            }else{
                low=mid+1;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        int peek=function(arr);

        System.out.println("The index of peek element: "+peek);
        System.out.println("The peek element: "+arr[peek]);
    }
}

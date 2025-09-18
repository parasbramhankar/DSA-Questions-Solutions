package Array.Easy.ImplementTheLowerBound;

import java.util.Arrays;
import java.util.Scanner;

public class OptimizeSolution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n= scanner.nextInt();

        int[]arr=new int[n];

        for (int i = 0; i <n ; i++) {
            arr[i]= scanner.nextInt();
        }

        System.out.println("Enter the target : ");
        int target= scanner.nextInt();

        Arrays.sort(arr);

        int low=0;
        int high=n-1;
        int lowerBound=n;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(target>arr[mid]){
                low=mid+1;
            }else if(target<=arr[mid]){
                lowerBound=mid;
                high=mid-1;
            }
        }

        System.out.println("The lower bound: "+lowerBound);

    }
}

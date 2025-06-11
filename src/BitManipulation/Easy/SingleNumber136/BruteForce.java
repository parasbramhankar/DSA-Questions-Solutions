package BitManipulation.Easy.SingleNumber136;

import java.util.Scanner;

public class BruteForce {

    public static void main(String[] args) {

        int[]arr=new int[]{10,20,10,1, 1,4,4};
        int n=arr.length;

        for(int i=0;i<n;i++){
            int count=0;

            for(int j=1;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }

            if(count%2==1){
                System.out.println(arr[i]+" Present odd number of times");
            }
        }
    }
}

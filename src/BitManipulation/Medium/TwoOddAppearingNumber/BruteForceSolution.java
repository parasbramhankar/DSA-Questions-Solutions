package BitManipulation.Medium.TwoOddAppearingNumber;

import java.util.Scanner;

public class BruteForceSolution {
    public static void main(String[] args) {
        int[]arr=new int[]{10,20,10,20,1,4};
        int n=arr.length;

        for(int i=0;i<n;i++){

            int count=0;

            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }

            if(count%2!=0){
                System.out.print(arr[i]+" ");
            }
        }

    }
}

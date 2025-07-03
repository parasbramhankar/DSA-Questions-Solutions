package Array.Medium.MajorityElement_II229;

import java.util.Scanner;

public class BruteForce {

    static int function(int[]arr){
        int n=arr.length;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }

                if(count>=n/3){
                    return arr[i];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        int element=function(arr);

        System.out.println("The majority element: "+element);

    }
}

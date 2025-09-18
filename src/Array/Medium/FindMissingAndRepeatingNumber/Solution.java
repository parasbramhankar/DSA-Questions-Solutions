package Array.Medium.FindMissingAndRepeatingNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
       static ArrayList<Integer> findTwoElement(int []arr) {
            // code here
            int n=arr.length;
            int []a=new int[n+1];
            for(int i=0;i<n;i++){
                a[arr[i]]++;
            }
            int k=0;
            int l=0;
            for(int i=1;i<=n;i++){
                if(a[i]==0){
                    k=i;
                }

                if(a[i]>1){
                    l=i;
                }
            }
            return new ArrayList<>(Arrays.asList(l,k));
        }
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int []arr=new int[n];

       for(int i=0;i<n;i++) {
           arr[i]= scanner.nextInt();;
       }
        ArrayList<Integer>arrList=findTwoElement(arr);

        System.out.println("Repeating and Missing number: "+arrList);
    }
}

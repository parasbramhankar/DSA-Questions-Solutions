package BitManipulation.Medium.PowerSetArray78;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PowerSetInArrayUsingBitManipulation {

    static List<List<Integer>> findThePowerSet(int[]arr){
        List<List<Integer>>list=new ArrayList<>();

        int n=arr.length;
        int pSize=(int)Math.pow(2,n);

        for(int i=0;i<pSize;i++){
           List<Integer>arrList=new ArrayList<>();

           for(int j=0;j<n;j++){

               if((i & (1<<j))!=0){
                   arrList.add(arr[j]);
               }

           }

           list.add(arrList);
        }

        return list;
    }


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of Array elements: ");
        int n=scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        List<List<Integer>>finalList=findThePowerSet(arr);

        System.out.println(finalList.toString());

        scanner.close();
    }
}

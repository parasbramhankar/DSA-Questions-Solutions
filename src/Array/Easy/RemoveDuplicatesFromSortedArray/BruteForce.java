package Array.Easy.RemoveDuplicatesFromSortedArray;

import java.util.HashSet;
import java.util.Scanner;

public class BruteForce {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
          arr[i]=scanner.nextInt();
        }
        HashSet<Integer>set=new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }

        System.out.println(set.toString());
        System.out.println(set.size());


    }
}

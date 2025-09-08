package Array.Easy.CheckIfArrayIsSorted;

import java.util.Scanner;
/*
public class Optimize {

    static boolean check(int[]arr){
        int n=arr.length;
        boolean isSorted=true;
        String choice="";

        if(arr[0]>arr[n-1]){
            choice="Des";  //Considering the array is sorted in descending way
        }
        else{
            choice="Asc"; //Considering the array is sorted in ascending way
        }

        switch (choice){
            case "Des":
                for(int i=0;i<n-1;i++){
                    if(arr[i]<arr[i+1]){
                        isSorted=false;
                        break;
                    }
                }
                break;
            case "Asc":
                for(int i=0;i<n-1;i++){
                    if(arr[i]>arr[i+1]){
                        isSorted=false;
                        break;
                    }
                }
                break;
        }

        return isSorted;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        if(!check(arr)){
            System.out.println("Not Sorted");
        }
        else{
            System.out.println("Array is sorted");
        }
    }
}

*/



/*
Approach:

 * Check if the array has only one element or is empty, in which case it's considered sorted.
 * Determine whether the array is supposed to be in ascending or descending order by comparing the first and last elements.
 * Loop through the array from start to second last element.
 * If the array is supposed to be ascending and any element is greater than the next, return false.
 * If the array is supposed to be descending and any element is smaller than the next, return false.
 * If the loop completes without returning false, return true indicating the array is sorted.
 */

public class Optimize {

    static boolean check(int[] arr) {
        int n = arr.length;

        if (n <= 1) return true; // Single element is always sorted

        boolean ascending = arr[0] <= arr[n - 1];

        for (int i = 0; i < n - 1; i++) {
            if (ascending && arr[i] > arr[i + 1]) {
                return false;
            }
            if (!ascending && arr[i] < arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(check(arr) ? "Array is sorted" : "Not Sorted");
    }
}

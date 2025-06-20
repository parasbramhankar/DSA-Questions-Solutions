package Array.Easy.CheckIfArrayIsSortedAndRotated1752;



/*
Approach:

* Initialize a counter to zero
* Get the length of the array
* If the first element is less than the last element, assume it is in ascending order and increment the counter by one
* Loop through the array from index 0 to n - 2
* For every pair of adjacent elements, if the current element is greater than the next one, increment the counter
* If the counter becomes greater than 1, return false, meaning the array is not sorted and rotated
* If the loop completes and count is not greater than 1, return true, meaning the array is sorted and rotated at most once

 */
import java.util.Scanner;

public class Optimize {


    static boolean check(int[]arr){
        int count=0;
        int n= arr.length;

        if(arr[0]<arr[n-1]){
            count=1;
        }

        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                count++;
            }
        }

        if(count>1){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }

        if(check(arr)){
            System.out.println("This array is sorted and Rotated");
        }
        else{
            System.out.println("This array is not sorted and Rotated");
        }

    }
}

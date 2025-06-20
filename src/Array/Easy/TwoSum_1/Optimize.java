package Array.Easy.TwoSum_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Optimize {
    static int[] function(int[] arr, int target) {
        // Map to store value -> index
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        // Traverse the array once
        for (int i = 0; i < n; i++) {
            int rem = target - arr[i]; // Calculate the complement

            // If complement is already in the map, return the indices
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }

            // Store the current element with its index if not already present
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
        }

        // Return an empty array if no valid pair found
        return new int[]{};
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }
        System.out.println("Enter the target: ");
        int target= scanner.nextInt();

        int[]display=function(arr,target);

        System.out.println("Indices: "+ Arrays.toString(display));
    }
}

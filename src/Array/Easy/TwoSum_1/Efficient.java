package Array.Easy.TwoSum_1;

import java.util.*;

public class Efficient {

    static int[] function(int[] arr, int target) {
        // Map to store array elements and their indices
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        // First pass: store all elements with their indices in the map
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        // Second pass: check for each element if the complement (target - current) exists
        for (int i = 0; i < n; i++) {
            int rem = target - arr[i]; // Find the required complement

            // Check if the complement exists in the map and is not the same index
            if (map.containsKey(rem) && map.get(rem) != i) {
                return new int[]{i, map.get(rem)}; // Return the pair of indices
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

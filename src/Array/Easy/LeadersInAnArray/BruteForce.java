package Array.Easy.LeadersInAnArray;
/*
Approach:

1. For each element in the array, check whether it is greater than or equal to
   every element to its right.
2. If it is, mark it as a leader.

The time complexity is O(n²) due to the nested loop.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BruteForce {

    static public List<Integer> findLeadersBruteForce(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();

        // Loop through each element
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;

            // Compare with all elements to the right of arr[i]
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false; // Not a leader if a greater element exists
                    break;
                }
            }

            if (isLeader) {
                leaders.add(arr[i]); // Add to result if it's a leader
            }
        }

        return leaders;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Brute Force Result
        List<Integer> bruteForceLeaders = findLeadersBruteForce(arr);
        System.out.println("Leaders (Brute Force): " + bruteForceLeaders);
    }
}

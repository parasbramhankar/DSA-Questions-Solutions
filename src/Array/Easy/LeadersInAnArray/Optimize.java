package Array.Easy.LeadersInAnArray;

/*
✅ Approach:

1. Start from the rightmost element (it’s always a leader).
2. Keep track of the maximum element seen so far
3. Traverse the array from right to left.
4 .If the current element is greater than or equal to max, add it to the result.
5. Finally, reverse the result (since we collected from right to left).

Time complexity is O(n).
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Optimize {
    static public List<Integer> findLeadersOptimized(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();

        int maxFromRight = arr[n - 1]; // The Rightmost element is always a leader
        leaders.add(maxFromRight); // Add it to the result

        // Traverse from second last to the beginning
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i]; // Update maxFromRight
                leaders.add(arr[i]);   // Add current element to leaders
            }
        }

        // Reverse the list to restore the original order
        Collections.reverse(leaders);
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

        // Optimized Result
        List<Integer> optimizedLeaders = findLeadersOptimized(arr);
        System.out.println("Leaders (Optimized): " + optimizedLeaders);
    }
}

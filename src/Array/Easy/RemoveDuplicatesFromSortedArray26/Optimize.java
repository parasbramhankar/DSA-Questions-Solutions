package Array.Easy.RemoveDuplicatesFromSortedArray26;
/*

Approach (Plain Steps):

* Read the size of the array and its elements from user input
* If the array has only one or no elements, it's already unique, so print `n` and return
* Use two pointers:
    * `l` (left) points to the last position of the unique subarray
    * `r` (right) traverses the array
* Compare elements at `l` and `r`. If they are different, increment `l` and copy `arr[r]` to `arr[l]`
* This shifts all unique elements to the front of the array
* After the loop, print the first `l + 1` elements as the unique values
* Print `l + 1` as the count of unique elements
 */
import java.util.Scanner;

public class Optimize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Read the array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Edge case: if array has 0 or 1 element, it's already unique
        if (n <= 1) {
            System.out.println(n);
            return;
        }

        // Initialize two pointers
        int l = 0; // Points to position of last unique element
        int r = 1; // Used to scan the array

        // Traverse the array to remove duplicates
        while (r < n) {
            if (arr[l] != arr[r]) {
                l++;              // Move left pointer to next position
                arr[l] = arr[r];  // Copy unique element forward
            }
            r++;
        }

        // Print the unique elements from index 0 to l
        for (int i = 0; i <= l; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println(); // Newline for clean output

        // Print the number of unique elements
        System.out.println(l + 1);
    }
}

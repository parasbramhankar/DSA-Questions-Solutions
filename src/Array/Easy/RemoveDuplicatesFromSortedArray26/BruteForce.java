package Array.Easy.RemoveDuplicatesFromSortedArray26;
/*
Approach (Plain Steps):

* Read an integer n from the user which represents the size of the array
* Create an array of size n and take n elements as input from the user
* Create a HashSet to store unique elements
* Traverse the array and add each element to the HashSet
* Print the contents of the HashSet
* Print the size of the HashSet, which represents the number of unique elements

 */
import java.util.HashSet;
import java.util.Scanner;

public class BruteForce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Read n elements into the array
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create a HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();

        // Add each element of the array to the set
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        // Print the unique elements
        System.out.println(set.toString());

        // Print the count of unique elements
        System.out.println(set.size());
    }

}

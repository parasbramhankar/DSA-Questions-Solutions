package Array.Medium.RotateImage48;

/*

Approach to rotate a matrix 90 degrees clockwise using brute-force:

1. Create a new temporary matrix of the same size as the original (n x n).

2. For each element in the original matrix located at (i, j),
   place it in the new matrix at position (n - 1 - i, j).
   This maps the original position to its new rotated position.

3. Once all elements are placed in the new matrix, copy each row back to the original matrix.
   This ensures the original matrix is updated with rotated values.

4. Time Complexity: O(n^2)
   Space Complexity: O(n^2) (due to extra matrix used)

This is a brute-force approach because it uses extra space to perform the rotation,
instead of modifying the matrix in-place.
*/


// Using Extra Space
import java.util.Scanner;

public class BruteForce {

    // This method rotates the matrix 90 degrees clockwise using a new temporary matrix
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Create a new matrix to store the rotated version
        int[][] arr = new int[n][n];

        // Fill the new matrix with rotated values
        // Each element matrix[i][j] moves to arr[j][n-1-i]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = matrix[n - j - 1][i]; // rotate by 90 degrees clockwise
            }
        }

        // Copy the values from the new matrix back into the original matrix
        // System.arraycopy is used to copy each row efficiently
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, matrix[i], 0, n);
        }
    }

    // Utility method to display the 2D matrix
    static void display(int[][] arr) {
        for (int[] ar : arr) {
            for (int a : ar) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    // Main method to take input, display before and after rotation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Size of n: "); // for an n x n matrix
        int n = scanner.nextInt();

        // Initialize the 2D matrix
        int[][] arr = new int[n][n];

        // Take matrix input from the user
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Before 90 degrees (clockwise) rotate: ");
        display(arr); // display original matrix

        rotate(arr); // rotate the matrix

        System.out.println("After 90 degrees (clockwise) rotate: ");
        display(arr); // display rotated matrix
    }
}


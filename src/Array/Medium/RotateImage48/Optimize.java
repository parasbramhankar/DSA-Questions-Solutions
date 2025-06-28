package Array.Medium.RotateImage48;

/*


✅ Approach to Rotate a Matrix 90 Degrees Clockwise In-Place

🔁 Step 1: Transpose the matrix

> Transposing means converting rows to columns.

* Swap matrix[i][j] with matrix[j][i]

* Only swap values where j > i to avoid undoing previous swaps (or use `j < i` or `j <= i`, depending on how you loop).

Example:

```text
Original:
1 2 3
4 5 6
7 8 9

Transpose (swap matrix[i][j] with matrix[j][i]):
1 4 7
2 5 8
3 6 9
```

 🔁 Step 2: Reverse each row

> After transpose, reverse every row to get the final 90-degree rotated matrix.

Example (from above):
Before reversing rows:
1 4 7
2 5 8
3 6 9

After reversing each row:
7 4 1
8 5 2
9 6 3
---

final answer:
7 4 1
8 5 2
9 6 3


✅ Time and Space Complexity

| Aspect              | Complexity |
| ------------------- | ---------- |
| Time Complexity     | `O(n²)`    |
| Space Complexity    | `O(1)`     |
| In-place operation? | ✅ Yes      |

---

✅ Dry Run Example

Let's take this input:

int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

After Transpose:

1 4 7
2 5 8
3 6 9

After Row Reverse:
7 4 1
8 5 2
9 6 3


## 📌 Summary of Concepts Used

|         Concept           |           Purpose                     |
|    -----------------      |   ---------------------------------   |
|     Matrix Transpose      |       Flip matrix diagonally          |
|     In-place swapping     |         Avoid extra space             |
|       Row reversal        |    Complete 90-degree rotation logic  |
---

 */


//In-place Rotation (Transpose + Reverse)

import java.util.Arrays;
import java.util.Scanner;

public class Optimize {
    // This method reverses the elements in a single row of the matrix
    public static void reverse(int[][] matrix, int row, int n) {
        int left = 0;          // Start pointer
        int right = n - 1;     // End pointer

        // Swap elements at left and right until they meet in the middle
        while (left < right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;

            left++;
            right--;
        }
    }

    // This method rotates the given square matrix 90 degrees clockwise
    public static void rotate(int[][] matrix) {
        int n = matrix.length;  // Size of the matrix (NxN)

        // Step 1: Transpose the matrix
        // Transposing means converting rows into columns
        // Swap matrix[i][j] with matrix[j][i]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // Swap only upper triangle elements to avoid double-swapping
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // After transpose, reversing each row gives the final rotated matrix
        for (int i = 0; i < n; i++) {
            reverse(matrix, i, n);  // Reverse the ith row
        }
    }


   static void display(int[][]arr){
        for(int[]ar:arr){
            for(int a:ar){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Size of n: ");
        int n= scanner.nextInt();
        int[][]arr=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Before 90 degrees (clockwise) rotate: ");
        display(arr);
        rotate(arr);
        System.out.println("After 90 degrees (clockwise) rotate: ");
        display(arr);
    }

}

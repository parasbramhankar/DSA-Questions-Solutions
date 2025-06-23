package Array.Easy.PascalsTraingle118;
/*
✅ Detailed Approach
The goal is to generate the first `numRows` of Pascal's Triangle.

🧠 Pascal's Triangle Properties:

* The first and last elements of each row are `1`.
* Any other element at position `j` in row `i` can be calculated as:

     triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]

✅ Steps:

1. Create an outer list to hold each row (which is itself a list).
2. Loop from `i = 0` to `numRows - 1` (each `i` is a row index).
3. For each row:

   * Create a new list `arr`.
   * Loop through columns `j = 0` to `i`:
     * If `j == 0` or `j == i`, it's a boundary → add 1.
     * Else → use the sum of two elements from the previous row:

       `list.get(i-1).get(j-1) + list.get(i-1).get(j)`

4. Add the constructed row to the outer list.
5. Return the final list of lists.

Time Complexity: `O(numRows²)`
Space Complexity: `O(numRows²)` for storing all elements.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsingDP {

    static public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(); // Outer list to hold all rows

        // Loop to generate each row
        for (int i = 0; i < numRows; i++) {
            List<Integer> arr = new ArrayList<>(); // Create a new row

            // Loop through each element in the current row
            for (int j = 0; j <= i; j++) {
                // First and last elements of each row are always 1
                if (j == 0 || j == i) {
                    arr.add(1);
                } else {
                    // Use values from the previous row to calculate current
                    int value = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                    arr.add(value);
                }
            }

            // Add the constructed row to the triangle
            list.add(arr);
        }

        return list;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int numRows = scanner.nextInt();

        List<List<Integer>> triangle = generate(numRows);

        // Display the triangle row by row
        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }

    }
}

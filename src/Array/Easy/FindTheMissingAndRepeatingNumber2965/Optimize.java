package Array.Easy.FindTheMissingAndRepeatingNumber2965;

/*
✅ APPROACH 1: Mathematical Formula

✅ Step 1: Mathematical Foundation

Let:
S = sum of first n natural numbers = 1 + 2 + 3 + 4 +....+ n= n * (n + 1) / 2
S2 = sum of squares of first n natural numbers = 1^2 + 2^2 + 3^2 + 4^2 +....+ n^2 = n * (n + 1) * (2n + 1) / 6

Let:
S_actual = sum of all elements in the input array
S2_actual = sum of squares of all elements in the input array

Let:
x = missing number
y = repeating number

We know:

Equation 1:
S - S_actual = x - y

Equation 2:
S2 - S2_actual = x^2 - y^2
               = (x - y)(x + y)

Now, divide Equation 2 by Equation 1:
(S2 - S2_actual) / (S - S_actual) = x + y

So now we have:
x - y → from Equation 1
x + y → from the above division

Now solve using basic algebra:
x = ((x - y) + (x + y)) / 2
y = x - (x - y)
-----------------------------------------
Input: [4, 3, 6, 2, 1, 1]

✅ Output:

Missing Number = 5
Repeating Number = 1

✅ Time & Space Complexity

| Complexity | Value |
| ---------- | ----- |
| Time       | O(n)  |
| Space      | O(1)  |




🧠 Why use long?
To avoid integer overflow for large n (especially with square sums),
long is safer when computing sums and products.
*/

public class Optimize {

    // Function to find the missing and repeating number in a 2D array
    public static int[] findMissingAndRepeating(int[][] arr2D) {
        // Step 1: Flatten 2D array into 1D array and count total elements
        int n = 0;
        for (int[] row : arr2D) {
            n += row.length;
        }

        // Step 2: Expected sum and square sum for numbers 1 to n
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        // Step 3: Actual sum and square sum from the 2D array
        long actualSum = 0;
        long actualSquareSum = 0;

        for (int[] row : arr2D) {
            for (int num : row) {
                actualSum += num;
                actualSquareSum += (long) num * num;
            }
        }

        // Step 4: Compute differences
        long diff = expectedSum - actualSum; // x - y
        long sqDiff = expectedSquareSum - actualSquareSum; // x^2 - y^2

        // Step 5: Calculate x + y
        long sumXY = sqDiff / diff;

        // Step 6: Solve for missing (x) and repeating (y)
        long missing = (diff + sumXY) / 2;
        long repeating = missing - diff;

        return new int[]{(int) missing, (int) repeating};
    }

    // Main function to test the method
    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 3, 6},{ 2, 1, 1}};

        int[]result=findMissingAndRepeating(arr);
        System.out.println("Missing Number = " + result[0]);
        System.out.println("Repeating Number = " + result[1]);
    }

}

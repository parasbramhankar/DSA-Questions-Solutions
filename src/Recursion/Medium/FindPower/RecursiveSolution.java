package Recursion.Medium.FindPower;

import java.util.Scanner;

/**
  RecursiveSolution.java
  ----------------------
  Purpose:
    - Compute base^exponent (base to the power exponent) using a fast recursive approach
      (exponentiation by squaring).
    - Handles negative exponents by converting them to positive and inverting the base.

  Key ideas / logic:
    1. If exponent is negative: base^(-e) = (1/base)^e. So flip the base to 1/base and make
       the exponent positive.
    2. Use recursion (power method) to compute base^n:
       - Base case: n == 0 -> return 1.0
       - Recurse on half: half = power(base, n/2)
       - If n is even: result = half * half
       - If n is odd:  result = half * half * base
       This reduces the number of multiplications from O(n) to O(log n).
    3. Time complexity: O(log n) where n = |exponent|
       Space complexity: O(log n) due to recursion call stack depth.

  Important note about integer limits (edge case):
    - If exponent == Integer.MIN_VALUE (-2^31), negating it as an int overflows.
      To be safe, store exponent in a long and negate that long: long N = exponent; if (N < 0) N = -N;
      The implementation below uses 'long N = exponent' to avoid overflow for -2^31.

  Example dry-runs (step-by-step traces are shown below; you can paste these comments directly
  into your .java file in IntelliJ IDEA):

  DRY RUN 1 (positive exponent)
    Input: base = 2.0, exponent = 10
    Execution trace (call -> return value):
      myPow(2.0, 10):
        N = 10 (positive) -> call power(2.0, 10)
          power(2.0, 10):
            -> compute half = power(2.0, 10 / 2) = power(2.0, 5)
              power(2.0, 5):
                -> compute half = power(2.0, 5 / 2) = power(2.0, 2)
                  power(2.0, 2):
                    -> compute half = power(2.0, 2 / 2) = power(2.0, 1)
                      power(2.0, 1):
                        -> compute half = power(2.0, 1 / 2) = power(2.0, 0)
                          power(2.0, 0) returns 1.0  // base case
                        half = 1.0
                        n = 1 is odd -> return 1.0 * 1.0 * 2.0 = 2.0
                      power(2.0, 1) returns 2.0
                    half = 2.0
                    n = 2 is even -> return 2.0 * 2.0 = 4.0
                  power(2.0, 2) returns 4.0
                half = 4.0
                n = 5 is odd -> return 4.0 * 4.0 * 2.0 = 32.0
              power(2.0, 5) returns 32.0
            half = 32.0
            n = 10 is even -> return 32.0 * 32.0 = 1024.0
          power(2.0, 10) returns 1024.0
      myPow returns 1024.0
    Final output: 2.0^10 = 1024.0

  DRY RUN 2 (negative exponent)
    Input: base = 2.0, exponent = -3
    Execution trace:
      myPow(2.0, -3):
        N = -3 -> since negative:
          base = 1 / base = 1 / 2.0 = 0.5
          N = -N = 3  // now positive
        call power(0.5, 3)
          power(0.5, 3):
            -> half = power(0.5, 3 / 2) = power(0.5, 1)
              power(0.5, 1):
                -> half = power(0.5, 1 / 2) = power(0.5, 0)
                  power(0.5, 0) returns 1.0
                half = 1.0
                n = 1 (odd) -> return 1.0 * 1.0 * 0.5 = 0.5
              power(0.5, 1) returns 0.5
            half = 0.5
            n = 3 (odd) -> return 0.5 * 0.5 * 0.5 = 0.125
          power(0.5, 3) returns 0.125
      myPow returns 0.125
    Final output: 2.0^-3 = 0.125
*/

public class RecursiveSolution {

    /**
     * Computes base^exponent using recursion (exponentiation by squaring).
     *
     * @param base the base value (double)
     * @param exponent the exponent (int). Can be negative.
     * @return base raised to the power exponent as a double
     */
    public static double myPow(double base, int exponent) {
        // Use long to avoid overflow when exponent == Integer.MIN_VALUE (-2^31).
        long N = exponent;

        // If exponent is negative, convert to positive and invert base:
        // base^(-N) = (1/base)^N
        if (N < 0) {
            base = 1 / base;
            N = -N; // safe because N is long
        }

        return power(base, N);
    }

    /**
     * Recursive helper that computes base^n where n is non-negative.
     * Uses divide-and-conquer:
     *   - Compute half = power(base, n/2)
     *   - If n even: result = half * half
     *   - If n odd:  result = half * half * base
     *
     * @param base the base value
     * @param n non-negative exponent (long)
     * @return base^n
     */
    public static double power(double base, long n) {
        // Base case: anything^0 is 1
        if (n == 0) {
            return 1.0;
        }

        // Recursively compute base^(n/2)
        double half = power(base, n / 2);

        // If n is even: (base^(n/2))^2
        if (n % 2 == 0) {
            return half * half;
        }
        // If n is odd: multiply by an extra base
        else {
            return half * half * base;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base: ");
        double base = scanner.nextDouble();

        System.out.println("Enter the exponent: ");
        int exponent = scanner.nextInt();

        double baseToPowerExponent = myPow(base, exponent);

        System.out.println(base + "^" + exponent + " = " + baseToPowerExponent);

        // Good practice: close the scanner to free resources
        scanner.close();
    }
}


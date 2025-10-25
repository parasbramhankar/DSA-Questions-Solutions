package Recursion.Medium.CountGoodNumbers1922;

import java.util.Scanner;

import java.util.Scanner;

/*
  IterativeSolution.java
  ----------------------
  Purpose:
    - To calculate the total number of "good numbers" of length N
      using modular exponentiation with recursion (fast power / exponentiation by squaring).
    - This is a common problem pattern in competitive programming.

  Problem idea (from Leetcode: Count Good Numbers):
    - A "good number" of length N is formed such that:
        - Digits at even indices (0, 2, 4, …) can be one of 5 possible values: {0, 2, 4, 6, 8}.
        - Digits at odd indices (1, 3, 5, …) can be one of 4 possible values: {2, 3, 5, 7}.
    - Hence:
        - Number of even positions = ceil(N / 2)
        - Number of odd positions  = floor(N / 2)
    - Total combinations = (5^(#even positions)) * (4^(#odd positions)) % MOD

  Key Concepts:
    1. Modular exponentiation is used to handle large exponents efficiently and avoid overflow.
       Formula: (a * b) % m = ((a % m) * (b % m)) % m
    2. Exponentiation by squaring (fast power):
       - Reduces time complexity from O(n) → O(log n)
       - Recursive relation:
            if expo == 0 → return 1
            half = power(num, expo / 2)
            if expo even → return (half * half) % MOD
            if expo odd  → return (half * half * num) % MOD
    3. Modulo constant (MOD = 1e9 + 7) is used as required in most competitive programming questions
       to keep results within 32-bit integer range.

  Complexity Analysis:
    - Time Complexity: O(log N)
    - Space Complexity: O(log N) (due to recursion depth)

  -----------------------------------------------------------------------------------
  DRY RUN 1:
    Input: N = 1
    odd = N / 2 = 0
    even = (N + 1) / 2 = 1
    evenPower = power(5, 1) = 5
    oddPower = power(4, 0) = 1
    Result = (5 * 1) % MOD = 5

    Output → "The total number of good numbers are: 5"

  -----------------------------------------------------------------------------------
  DRY RUN 2:
    Input: N = 2
    odd = 2 / 2 = 1
    even = (2 + 1) / 2 = 1
    evenPower = power(5, 1) = 5
    oddPower = power(4, 1) = 4
    Result = (5 * 4) % MOD = 20

    Output → "The total number of good numbers are: 20"

  -----------------------------------------------------------------------------------
  DRY RUN 3:
    Input: N = 50
    odd = 25
    even = 25
    evenPower = 5^25 % MOD (computed efficiently)
    oddPower  = 4^25 % MOD (computed efficiently)
    Result = (evenPower * oddPower) % MOD
    Output is a large number, but computed in O(log 25) steps per power function.

  This method ensures the program can handle very large N efficiently.
*/

public class IterativeSolution {

    // Constant MOD value (1e9 + 7) used to keep numbers within manageable range
    public static final long MOD = 1000000007;

    /**
     * Calculates the total number of good numbers of length n.
     *
     * @param n the length of the number
     * @return the total count of good numbers modulo MOD
     */
    public static int findGoodNumbers(int n) {

        // odd positions = n / 2
        long odd = n / 2;

        // even positions = (n + 1) / 2
        long even = (n + 1) / 2;

        // compute (5 ^ even) % MOD and (4 ^ odd) % MOD using fast power
        long evenPower = power(5, even);
        long oddPower = power(4, odd);

        // multiply under modulo
        return (int) ((evenPower * oddPower) % MOD);
    }

    /**
     * Computes (num ^ expo) % MOD using recursive fast exponentiation.
     *
     * @param num  the base
     * @param expo the exponent
     * @return (num ^ expo) % MOD
     */
    public static long power(int num, long expo) {

        // Base case
        if (expo == 0) return 1;

        // Recursive case
        long half = power(num, expo / 2);

        // If exponent is even → (num^(expo)) = (num^(expo/2))^2
        if (expo % 2 == 0) {
            return (half * half) % MOD;
        }
        // If exponent is odd → multiply once more with base
        else {
            return (half * half * num) % MOD;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of N");
        int N = scanner.nextInt();

        int ans = findGoodNumbers(N);

        System.out.println("The total number of good numbers are: " + ans);

        // Close scanner to prevent resource leak
        scanner.close();
    }
}

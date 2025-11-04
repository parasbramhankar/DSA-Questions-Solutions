package Recursion.Easy.AddDigits258;


import java.util.Scanner;

/**
 * Approach:
 *
 * This implementation solves the "Add Digits" (LeetCode 258) problem in O(1) time
 * by using the mathematical property of the digital root.
 *
 * Logic:
 * 1. For any integer 'num', the result of repeatedly adding its digits until one digit remains
 *    (the digital root) can be directly calculated without loops or recursion.
 * 2. If 'num' is 0, return 0, as that's already single-digit.
 * 3. For non-zero numbers:
 *      - If num % 9 == 0, the answer is 9.
 *      - Otherwise, the answer is num % 9.
 *    This works because the digital root of a positive integer is always either 9 (for multiples of 9)
 *    or num % 9 otherwise.
 * 4. This approach exploits number theory and is known as the digital root formula,
 *    which avoids repeated digit extraction and addition.
 *
 * Examples:
 * - Input: num = 38 → Output: 2 (38 → 3+8=11 → 1+1=2)
 * - Input: num = 9  → Output: 9 (9 is a multiple of 9)
 * - Input: num = 0  → Output: 0
 *
 * Time Complexity: O(1) (no loops/recursion)
 * Space Complexity: O(1)
 *
 */

public class MostOptimizeSolution {

    static int solution(int num){
        if(num==0){
            return 0;
        }else if(num%9!=0){
            return num%9;
        }
        else {
            return 9;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num=scanner.nextInt();

        int sumOfDigits=solution(num);

        System.out.println("Sum: "+sumOfDigits);
    }
}
/**
 The digital root of a number is the single-digit value obtained by repeatedly
 summing the digits of the number until only one digit remains.
 This process may be repeated multiple times: you add up all digits of the number,
 and if the sum is more than one digit, you add the digits of the sum again,
 continuing until the result is a single digit.

 For example, the digital root of 12345 is calculated as follows:
 - 1 + 2 + 3 + 4 + 5 = 15
 - Then sum the digits of 15: 1 + 5 = 6
 So, the digital root of 12345 is 6.

 Mathematically, the digital root in base 10 is closely related to the remainder
 when dividing the number by 9. Specifically:
 - If the number is 0, its digital root is 0.
 - If the number is divisible by 9 and not zero, its digital root is 9.
 - Otherwise, the digital root is the remainder of the number divided by 9.

 This property is useful for quick calculations and divisibility rules.
 The digital root is also known as the repeated digital sum.

 In summary, the digital root is a way to reduce a number to a single digit by
 repeated addition of its digits, with a neat mathematical relationship to modulo 9
 arithmetic.

 */
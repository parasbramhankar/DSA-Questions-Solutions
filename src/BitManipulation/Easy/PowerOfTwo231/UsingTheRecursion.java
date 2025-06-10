package BitManipulation.Easy.PowerOfTwo231;

import java.util.Scanner;

public class UsingTheRecursion {

    public static boolean isPowerOfTwo(int n) {
        // Base cases
        if (n <= 0) return false;    // Negative numbers and 0 are not powers of two
        if (n == 1) return true;     // 2^0 = 1

        // If n is not divisible by 2, it's not a power of 2
        if (n % 2 != 0) return false;

        // Recursive call with n divided by 2
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num=scanner.nextInt();


        if (isPowerOfTwo(num)) {
            System.out.println(num + " is a power of two.");
        } else {
            System.out.println(num + " is NOT a power of two.");
        }
    }


}

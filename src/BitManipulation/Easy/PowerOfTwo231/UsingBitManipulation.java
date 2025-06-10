package BitManipulation.Easy.PowerOfTwo231;

import java.util.Scanner;

public class UsingBitManipulation {

    // Function to check if a number is power of two using bit manipulation
    public static boolean isPowerOfTwo(int n) {
        // A number is a power of two if:
        // 1. It is greater than 0
        // 2. It has only one-bit set in binary representation
        return n > 0 && (n & (n - 1)) == 0;
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

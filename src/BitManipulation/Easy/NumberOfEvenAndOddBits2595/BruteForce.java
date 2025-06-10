package BitManipulation.Easy.NumberOfEvenAndOddBits2595;

import java.util.Scanner;

public class BruteForce {

    public int[] evenOddBit(int n) {
        int even = 0;
        int odd = 0;

        String binary = Integer.toBinaryString(n); // convert to binary string

        int len = binary.length();

        // LSB is at the rightmost position, so we iterate from right to left
        for (int i = 0; i < len; i++) {
            char bit = binary.charAt(len - 1 - i); // right to left
            if (bit == '1') {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }

        return new int[]{even, odd};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        BruteForce sol = new BruteForce();
        int[] result = sol.evenOddBit(n);

        System.out.println("Even-position 1's count: " + result[0]);
        System.out.println("Odd-position 1's count: " + result[1]);
    }
}

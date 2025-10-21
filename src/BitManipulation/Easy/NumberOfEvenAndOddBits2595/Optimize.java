package BitManipulation.Easy.NumberOfEvenAndOddBits2595;

import java.util.Scanner;

/*
Number of Even and Odd Bits

You are given a positive integer n.
Let even denote the number of even indices in the binary representation of n with value 1
Let odd denote the number of odd indices in the binary representation of n with value 1.
Note that bits are indexed from right to left in the binary representation of a number.
Return the array [even, odd].


Example 1:
Input: n = 50
Output: [1,2]
Explanation:
The binary representation of 50 is 110010.
It contains 1 on indices 1, 4, and 5.


Example 2:
Input: n = 2
Output: [0,1]
Explanation:
The binary representation of 2 is 10.
It contains 1 only on index 1.

Constraints:
1 <= n <= 1000
 */
public class Optimize {

/*
    public int[] evenOddBit(int n) {
        int even=0;
        int odd=0;

        for(int i=0;i<32;i++){
            if((n&1)!=0){
                if(i%2==0){
                    even++;
                }else{
                    odd++;
                }
            }

            n=n>>1;
        }

        return new int[]{even,odd};
    }
    */

        public int[] evenOddBit(int n) {
            int odd = 0;
            int even = 0;
            int count = 0;

            while (n > 0) {
                if ((n & 1) == 1) {
                    if (count % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }
                n >>= 1;
                count++;
            }

            return new int[]{even, odd};
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter an integer: ");
            int n = scanner.nextInt();

            Optimize sol = new Optimize();
            int[] result = sol.evenOddBit(n);

            System.out.println("Even-position 1's count: " + result[0]);
            System.out.println("Odd-position 1's count: " + result[1]);
        }
    }


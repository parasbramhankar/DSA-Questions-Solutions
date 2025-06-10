package BitManipulation.Easy.FirstSetBit;

/*
Given an integer n. The task is to return the position of the first set bit found from the right side in the binary representation of the number.

Note: If there is no set a bit in the integer N, then return 0 from the function.


Examples:

Input: n = 18
Output: 2
Explanation: Binary representation of 18 is 010010,the first set bit from the right side is at position 2.
*/


import java.util.Scanner;

public class FirstSetBit {

    static int firstSetBitPosition(int num){

        int count=0;

        while(num>0){
            count++;
            if((num&1)==1){
                break;
            }
            num>>=1;
        }

        return count;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int num= scanner.nextInt();

        int pos=firstSetBitPosition(num);

        System.out.println("The First set Bit from right side is at: "+pos);

    }


}

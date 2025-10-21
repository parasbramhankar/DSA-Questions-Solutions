package BitManipulation.Easy.CheckKthBit_setOrNot;

import java.util.Scanner;

public class Solution {
    static boolean checkSetBit(int n, int k) {
        // Method 1: Using right shift
        // return (((n >> (k - 1)) & 1) != 0);

        // Method 2: Using AND with mask
        return ((n & (1 << (k - 1))) != 0);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter any number: ");
        int n= scanner.nextInt();

        System.out.println("Enter the value of the k: ");
        int k=scanner.nextInt();

        if(checkSetBit(n,k)){
            System.out.println(k+"th bit is set");
        }else{
            System.out.println(k+"th bit is not set");
        }
    }
}

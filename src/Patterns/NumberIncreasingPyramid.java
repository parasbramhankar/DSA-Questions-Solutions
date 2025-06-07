package Patterns;

import java.util.Scanner;

public class NumberIncreasingPyramid {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=n;i++){

            for(int space=1;space<=n-i;space++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }

            System.out.println();
        }
    }
}

package Patterns;

import java.util.Scanner;

public class RhombusPattern {
    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=n;i++){

            for(int space=1;space<=i-1;space++){
                System.out.print(" ");
            }

            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

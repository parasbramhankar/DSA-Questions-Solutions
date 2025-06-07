package Patterns;

import java.util.Scanner;

public class AlphaRamp {
    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=n;i++){

            char ch=(char)('A'+(i-1));

            for(int j=1;j<=i;j++){

                System.out.print(ch+" ");

            }

            System.out.println();

        }
    }
}

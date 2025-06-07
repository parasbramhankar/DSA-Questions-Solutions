package Patterns;

import java.util.Scanner;

public class AlphaTriangle {
    public static void main(String[] args) {


        int n = new Scanner(System.in).nextInt();

        for (int i = 1; i <= n; i++) {

            char ch=(char)('A'+n-i);

            for(char ch1=ch;ch1<'A'+n;ch1++){
                System.out.print(ch1+" ");
            }

            System.out.println();
        }
    }
}

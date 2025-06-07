package Patterns;

import java.util.Scanner;

public class ReverseLetterTriangle {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=n;i++){

            for(char ch='A';ch<=(char)('A'+(n-i)); ch++){
                System.out.print(ch+" ");
            }

            System.out.println();
        }
    }
}

package Patterns;

import java.util.Scanner;

public class InvertedStarPyramid {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n= scanner.nextInt();

        for(int i=1;i<=n;i++){
            for(int sp=1;sp<=i-1;sp++){
                System.out.print(" ");
            }

            for(int j=1;j<=2*(n-i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}

package Patterns;

import java.util.Scanner;

public class NumberCrown {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }

            for(int sp=1;sp<=2*(n-i);sp++){
                System.out.print(" ");
            }

            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }

        scanner.close();
    }
}

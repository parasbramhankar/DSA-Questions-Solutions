package Patterns;

import java.util.Scanner;

public class SymmetricVoid {

    public static void upper(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }

            for(int space=1;space<=2*i-2;space++){
                System.out.print(" ");
            }

            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void lower(int n){

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int space=1;space<=2*n-2*i;space++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            System.out.println();

        }
    }
    public static void main(String[] args) {

        int n=new Scanner(System.in).nextInt();


        upper(n);
        lower(n);

    }
}

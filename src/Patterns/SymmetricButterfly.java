package Patterns;

import java.util.Scanner;

public class SymmetricButterfly
{
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();

        for(int i=1;i<=2*n-1;i++){

            int count=i;
            int space=2*n-2*i;

            if(i>n){
                count=2*n-i;
                space=2*i-2*n;
            }

            for(int j=1;j<=count;j++){
                System.out.print("*");
            }

            for(int sp=1;sp<=space;sp++){
                System.out.print(" ");
            }
            for(int j=1;j<=count;j++){
                System.out.print("*");
            }

            System.out.println();
        }


    }
}
